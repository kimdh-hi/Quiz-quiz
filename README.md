쪽지시험 웹 애플리케이션

**권한**에 익숙해지기 위한 목적의 토이 프로젝트입니다.

### 📌 주요 도메인 요구사항
애플리케이션 사용자로는 `학생`, `선생님`, `관리자`가 있다.

#### 학생
1. `학생권한`으로 `회원가입 및 로그인`을 할 수 있다.
2. `회원가입`시 하나의 `학교`에 가입할 수 있다.
3. 자신에게 배정된 쪽지시험에 `응시`할 수 있다.
4. 쪽지시험에 대한 결과를 확인할 수 있다.

#### 선생님
1. `선생님권한`으로 `회원가입 및 로그인`을 할 수 있다.
2. `회원가입`시 하나의 `학교`에 가입할 수 있다.
3. 자신의 `학교`에 등록된 `학생`을 자신의 `학생`으로 등록할 수 있다.
4. `쪽지시험`을 생성할 수 있다.
5. 자신이 출제한 `쪽지시험`에 응시한 모든 `학생`의 시험결과를 확인할 수 있다.

#### 관리자
1. `학교`에 대한 관리를 할 수 있다.
2. `선생님`, `학생`에 대한 회원관리를 할 수 있다.
3. `선생님`으로 가입하는 회원에 대해 권한을 부여한다.

#### 시험지 & 문제
1. `선생님` 이상의 권한을 가진 사용자만 등록,수정,삭제 가능하다.
2. 한 개 `시험지`는 여러 개 `문제`를 포함한다.
3. 한 개 `문제`는 문제설명, 문제이미지, 답, 배점이 있다.

#### 시험
1. `시험`은 한 개 `시험지`를 갖는다.
2. 시작시간과 종료시간을 갖는다.
3. 응시자 수와 평균점수를 갖는다. 

***

### 📌 회원가입 시나리오

1. 학생으로 회원가입
- 이름, 이메일, 비밀번호, 학년, 학교, 선생님 선택
- `선생님` or `관리자` 가 가입 수락시 `Student` 권한 부여
  수락 전까지는 `Guest` 권한부여

2. 선생님으로 회원가입
- 이름, 이메일, 비밀번호, 학교 선택
- `관리자` 가 가입 수락시 `Teacher` 권한 부여
  수락 전까지는 `Guest` 권한부여  

