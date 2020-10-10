package seol.commute.common;

import org.junit.jupiter.api.Test;

class CryptoUtilTest {

	@Test
	void cryptoTest() {
		String enc = CryptoUtil.encAES128("1qfewqjdslkjflkdasjflkd!@#$%^&*()-_=+,<.>;:'\"[{]}/?`~asfwbvrneq;mxzc.2w3e$R%T");
		System.out.println("enc = " + enc);
		String dec = CryptoUtil.decAES128(enc);
		System.out.println("dec = " + dec);
	}

}