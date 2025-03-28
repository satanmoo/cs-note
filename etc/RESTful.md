# RESTful

- URL 규약
    - 서로 다른 시스템과 통신하기 위한 규칙

- HATEOAS(Hypermedia As The Engine of Application State)
    - OS가 싫어요?
    - 응답 JSON에 하이퍼미디어 링크를 포함
    - 클라이언트는 어떤 액션을 취할 수 있는지 알 수 있음
    - 여기까지 지키는 경우는 보지 못했음

- URL을 리소스 단위로 인식
    - 리소스는 명사로 URL에 포함
    - 리소스에 대한 연산은 HTTP 프로토콜의 매서드
        - GET, POST, PUT, PATCH, DELETE
            - 1.0부터 되는 GET, POST 위주로 쓰는게 좋다고 생각함
                - 나머지는 1.1부터
                - 예전 브라우저는 지원 안 할수도..
        - 동사를 URL에 포함하지 않고 HTTP 매서드로 제한
            - 그냥 POST 쓰고 동사 넣는게 개념적으로 명확할 때가 있음
    - 계층화된 리소스
        - 폴더 구조
        - 데이터 베이스 설계부터 시작
            - 정규화를 잘하자
                - 정규화의 부작용이 있다면, 반정규화해서 json 처럼 만들고 memcache로 처리하는게 좋지 않을까
            - 테이블 관계가 얽혀있으면 URL에 표현하기 애매할 때가 많음
        - DDD aggregate root 랑 비슷한 맥락
    - URL을 보고 어떤 동작을 하는지 유추하기 좋음
    - integration, 유지보수에 유리
    - URL에 쿼리 파라매터로 필터 넣는 방법도 널리 쓰임
        - `?select=task.id,user.id`

- 무상태
    - 서버 사이드 확장에 유리함
        - 상태를 서버에서 기억하려면 sticky session
            - db에서 세션 정보 읽어오는 불편함
    - auth token이 대표적인 예

- 반환 코드
