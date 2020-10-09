package seol.commute;

import static seol.commute.Command.valueOf;
import static seol.commute.Command.workIn;
import static seol.commute.Command.workOut;

import seol.commute.service.CommuteService;

/**
 * 수동실행방법: java -cp /Users/seol/Dropbox/marketboro/commute/commute.jar seol.commute.CommuteApplication workOut
 * argument정보: workIn | workOut
 *
 * 설명.
 * workin: 출근시간을 얻어와서 9시간 후 퇴근알림이 실행될 수 있도록 crontab의 job을 생성한다.(daily crontab 설정필요.)
 * workout: 퇴근알림이 실행된다. 그룹웨어 브라우저로 실행 및 Slack메시지 발송.
 *          (workin프로그램이 출근시간에 맞춰서 퇴근시간에 실행되도록 crontab job을 생성하기때문에 crontab 설정 안해도됨.)
 *
 * 세팅방법.
 * 1. 로그인정보 ENV 세팅.
 *  export MARKETBORO_GROUPWARE_ID="아이디"
 *  export MARKETBORO_GROUPWARE_PASSWORD="패스워드"
 *  export MARKETBORO_COMMUTE_SLACK_HOOK_URL="https://hooks.slack.com/services/................"
 *  - 비밀번호에 특수문자 들어가있는경우 echo통해서 잘 나온지 확인필요. ex) $ -> \$ 치환필요
 *  - KEY값 바꾸싶은경우 application.properties 파일에서 변경.
 * 2. application.properties 수정.
 *  - workout.sh 파일 경로 지정.
 * 3. workin Crontab 설정(프로젝트/bin 밑의 스크립트 참조.)
 *  0 14 * * 1-5 sh /Users/seol/Dropbox/marketboro/commute/workin.sh
 */
public class CommuteApplication {

	public static void main(String[] args) throws Exception {
		if(args == null || args.length == 0) {
			throw new RuntimeException("args가 없습니다.");
		}
		CommuteService commuteService = CommuteConfig.commuteService();

		Command command = valueOf(args[0]);
		if(workIn == command) {
			commuteService.workIn();
		} else if(workOut == command){
			commuteService.workOut();
		}
	}
}
