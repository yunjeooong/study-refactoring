## 리팩터링 과정

이 프로젝트는 다음과 같은 단계로 코드를 리팩터링하며 개선했습니다:

### 1. 리팩터링 전: 단일 클래스의 복잡한 로직
- **파일**: `src/Chapter01/ex01/before/Statement.java`
- **특징**: 모든 계산(비용, 포인트)과 출력 형식이 `statement()` 메소드 하나에 얽혀 있음
- **문제점**: 로직이 뒤엉켜 수정이 어렵고, 가독성이 떨어짐

### 2. 함수 추출하기: 로직 분리
- **파일**: `src/Chapter01/ex01/after/Statement.java`
- **변경점**:
    - `amountFor`: 공연별 비용 계산 분리
    - `playFor`: 공연에 해당하는 연극 정보 조회 함수 분리
    - `volumeCreditFor`: 포인트 계산 분리
    - `totalAmount`, `totalVolumeCredits`: 합계 계산 분리
- **효과**: 로직이 모듈화되어 가독성이 좋아지고, 개별 기능 수정이 쉬워짐

### 3. 계산과 출력 분리: 단계 쪼개기(Split Phase)
- **파일**: `src/Chapter01/ex01/after/StatementData.java`
- **변경점**:
    - `StatementData`: 계산에 필요한 데이터를 모아두는 중간 구조 생성
    - `renderPlainText`, `renderHtml`: 출력 형식을 담당하는 함수 분리
    - `EnrichedPerformance`: 공연별 데이터를 구조화
- **효과**: 계산 로직과 출력 형식이 독립적으로 구성되어, 텍스트나 HTML 등 다른 포맷으로 확장이 쉬워짐

### 4. 다형성 활용: 조건부 로직 개선
- **파일들**:
    - `src/Chapter01/ex01/after/PerformanceCalculator.java`
    - `src/Chapter01/ex01/after/TragedyCalculator.java`
    - `src/Chapter01/ex01/after/ComedyCalculator.java`
- **변경점**:
    - `PerformanceCalculator` 추상 클래스 도입
    - `TragedyCalculator`, `ComedyCalculator` 서브클래스로 장르별 계산 분리
    - `PerformanceCalculatorFactory`로 적절한 계산기 생성
- **효과**: 새로운 장르 추가 시 서브클래스만 만들면 되므로 확장성이 높아짐 (OCP 원칙 준수)  