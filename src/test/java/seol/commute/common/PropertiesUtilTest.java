package seol.commute.common;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

class PropertiesUtilTest {

	@Test
	@DisplayName("getValue테스트")
	void getValueTest() {
		String webHookUrl = PropertiesUtil.getValue("slack.web-hook-url");
		String channel = PropertiesUtil.getValue("slack.channel");
		String username = PropertiesUtil.getValue("slack.username");
		System.out.println("webHookUrl = " + webHookUrl);
		System.out.println("channel = " + channel);
		System.out.println("username = " + username);
		assertTrue(StringUtils.isNotBlank(webHookUrl));
		assertTrue(StringUtils.isNotBlank(channel));
		assertTrue(StringUtils.isNotBlank(username));
	}
}