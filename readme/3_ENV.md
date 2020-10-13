## ENV 설정
- zsh를 사용하는것으로 가정함.
- /Users/seol/Dropbox/marketboro/commute/ 경로에 jar파일과 sh파일이 있다고 가정함.
- sh파일들은 실행권한을 전부 주었음.
    ```
    cd /Users/seol/Dropbox/marketboro/commute
    chmod +x *.sh
    ```
- 참고 : https://boro.atlassian.net/wiki/spaces/~794817334/pages/700350465/env

(1) 계정정보 비밀번호 암호화를 위한 AES128 Key, SLACK HOOK URL 설정.
```
sh ~/.zshrc
```
```
# export MARKETBORO_COMMUTE_AES128_KEY="marketboro123456"
export MARKETBORO_COMMUTE_AES128_KEY="16자리_영숫자_지정"
export MARKETBORO_COMMUTE_SLACK_HOOK_URL="https://hooks.slack.com/services/...웹훅URL"
```
```
# env 적용
source ~/.zshrc
```

(2) PASSWORD 생성 후 암호화된 패스워드 복사.
```
sh password.sh "그룹웨어 패스워드"

dec = 그룹웨어 패스워드
enc = q2wmzH7sHRtogR20NevnJA==
```

(3) 계정정보 ENV생성.
```
sh ~/.zshrc
```
```
export MARKETBORO_COMMUTE_GROUPWARE_ID="그룹웨어 ID"
export MARKETBORO_COMMUTE_GROUPWARE_PASSWORD="2번단계에서 생성한 패스워드"
```
```
# env 적용
source ~/.zshrc
```
(4) 최종 확인
```
$ env

MARKETBORO_COMMUTE_GROUPWARE_ID=그룹웨어ID
MARKETBORO_COMMUTE_GROUPWARE_PASSWORD=2번단계에서 생성한 패스워드
MARKETBORO_COMMUTE_SLACK_HOOK_URL=https://hooks.slack.com/services/....웹훅URL
MARKETBORO_COMMUTE_AES128_KEY=1번단계 암호화Key
```
