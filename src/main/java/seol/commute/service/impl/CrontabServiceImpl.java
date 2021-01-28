package seol.commute.service.impl;

import static seol.commute.common.StringUtils.isNotEmpty;

import java.time.LocalTime;
import seol.commute.common.CommandLineExecutor;
import seol.commute.common.PropertiesUtil;
import seol.commute.service.CrontabService;

public class CrontabServiceImpl implements CrontabService {

	private static final String workoutCrontab = "{ crontab -l & echo '%s %s * * 1-5 sh %s'; } | crontab -";
	private static final String removeCrontab = "crontab -l | grep -v '%s' | crontab -";

	@Override
	public void makeWorkOutJob(String workInTime) {
		final String workOutShellPath = PropertiesUtil.getValue("shell.workout");

		String removeScript = String.format(removeCrontab, workOutShellPath);
		CommandLineExecutor.execute(removeScript);

		LocalTime workOutTime = calculateWorkOutTime(workInTime);
		String createScript = String.format(workoutCrontab, workOutTime.getMinute(), workOutTime.getHour(), workOutShellPath);
		CommandLineExecutor.execute(createScript);
	}

	private LocalTime calculateWorkOutTime(String workInTime) {
		workInTime = isNotEmpty(workInTime) ? workInTime : "09:30:00";
		int hour = Integer.parseInt(workInTime.substring(0, 2));
		int minute = Integer.parseInt(workInTime.substring(3, 5));
		LocalTime workOutTime = LocalTime.of(hour, minute).plusHours(9).plusMinutes(5);
		return workOutTime;
	}

}
