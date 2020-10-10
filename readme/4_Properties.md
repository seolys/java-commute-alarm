## Properties 설정

(1) /src/main/resources/application.properties
```
# 1. 퇴근시 실행할 shell파일 경로 설정.(sh파일 경로(/bin/))
shell.workout=/Users/seol/Dropbox/marketboro/commute/workout.sh
 
# 2. 슬랙 연동정보.(생성한 Slack WebHook)
slack.channel=@seolys
slack.username=WebHook

# 3. 기본 브라우저 설정(쓰고있는 브라우저) [whale, chrome]
default.browser=chrome
```

(2) jar파일 재생성.
- Build > Build Artifacts
  
![screenshot](./image/1_12.png)

![screenshot](./image/1_13.png)

![screenshot](./image/1_14.png)