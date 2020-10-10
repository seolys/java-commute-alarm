## 실행가능한 jar 생성.

(1) IntelliJ IDEA > File > Project Structure...(cmd + ;) 

![screenshot](./image/1_1.png)

(2) Artifacts > + > JAR > From modules with dependencies... 

![screenshot](./image/1_2.png)

(3) 폴더모양 클릭

![screenshot](./image/1_3.png)

(4) 실행될 Main Application 선택(CommuteApplication)

![screenshot](./image/1_4.png)

(5) OK 클릭

![screenshot](./image/1_5.png)

(6) 만약 Error가 뜨면, /src/main/java/META-INF/MANIFEST.MF 삭제 후 재시도. 

![screenshot](./image/1_6.png)

![screenshot](./image/1_7.png)

(7) Output Directory 지정
    - 프로젝트에 디렉토리 만들어서 포함시키거나, 특정 디렉토리 생성.
    
![screenshot](./image/1_8.png)

(8) +버튼 클릭 > Module Source > Commute.main 선택 > OK 클릭

![screenshot](./image/1_9.png)

![screenshot](./image/1_10.png)

(9) 'commute.main' sources가 추가되었다면 OK 클릭 후 설정을 완료한다.

![screenshot](./image/1_11.png)

(10) Build > Build Artifacts  

![screenshot](./image/1_12.png)

(11) commute:jar > Build 

![screenshot](./image/1_13.png)

(12) 7번에서 지정한 경로에 commute.jar이 생겼다면 성공.
- 추후 application.properties 변경시 재생성 필요.

![screenshot](./image/1_14.png)