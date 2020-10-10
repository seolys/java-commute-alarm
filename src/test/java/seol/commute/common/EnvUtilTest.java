package seol.commute.common;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

class EnvUtilTest {

	@Test
	void getValueTest() {
		String id = EnvUtil.getValue("MARKETBORO_COMMUTE_GROUPWARE_ID");
		String password = EnvUtil.getValue("MARKETBORO_COMMUTE_GROUPWARE_PASSWORD");
		System.out.println("id = " + id);
		System.out.println("password = " + password);
		Assertions.assertTrue(StringUtils.isNotBlank(id));
		Assertions.assertTrue(StringUtils.isNotBlank(password));
	}

}