package team.sparta.file.filereader.domain.dto

import team.sparta.file.filereader.domain.Wine

data class WineData(
    var originIdx:Int = 0,
    var name:String="",
    var sweetness: Int = 0,
    var acidity: Int = 0,
    var body: Int = 0,
    var tannin: Int = 0,
    var type: String = "",
    var aroma: Map<String,List<String>> = mutableMapOf(),
    var price: Int? = 0,
    var kind: String? = "",
    var style: String? = "",
    var country: String? = "",
    var region: String? = "",
    var embedding: String? = null,
){
    companion object{
        fun toEntity(wineData:WineData): Wine {
            return Wine(
                name=wineData.name,
                sweetness = wineData.sweetness,
                acidity = wineData.acidity,
                body = wineData.body,
                tannin = wineData.tannin,
                type = wineData.type,
                aroma = wineData.aroma.toString(),
                price = wineData.price,
                kind = wineData.kind,
                style = wineData.style,
                country = wineData.country,
                region = wineData.region,
            )
        }
    }
}