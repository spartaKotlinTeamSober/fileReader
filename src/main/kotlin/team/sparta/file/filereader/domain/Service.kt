package team.sparta.file.filereader.domain

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import team.sparta.file.filereader.domain.dto.WineData
import java.io.File
import java.util.*

@Service
class Service @Autowired constructor(
    private val gson: Gson,
    private val repository: Repository
)  {

    val logger: Logger = LoggerFactory.getLogger(this::class.java)
    fun startFileReader():Boolean{
        val hash= hashSetOf<String>()
        var pushRowCnt=0
        var tryRowCnt=0
        try {
            for (index in 1..100) {
                val file = File("/Users/t2023-m0097/Desktop/wines_data/wine_data_${index}.json")
                val json = file.readText(Charsets.UTF_8)
                val listType = object : TypeToken<List<WineData>>() {}.type
                val dataList: List<WineData> = gson.fromJson(json, listType)

                val resultList = mutableListOf<WineData>()
                dataList.forEach {
                    ++tryRowCnt
                    val hashName = it.name.lowercase(Locale.getDefault()).filter { c -> c.isLetter() }
                    if (!hash.contains(hashName)
                        && it.aroma.isNotEmpty()
                        && it.aroma.none { key -> key.toString().contains("food-") }) {
                        hash.add(hashName)
                        resultList.add(it)
                        ++pushRowCnt
                    } else {
                        logger.info("PassData : {}", it.toString())
                    }
                }
                saveData(resultList.map { WineData.toEntity(it) })
                logger.info("save to : wine_data_{}", index)
            }
        }catch (e:Exception){
            return false
        }
        logger.info("Try Row is : {}", tryRowCnt)
        logger.info("Push Row is : {}", pushRowCnt)
        return true
    }

    fun saveData(winesData:List<Wine>){
        repository.saveAllAndFlush(winesData)
    }
}