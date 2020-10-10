## 프로그램 설명
- workin: 출근시간을 취득 후 퇴근시간을 계산하여, 퇴근시간에 동작할 crontab job을 생성한다.
- workout: 브라우저로 그룹웨어 오픈 및 Slack 메시지 전송.   
- workin.sh, workout.sh 경로 : 프로젝트경로/bin

---

## 세팅방법
### 1. env 설정.
- 암호화 password만들기
```
password.sh "패스워드"
```
- .zsh기준, profile파일 오픈
```
vi ~/.zshrc 
```
- 로그인 및 Slack 정보 설정.
```
export MARKETBORO_COMMUTE_GROUPWARE_ID="아이디"
export MARKETBORO_COMMUTE_GROUPWARE_PASSWORD="암호화된패스워드"
export MARKETBORO_COMMUTE_SLACK_HOOK_URL="https://hooks.slack.com/services/................"
export MARKETBORO_COMMUTE_AES128_KEY="16자리_아무_영숫자"
```
- 비밀번호에 특수문자 들어가있는경우 echo통해서 잘 나온지 확인필요. ex) $ -> \$ 치환필요
```
echo $MARKETBORO_COMMUTE_GROUPWARE_PASSWORD
```

### 2. application.properties 수정.
- workout.sh 파일 경로 지정.

### 3. workin Crontab 설정
- crontab 설정 open
```
crontab -e
```
- crontab 설정 예시(평일 14시 0분에 workin.sh실행.)
```
0 14 * * 1-5 sh /Users/seol/Dropbox/marketboro/commute/workin.sh
```