## 프로세스
1. sh파일들은 CommuteApplication.java의 main프로그램을 실행한다.(jar파일 내 main메소드)
2. crontab에 설정된 workin.sh이 실행된다.
    1. workin.sh는 crontab에 설정되어있는 기존 workout.sh Job을 삭제한다.
        - [crontab 스케쥴 자동으로 추가/삭제](https://sub0709.tistory.com/112)
    2. 그룹웨어를 호출하여 출근시간을 취득한다.
        1. jsoup라이브러리를 활용하여 로그인 후 로그인쿠키를 취득한다.
        2. 로그인 쿠키를 통해 출근시간 API를 호출하여 정보를 얻는다.
        - jsoup는 스크래핑도 가능한데 여기서는 AJAX로 모든화면이 구성되어있어서 활용할곳이 없음.
    3. 출근시간으로 퇴근시간을 계산 후, 퇴근시간에 workout.sh이 실행될 수 있도록 crontab을 설정한다.
3. crontab에 설정된 workout.sh이 실행된다.
    1. Slack WebHook에 연결된 채널로 알림메시지를 전송한다.
    2. MacOS AppleScript를 통해 브라우저앱이 실행되고, 그룹웨어 URL을 호출한다.
4. 2~3이 평일에 반복 실행된다.


※ 주요정보(로그인정보, SlackWebHookUrl 등..)는 PC(또는 server)의 Environment Variable로 관리한다.

---
 
## 세팅방법

### [1. 실행가능한 jar 생성](./readme/1_실행가능한_jar_생성.md)

### [2. Slack WebHoot 생성](./readme/2_Slack_WebHook.md)

### [3. ENV설정](./readme/3_ENV.md)

### [4. Properties 설정](./readme/4_Properties.md)

### [5. crontab](./readme/5_crontab.md)
