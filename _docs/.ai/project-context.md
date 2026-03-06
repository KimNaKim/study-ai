# Project Context

## 1. 프로젝트 개요
- **프로젝트명**: 블로그 만들기 (Demo Blog)
- **목표**: Spring Boot 기반의 블로그 플랫폼 구축
- **핵심 가치**: 도메인 중심의 플랫 구조와 명확한 코드 컨벤션을 준수하여 유지보수성 확보

## 2. 전체 아키텍처 (Architecture)
이 프로젝트는 **Spring Boot** 기반의 **모놀리식 아키텍처**를 채택하고 있으며, **도메인 기반 플랫 패키지 구조**를 따릅니다.

### 2.1 패키지 구조 전략
- **Domain-Driven (Flat)**: 레이어별로 패키지를 나누지 않고, 도메인(기능)별로 관련 파일(`Controller`, `Service`, `Repository`, `Entity`, `DTO`)을 한 폴더에 응집시킵니다.
- **Separation of Concerns**:
  - **SSR Controller**: 화면(HTML) 반환 (`*Controller.java`) - Mustache 템플릿 엔진 사용.
  - **API Controller**: JSON 데이터 반환 (`*ApiController.java`) - `/api` 접두사 사용.

### 2.2 데이터 흐름
`Client` ↔ `Controller/ApiController` ↔ `Service (DTO 변환)` ↔ `Repository` ↔ `Database`
* **주의**: Controller 계층으로 Entity가 절대 노출되지 않으며, 모든 데이터는 DTO로 변환되어 전달됩니다.

## 3. 기술 스택 (Tech Stack)

### Backend
- **Language**: Java
- **Framework**: Spring Boot
- **Data Access**: Spring Data JPA (Hibernate)
  - **OSIV**: `false` (비활성화)
  - **Fetch Strategy**: `LAZY` (지연 로딩)
- **Auth**: `HttpSession` (Spring Security 복잡도 제거)

### Frontend
- **Template Engine**: Mustache (Server-Side Rendering)
- **JavaScript**: Vanilla JS (ES6+)
  - `fetch` API (`async`/`await`)
  - `document.querySelector`

### Database
- **PK Strategy**: `Integer` (Auto Increment)
- **Naming**: Snake Case (`_tb` 접미사)

## 4. 핵심 개발 규칙 (Conventions)
- **응답 포맷**: 모든 REST API 응답은 `Resp<T>` 래퍼 클래스(`_core.utils.Resp`)를 사용합니다.
- **트랜잭션**: Service 클래스 레벨에 `@Transactional(readOnly = true)`를 적용하고, 쓰기 작업에만 별도로 트랜잭션을 엽니다.
- **DTO 정의**: 도메인별 `Request`, `Response` 클래스 내부에 `static class`로 정의하여 관리합니다.
- **프론트엔드**: Form 태그 제출을 기본으로 하며, 중복 체크 등 필요한 경우에만 AJAX를 사용합니다.
- **공통 유틸**: `_core/utils/` 경로에 도메인 무관 공통 유틸리티를 배치합니다.
