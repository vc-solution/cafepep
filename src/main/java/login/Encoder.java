package login;

import java.security.MessageDigest;

import sun.misc.BASE64Encoder;

@SuppressWarnings("restriction")
public class Encoder {

	@SuppressWarnings("unused")
	public static String hashAndEncodePassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes("UTF-8"));
            byte[] passwordDigest = md.digest();
            return new BASE64Encoder().encode(passwordDigest);
        } catch (Exception e) {
            throw new RuntimeException("Exception encoding password", e);
        }
    }
	
}
