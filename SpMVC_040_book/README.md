# Naver OpenAPI 검색 프로젝트
* Naver OpenAPI를 활용한 도서, 영화, 뉴스 검색 프로젝트

## Naver OpenAPI 등록
* 네이버 개발자센터 개발자 등록
* 내 애플리케이션 등록

## 서비스 Config
* Client Id, Client Secret 확인
* NaverSecret 클래스에 값 등록
* .gitignore에 해당 클래스 업로드 금지 설정

## 서비스 설정
* queryURL(), jsonString(), getNaverList() method 구현


## lombok과 Qualifier 설정
* lombok의 @RequiredArgsConstructor 설정으로 bean을 주입받으면
* @Qualifier로 설정된 이름을 인식 하지 않는다
* src/main/java 폴더에 lombok.config 파일을 생성한다
* lombok.copyableAnnotations += org.springframework.beans.factory.annotation.Qualifier 를 작성한 후 저장하고 프로젝트 All cleaning 실시후 재 시작






