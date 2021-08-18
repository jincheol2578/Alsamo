# Alsamo

주류 관련 정보 공유를 위한 커뮤니티 사이트 Alsamo 입니다.

http://alsamo.site/


## 팀원

![GitHub-Mark-32px](https://user-images.githubusercontent.com/81733208/127449795-e4a42194-93a0-4060-bdac-8425789cb40a.png) [김진철](https://github.com/jincheol2578)

![GitHub-Mark-32px](https://user-images.githubusercontent.com/81733208/127449795-e4a42194-93a0-4060-bdac-8425789cb40a.png) [홍준호](https://github.com/heckevil)
 BLOG : https://forward-to-tomorrow.tistory.com




## 사용 기술 및 개발 환경

Java 8, Spring, IntelliJ, Maven, MariaDB, MyBatis, Jsoup, JavaScript, Bootstrap, AWS



## 요구사항

##### User

- **회원가입** 
  - 무분별한 회원가입 방지를 위한 이메일 인증
  - 아이디 중복 체크
  - 회원정보 보안을 위한 비밀번호 암호화
- **로그인**
  - 서비스의 원활한 이용을 위한 로그인 필요.
  - 서비스 이용을 끝내기 위한 로그아웃 필요.
- **아이디/비밀번호 찾기**
  - 이메일 인증을 통한 아이디, 비밀번호 찾기 기능
- **마이페이지**
  - 내 정보 조회 및 수정



##### Main

- 메인 화면
  - 일일 인기게시글
  - 주간 인기게시글 
  - 공지사항
  - 미니게시판



##### Board

- **게시글 등록**

  - editor 적용
    - 사진 업로드, 유튜브 영상 등록

  - 원하는 게시판에 게시글을 등록.
  - 비로그인 상태에서 게시글 등록시 게시글 비밀번호 필요.
  - 게시글에 답글 등록 (답글 밑 답글도 가능)

- **게시글 수정/삭제**

  - 비로그인 상태에서 작성한 게시글일 경우 비밀번호 입력시 수정 가능
  - 로그인한 유저는 본인글일 경우 수정 가능
  - 관리자 등급일 경우 모든글 삭제가능

- **공지사항**

  - 게시판 1 페이지 상단 노출 (페이지에 포함되지 않음)

- **페이징**

  - 데이터가 많을시 가독성 저하 및 자원낭비 방지를 위한 페이징 기능 필요.

- **게시글 검색**

  - 제목에 포함된 문자 검색
  - 내용에 포함된 문자 검색
  - 작성자에 포함된 문자 검색



##### Wiki

- 메인
  - wiki 메인에 노출될 검색어 추가
- 검색
  - 단어 검색시 wikipidia 내용 화면에 출력

##### 

##### Admin

- 로그인
  - 관리자로 등록된 유저만 로그인

- 메뉴 관리
  - 게시판 메뉴 추가
  - 게시판 메뉴 삭제
  - 게시판 메뉴 수정
- 게시글 관리
  - 등록한 문자가 포함된 게시글만 조회하는 기능
  - 불량 게시글 삭제
- 유저 관리
  - 불량 유저 차단
  - 유저 정보 조회
- 메인 화면 관리
  - 메인화면에 노출되는 내용 관리



## DataBase ERD

![DB](https://user-images.githubusercontent.com/81733208/127448738-d52ee3aa-c60a-4e52-9dd1-ee7e33d092dd.png)

> https://dbdiagram.io/

