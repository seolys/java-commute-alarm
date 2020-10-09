package seol.commute.service.impl;

import java.io.IOException;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import seol.commute.common.EnvUtil;
import seol.commute.common.PropertiesUtil;
import seol.commute.service.ApiService;

public class ApiServiceImpl implements ApiService {
		public static final String userAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.106 "
				+ "Whale/2.8.105.18 Safari/537.36";

	@Override
	public Map<String, String> login() throws IOException {
		System.out.println("[JAVA->WEB] https://marketboro.daouoffice.com/api/login");
		Connection.Response loginPageResponse = Jsoup.connect("https://marketboro.daouoffice.com/api/login")
				.timeout(3000)
				.header("Accept", "application/json, text/javascript, */*; q=0.01")
				.header("Content-Type", "application/json; charset=UTF-8")
				.header("User-Agent", userAgent)
				.header("X-Requested-With", "XMLHttpRequest")
				.method(Method.POST)
				.requestBody(makeLoginRequestBody())
				.ignoreContentType(true)
				.execute();
		System.out.println("[JAVA<-WEB] https://marketboro.daouoffice.com/api/login");

		// 로그인 페이지에서 얻은 쿠키
		Map<String, String> loginCookie = loginPageResponse.cookies();
		return loginCookie;
	}

	private String makeLoginRequestBody() {
		JSONObject request = new JSONObject();
		String envKeyId = PropertiesUtil.getValue("env.key.id");
		String endKeyPassword = PropertiesUtil.getValue("env.key.password");
		request.put("username", EnvUtil.getValue(envKeyId));
		request.put("password", EnvUtil.getValue(endKeyPassword));
		request.put("returnUrl", "/");
		return request.toJSONString();
	}

	@Override
	public String getWorkInTime(Map<String, String> loginCookie) throws IOException, ParseException {
		System.out.println("[JAVA->WEB] https://marketboro.daouoffice.com/api/ehr/side");
		Connection.Response sideResponse = Jsoup.connect("https://marketboro.daouoffice.com/api/ehr/side")
				.userAgent(userAgent)
				.header("Accept", "application/json, text/javascript, */*; q=0.01")
				.header("Accept-Encoding", "gzip, deflate, br")
				.header("Accept-Language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
				.header("Cache-Control", "no-cache")
				.header("Connection", "keep-alive")
				.header("User-Agent", userAgent)
				.header("Host", "marketboro.daouoffice.com")
				.header("Pragma", "no-cache")
				.header("Sec-Fetch-Dest", "empty")
				.header("Sec-Fetch-Mode", "cors")
				.header("Sec-Fetch-Site", "same-origin")
				.header("TimeZoneOffset", "540")
				.header("X-Requested-With", "XMLHttpRequest")
				.cookies(loginCookie) // 위에서 얻은 '로그인 된' 쿠키
				.method(Method.GET)
				.ignoreContentType(true)
				.execute();

		System.out.println("[JAVA<-WEB] https://marketboro.daouoffice.com/api/ehr/side");
		String body = sideResponse.body();
		System.out.println(body);

		JSONObject side = (JSONObject) new JSONParser().parse(body);
		JSONObject data = (JSONObject) side.get("data");
		JSONObject timelineSide = (JSONObject) data.get("timelineSide");
		String workInTime = (String) timelineSide.get("workInTime");
		String workOutTime = (String) timelineSide.get("workOutTime");
		System.out.println("workInTime = " + workInTime);
		System.out.println("workOutTime = " + workOutTime);
		return workInTime;
	}
}
