package seol.commute.service.impl;

import java.util.Map;
import seol.commute.CommuteConfig;
import seol.commute.common.CommandLineExecutor;
import seol.commute.service.ApiService;
import seol.commute.service.CommuteService;
import seol.commute.service.CrontabService;
import seol.commute.service.SlackService;

public class CommuteServiceImpl implements CommuteService {

	private ApiService apiService = CommuteConfig.apiService();
	private SlackService slackService = CommuteConfig.slackService();
	private CrontabService crontabService = CommuteConfig.crontabService();

	@Override
	public void workIn() throws Exception {
		Map<String, String> loginCookie = apiService.login();
		String workInTime = apiService.getWorkInTime(loginCookie);
		crontabService.makeWorkOutJob(workInTime);
	}

	@Override
	public void workOut() {
		slackService.sendWorkoutMessage();
		CommandLineExecutor.execute("open -a \"Whale\" https://marketboro.daouoffice.com/app/ehr");
	}
}
