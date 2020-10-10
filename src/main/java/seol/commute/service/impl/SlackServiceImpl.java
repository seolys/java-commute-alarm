package seol.commute.service.impl;

import static seol.commute.common.ApplicationConstants.Env.MARKETBORO_COMMUTE_SLACK_HOOK_URL;

import net.gpedro.integrations.slack.SlackApi;
import net.gpedro.integrations.slack.SlackMessage;
import seol.commute.common.EnvUtil;
import seol.commute.common.PropertiesUtil;
import seol.commute.service.SlackService;

public class SlackServiceImpl implements SlackService {

	@Override
	public void sendWorkoutMessage() {
		this.sendMessage("퇴근하기를 눌러주세요.\n" + PropertiesUtil.getValue("url.groupware.ehr.page"));
	}

	@Override
	public void sendMessage(String message) {
		String webHookUrl = EnvUtil.getValue(MARKETBORO_COMMUTE_SLACK_HOOK_URL);
		String channel = PropertiesUtil.getValue("slack.channel");
		String username = PropertiesUtil.getValue("slack.username");
		SlackApi api = new SlackApi(webHookUrl);
		api.call(new SlackMessage(channel, username, message));
	}

}
