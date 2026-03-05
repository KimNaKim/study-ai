# Spring Boot Coding Skill

## Description
프로젝트의 `code-rule.md`에 정의된 표준을 준수하여 Java Spring Boot 코드를 작성하는 기술입니다.

## Rules

### 1. Naming Conventions
- **Class/Interface**: PascalCase (e.g., `BoardService`, `UserEntity`)
- **Method/Variable**: camelCase (e.g., `getBoardList`, `userName`)
- **Constant**: UPPER_SNAKE_CASE (e.g., `MAX_LOGIN_RETRY`)
- **DB Table**: snake_case (e.g., `board_comment`)

### 2. Layer Rules
- **Controller**:
  - 역할: 요청/응답 처리 (비즈니스 로직 금지).
  - 의존성: Service 호출.
  - 데이터: DTO 사용 (Entity 직접 반환 금지).
  - 문서화: Swagger/OpenAPI 어노테이션 사용.
- **Service**:
  - 역할: 비즈니스 로직 구현, 트랜잭션 관리 (`@Transactional`).
  - 데이터: Entity <-> DTO 변환 수행.
- **Repository**:
  - 역할: DB 접근 (`JpaRepository` 상속).
  - 확장: 복잡한 쿼리는 QueryDSL 등 별도 구현체 권장.
- **Entity**:
  - 제약: Setter 사용 지양, `protected` 기본 생성자 사용 (`@NoArgsConstructor(access = AccessLevel.PROTECTED)`).
  - 메서드: 의도가 명확한 비즈니스 메서드 사용 (e.g., `updateTitle()`).
- **DTO**:
  - 구현: `record` 또는 Lombok `@Data`/`@Getter` 사용.

### 3. Code Style
- **Dependency Injection**: 생성자 주입 사용 (`@RequiredArgsConstructor`).
- **Formatting**: 들여쓰기 4칸 (Space).
- **Comments**: 클래스 및 복잡한 로직에 Javadoc 스타일 주석 작성.

### 4. Package Structure
- **Type**: Package-by-Feature (기능 기반 패키지 구조).
- **Root**: `src/main/java/com/example/demo`
- **Sub-packages**: `{domain}/controller`, `{domain}/service`, `{domain}/repository`, `{domain}/entity`, `{domain}/dto`
