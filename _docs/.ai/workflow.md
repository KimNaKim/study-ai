# Feature Implementation Workflow

## Description
새로운 도메인 기능을 구현할 때 `spring-dev` 에이전트가 수행해야 하는 표준 작업 절차입니다.

## Steps

1. **Domain Analysis & Package Setup**
   - 요구사항에 맞는 도메인 이름 결정.
   - `src/main/java/com/example/demo/{domain}` 하위에 `controller`, `service`, `repository`, `entity`, `dto` 패키지 생성.

2. **Entity Implementation**
   - `entity` 패키지에 DB 테이블과 매핑될 Entity 클래스 작성.
   - `spring-conventions`의 Entity 규칙(Setter 금지, protected 생성자) 적용.

3. **Repository Implementation**
   - `repository` 패키지에 `JpaRepository`를 상속받는 인터페이스 작성.

4. **DTO Implementation**
   - `dto` 패키지에 요청(Request) 및 응답(Response) DTO 작성.
   - 데이터 전송에 필요한 필드만 정의.

5. **Service Implementation**
   - `service` 패키지에 비즈니스 로직 작성.
   - `@Transactional` 적용 및 Entity-DTO 변환 로직 구현.

6. **Controller Implementation**
   - `controller` 패키지에 API 엔드포인트 작성.
   - Service 주입 및 Swagger 문서화 적용.
   - `Resp` 클래스(존재 시)를 활용하여 통일된 응답 포맷 반환.
