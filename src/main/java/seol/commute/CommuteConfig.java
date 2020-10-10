package seol.commute;

import seol.commute.service.ApiService;
import seol.commute.service.CommuteService;
import seol.commute.service.CrontabService;
import seol.commute.service.SlackService;
import seol.commute.service.impl.ApiServiceImpl;
import seol.commute.service.impl.CommuteServiceImpl;
import seol.commute.service.impl.CrontabServiceImpl;
import seol.commute.service.impl.SlackServiceImpl;

public class CommuteConfig {

	public static ApiService apiService() {
		return new ApiServiceImpl();
	}

	public static CommuteService commuteService() {
		return new CommuteServiceImpl(apiService(), slackService(), crontabService());
	}

	public static CrontabService crontabService() {
		return new CrontabServiceImpl();
	}

	public static SlackService slackService() {
		return new SlackServiceImpl();
	}

}
