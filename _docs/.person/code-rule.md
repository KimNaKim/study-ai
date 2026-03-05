# 프로젝트 코드 컨벤션 (Project Code Convention)

본 문서는 `src/main/java` 하위의 `board`, `user` 등 도메인별 패키지 구조를 따르는 프로젝트의 개발 표준을 정의합니다.

## 1. 패키지 구조 (Package Structure)

기능(Domain) 기반의 패키지 구조를 사용합니다. 관련된 클래스들은 응집도를 높이기 위해 같은 패키지에 위치시킵니다.

```text
src/main/java/com/example/demo
├── board               # 게시판 도메인
│   ├── controller      # 웹 계층 (Controller)
│   ├── service         # 비즈니스 로직 (Service)
│   ├── repository      # 데이터 접근 (Repository)
│   ├── entity          # DB 엔티티 (Entity)
│   └── dto             # 데이터 전송 객체 (DTO)
├── user                # 사용자 도메인
│   ├── ... (board와 동일한 하위 구조)
└── global              # 전역 공통 설정 (Config, Exception, Utils)
```

## 2. 네이밍 규칙 (Naming Conventions)

| 구분 | 규칙 | 예시 |
| --- | --- | --- |
| **Class / Interface** | PascalCase | `BoardService`, `UserEntity` |
| **Method / Variable** | camelCase | `getBoardList()`, `userName` |
| **Constant** | UPPER_SNAKE_CASE | `MAX_LOGIN_RETRY`, `DEFAULT_PAGE_SIZE` |
| **DB Table** | snake_case | `board_comment`, `users` |

## 3. 계층별 역할 및 규칙 (Layer Rules)

### 3.1 Controller (`*Controller`)
- 클라이언트의 요청을 받고 응답을 반환하는 역할만 수행합니다.
- 비즈니스 로직을 포함하지 않으며, Service 계층을 호출합니다.
- DTO를 통해 데이터를 주고받습니다 (Entity 직접 반환 금지).

### 3.2 Service (`*Service`)
- 핵심 비즈니스 로직을 구현합니다.
- 트랜잭션 관리(`@Transactional`)를 담당합니다.
- Entity를 DTO로 변환하는 로직을 포함할 수 있습니다.

### 3.3 Repository (`*Repository`)
- DB 접근을 담당하며, JpaRepository를 상속받아 사용합니다.
- 복잡한 쿼리는 QueryDSL 등을 사용하여 별도 구현체로 분리하는 것을 권장합니다.

### 3.4 Entity (`*Entity` or Domain Name)
- 데이터베이스 테이블과 매핑되는 객체입니다.
- Setter 사용을 지양하고, 명확한 의도를 가진 메서드(예: `updateTitle()`)를 사용합니다.
- 기본 생성자는 `protected`로 설정하여 무분별한 생성을 방지합니다 (`@NoArgsConstructor(access = AccessLevel.PROTECTED)`).

### 3.5 DTO (`*Dto`, `*Request`, `*Response`)
- 계층 간 데이터 교환을 위한 객체입니다.
- Java `record` 사용을 권장하거나, Lombok의 `@Data` 혹은 `@Getter`를 사용합니다.

## 4. 코드 스타일 및 기타 (Code Style)

- **Lombok 사용**: 생성자 주입 시 `@RequiredArgsConstructor`를 적극 활용합니다.
- **들여쓰기**: Space 4칸을 원칙으로 합니다.
- **주석**: 클래스와 복잡한 로직의 메서드에는 Javadoc 스타일의 주석을 작성합니다.
- **API 명세**: Controller 메서드에는 Swagger/OpenAPI 어노테이션을 사용하여 문서를 자동화합니다.

---
*작성일: 2024-05-21*
*작성자: AI Architect*
