package seol.commute.common;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CryptoUtil {

	public static final String key = EnvUtil.getValue("MARKETBORO_COMMUTE_AES128_KEY");

	// 암호화
	public static String encAES128(String str) {
		byte[] crypted = null;
		try {
			SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");

			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, skey);
			crypted = cipher.doFinal(str.getBytes());
			byte[] enc = Base64.getEncoder().encode(crypted);
			return new String(enc);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	// 복호화
	public static String decAES128(String enStr) {
		try {
			byte[] output = null;
			SecretKeySpec skey = new SecretKeySpec(key.getBytes(), "AES");
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, skey);
			output = cipher.doFinal(Base64.getDecoder().decode(enStr));
			return new String(output);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
