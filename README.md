# study-refactoring

마틴 파울러의 Refactoring 2판을 읽고 배운점을 기록합니다. 

책 속의 코드를 자바로 다시 옮겨가며 그 내용들을 체화합니다. 


---

### 1주차 

#### 프로젝트 구조

##### 리팩토링 전 (`before` 패키지)

| 파일 | 설명 |
|------|------|
| Statement.java | 비용 계산과 출력을 모두 담당하는 단일 클래스 |
| Performance.java | 공연 정보(연극 ID, 관객 수)를 담는 클래스 |
| Play.java | 연극 정보(이름, 장르)를 담는 클래스 |
| PlayType.java | 연극 장르 열거형 (TRAGEDY, COMEDY) |
| Plays.java | 연극 컬렉션을 관리하는 클래스 |
| Invoice.java | 청구서 정보(고객명, 공연 목록)를 담는 클래스 |
| App.java | 애플리케이션 실행을 위한 메인 클래스 |

##### 리팩터링 후 (`after` 패키지)

| 파일 | 설명 |
|------|------|
| Statement.java | 청구서 생성 및 출력 형식 담당(계산 로직 없음) |
| StatementData.java | 계산 로직을 모아둔 중간 구조와 `EnrichedPerformance` 내부 클래스 |
| PerformanceCalculator.java | 연극 장르별 계산 로직의 추상 기본 클래스 |
| TragedyCalculator.java | 비극 장르 전용 계산 로직 |
| ComedyCalculator.java | 희극 장르 전용 계산 로직 |
| PerformanceCalculatorFactory.java | 장르에 맞는 계산기를 생성하는 팩토리 |
| App.java | 텍스트와 HTML 두 가지 출력 방식 테스트 |

---

##### 핵심 리팩터링 기법

이 프로젝트에서 적용한 주요 리팩토링 기법들:

- **함수 추출하기 (Extract Function)**: 복잡한 로직을 작은 함수로 분리  
- **변수 인라인하기 (Inline Variable)**: 불필요한 임시 변수 제거  
- **함수 옮기기 (Move Function)**: 계산 로직을 적절한 클래스로 이동  
- **조건부 로직을 다형성으로 바꾸기 (Replace Conditional with Polymorphism)**: `switch`문을 클래스 계층 구조로 대체  
- **단계 쪼개기 (Split Phase)**: 계산과 표현을 분리하여 독립적인 단계로 만들기  

[리팩터링 과정 보기](https://github.com/yunjeooong/study-refactoring/blob/main/src/Chapter01/ex01/docs/refactoring-steps.md)

[학습 과정 정리 보기](https://github.com/yunjeooong/study-refactoring/blob/main/src/Chapter01/ex01/docs/study.md)

![image](https://github.com/user-attachments/assets/8d024c36-f42d-46ef-84d8-495a1ce5b215)

---
