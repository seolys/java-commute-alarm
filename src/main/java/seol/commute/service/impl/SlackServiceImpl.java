package seol.commute.service.impl;

import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackMessage;
import seol.commute.common.EnvUtil;
import seol.commute.common.PropertiesUtil;
import seol.commute.service.SlackService;

public class SlackServiceImpl implements SlackService {

	@Override
	public void sendWorkoutMessage() {
		sendMessage("퇴근하기를 눌러주세요. https://marketboro.daouoffice.com/app/ehr");
	}

	@Override
	public void sendMessage(String message) {
		String webHookUrlKey = PropertiesUtil.getValue("env.key.slack.web-hook-url");
		String webHookUrl = EnvUtil.getValue(webHookUrlKey);
		String channel = PropertiesUtil.getValue("slack.channel");
		String username = PropertiesUtil.getValue("slack.username");
		SlackApi api = new SlackApi(webHookUrl);
		api.call(new SlackMessage(channel, username, message));
	}

}
