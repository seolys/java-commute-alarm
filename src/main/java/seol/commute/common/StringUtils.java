package seol.commute.common;

public class StringUtils {

	public static boolean isEmpty(String str) {
		return !isNotEmpty(str);
	}

	public static boolean isNotEmpty(String str) {
		return str != null && !str.isEmpty() && !"null".equals(str);
	}

}
