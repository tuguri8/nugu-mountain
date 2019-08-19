## NUGU Mountain

- NUGU Play 개발 공모전 하반기 - NUGU Mountain
- 산림청을 통한 산의 정보를 제공하고, 실시간 산불위험지수, 실시간 날씨, 미세먼지 정보를 통해 실시간 등산 가능 여부와 산을 추천해 안전한 등산을 가능케 하는 등산객들을 위한 Play

## Introduce Document

[PDF](./nugu_mountain.pdf)

## Environment

- Spring Boot
- H2

## Usage

**Gradle Build**

```
./gradlew build
```

**Start Project**

```
cd build/libs
java -jar api-0.0.1-SNAPSHOT.jar
```

## License

[Apache License 2.0](./LICENSE)

## Resources

- [Spring Boot](https://github.com/spring-projects/spring-boot)
- [H2](http://www.h2database.com/html/license.html)
- [Spring Cloud](https://spring.io/projects/spring-cloud)
- [Apache Commons](https://commons.apache.org/)
- [T map Full Text Geocoding API](https://openapi.sk.com/resource/apidoc/indexView)
- [Weather Planet 간편날씨 API](https://openapi.sk.com/resource/apidoc/indexView)
- [에어코리아 미세먼지 API](http://openapi.airkorea.or.kr/)
- [산림청 산 정보 API](https://www.data.go.kr/dataset/3044591/openapi.do)
- [산림청 산불위험지수 API](http://know.nifos.go.kr/know/service/forestPoint/forestPointApiSpc.do?opt=2&tab=9&subTab=2)
