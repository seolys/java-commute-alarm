package seol.commute.service.impl;

import static seol.commute.Command.password;
import static seol.commute.Command.valueOf;
import static seol.commute.Command.workIn;
import static seol.commute.Command.workOut;

import seol.commute.Command;
import seol.commute.CommuteConfig;
import seol.commute.common.CommandLineExecutor;
import seol.commute.common.CryptoUtil;
import seol.commute.common.PropertiesUtil;
import seol.commute.service.ApiService;
import seol.commute.service.CommuteService;
import seol.commute.service.CrontabService;
import seol.commute.service.SlackService;

public class CommuteServiceImpl implements CommuteService {

	private ApiService apiService = CommuteConfig.apiService();
	private SlackService slackService = CommuteConfig.slackService();
	private CrontabService crontabService = CommuteConfig.crontabService();

	@Override
	public void process(String[] args) throws Exception {
		Command command = valueOf(args[0]);
		if (workIn == command) {
			this.workIn();
		} else if (workOut == command) {
			this.workOut();
		} else if (password == command) {
			this.generatePassword(args[1]);
		}
	}

	@Override
	public void workIn() throws Exception {
//		Map<String, String> loginCookie = apiService.login();
//		String workInTime = apiService.getWorkInTime(loginCookie);
		String workInTime = "09:30:00";
		crontabService.makeWorkOutJob(workInTime);
	}

	@Override
	public void workOut() {
		slackService.sendWorkoutMessage();
		String defaultBrowser = PropertiesUtil.getValue("default.browser");
		if ("whale".equals(defaultBrowser)) {
			CommandLineExecutor.execute("open -a \"Whale\" https://marketboro.daouoffice.com/app/ehr");
			return;
		}
		CommandLineExecutor.execute("open -a \"Google chrome\" https://marketboro.daouoffice.com/app/ehr");
	}

	@Override
	public void generatePassword(String dec) {
		String enc = CryptoUtil.encAES128(dec);
		System.out.println("dec = " + dec);
		System.out.println("enc = " + enc);
	}

}
