package seol.commute.common;

public class EnvUtil {
	public static String getValue(String key) {
		String env = System.getenv(key);
		if(env==null || env.isEmpty()) {
			throw new RuntimeException("ENV 세팅이 필요합니다. : " + key);
		}
		return env;
	}

}
