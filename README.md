## 프로세스
1. crontab에 설정된 workin.sh이 실행된다.
    1. workin.sh는 crontab에 설정되어있는 기존 workout.sh Job을 삭제한다.
    2. 그룹웨어를 호출하여 출근시간을 취득한다.
    3. 출근시간으로 퇴근시간을 계산 후, 퇴근시간에 workout.sh이 실행될 수 있도록 crontab을 설정한다.
2. crontab에 설정된 workout.sh이 실행된다.
    1. Slack WebHook에 연결된 채널로 알림메시지를 전송한다.
    2. MacOS AppleScript를 통해 브라우저앱이 실행되고, 그룹웨어 URL을 호출한다.
3. 1~2가 매일 반복된다.(평일)

---
 
## 세팅방법

### [1. 실행가능한 jar 생성](./readme/1_실행가능한_jar_생성.md)

### [2. Slack WebHoot 생성](./readme/2_Slack_WebHook.md)

### [3. ENV설정](./readme/3_ENV.md)

### [4. Properties 설정](./readme/4_Properties.md)

### [5. crontab](./readme/5_crontab.md)
