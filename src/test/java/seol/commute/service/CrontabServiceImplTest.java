package seol.commute.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import seol.commute.CommuteConfig;

class CrontabServiceImplTest {

	@Test
	@DisplayName("Crontab Job 생성")
	void makeAlarmJobTest() {
		CommuteConfig config = new CommuteConfig();
		CrontabService crontabService = config.crontabService();
		crontabService.makeWorkOutJob("09:12:13");
	}

}