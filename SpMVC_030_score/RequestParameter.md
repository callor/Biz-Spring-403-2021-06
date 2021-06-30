# Client에서 Request 파라메터 보내기

## Link(a tag), script의 location.href=를 통해서 Request 할때
* URL?변수=값 형태로 전송
* URL?변수1=값&변수=값&변수3=값  

* 이때 전송되는 데이터는 변수, 값 구분없이 무조건 문자열로 전송이 된다  
이런 type 의 파라메트(Parameter)를 Query String 이라고 한다

* form에 입력된 데이터를 method=GET 방식으로 보낼때도 같다  
URL을 포함하여 전체 문자열이 256자를 넘으면 잘린다  
Query String이 client(web browser)의 주소창에 노출된다  
쉽게 가로채기(데이터 탈취)를 하기 쉽다  
데이터를 암호화 하기가 매우 어렵다

## form에 담긴 데이터를 method=POST로 보낼때
* 데이터가 HTTP 프로토콜의 Body에 담겨서 전달된다  
Body 영력을 정보통신에서는 payload 영역이라고 한다  
이론상의 데이터크기가 제한이 없다  
데이터를 암호화 하기가 쉽다.  
데이터가 전송되는 동안에 감추기가 쉽다.  
body Parameter 라고 부른다

## Spring에서 파라메터 받기
* 변수개수가 1 ~ 2개 정도 일때는 String, primitve 형식으로 매개변수를  
선언해 두면 자동으로 변수값을 받을 수 있다.

* VO, DTO 클래스를 선언하고, query String, body Parameter의 이름과 같은 변수들을 갖도록 만들어서,  
VO, DTO를 파라메터로 선언해 두면 자동으로 각각의 변수에 값을 채워서 받을 수 있다

## 파라메터 설정과 Client에서의 데이터 설정 주의
* query string, body parameter관계 없이 client에서 데이터를 보낼때는  
특별한 언급이 없는 한 모두 문자열 형식이다

* 만약 client에서 보낸 데이터가 숫자형이고, ValueOf, Parse* 등을 사용하여 형변환이 가능하다면,  
매개변수를 선언할때, String 이외의 타입으로 선언 가능하다

* age=33 이라고 전송을 하고,  
age라는 변수에는 절대 숫자형 이외의 데이터가 담겨서 전송되지 않는다 라는 보장이 있으면  
method(int age) 처럼 매개변수를 선언하고 데이터를 받을 수 있다.

* 이때 만약 age='' 또는 age='A' 와 같은 데이터가 전송된다면 client는 400 오류를 만나게 된다.

* 대량의 데이터를 한꺼번에 입력받고 서버로 전송하여 처리를 해야 하는 경우  
고유의 데이터 타입보다는 String형 데이터 타입으로 파라메터를 선언하고,  
이후에 적절한 데이터 타입으로 변환하여 사용하는 것도 좋은 방법이다


