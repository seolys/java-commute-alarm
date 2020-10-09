package seol.commute.common;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CommandLineExecutorTest {
	@Test
	void cmdTest() {
		CommandLineExecutor.execute("ifconfig");
	}
}