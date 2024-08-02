### Json → H2 DB 저장과 H2 DB드라이버 역할을 하는 프로그램입니다.

service의 `startFileReader` 가 핵심이며, 해당 함수에서 볼 부분입니다.

```jsx
val file = File("/Users/t2023-m0097/Desktop/wines_data/wine_data_${index}.json")
//공유드린 Json을 읽어오기 위한 경로를 설정합니다.
//현재는 저의 컴퓨터에 맞는 경로로 되어 있으니, 함수를 실행시키기 위해서
//경로를 재설정 해주셔야 합니다.

 if (!hash.contains(hashName)
      && it.aroma.isNotEmpty()
      && it.aroma.none { key -> key.toString().contains("food-") }) {
      hash.add(hashName)
      resultList.add(it)
      ++pushRowCnt
  } else {
      logger.info("PassData : {}", it.toString())
  }
//Json 파일을 H2 DB로 저장할때, 조건에 맞게 후처리를 해주는 부분입니다.
//조건을 추가하고 싶거나, 빼고 싶다면 이곳을 리팩토링 하시면 됩니다.
```
