package seol.commute.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class PropertiesUtil {
	private static Properties properties;
	static {
		String propFileName = "application.properties";
		InputStream inputStream = PropertiesUtil.class.getClassLoader().getResourceAsStream(propFileName);
		properties = new Properties();
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			new RuntimeException(e);
		}
	}

	public static String getValue(String key) {
		try {
			return new String(properties.getProperty(key).getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}
}
