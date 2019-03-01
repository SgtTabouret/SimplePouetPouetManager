package classes;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Encrypt {
	
	
	
	/* Encrypt a password given by the user */
	public String encryptUserPwd(User usr) {
		return null;
	}
	
	
	public String encryptPassPhraseToMD5(User usr) {
		String pwd = usr.getPassphrase();
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			
			byte[] messageDigest = md.digest(pwd.getBytes());
			
			BigInteger no = new BigInteger(1, messageDigest);
			
			String hash = no.toString(16);
			while(hash.length() < 32) 
				hash = "0" + hash;
			
			return hash;
			
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}		
	}
	
	public static void main(String[] args) {
		User u = new User(0, "toto", "tata");
		Encrypt e = new Encrypt();
		String encrypted = e.encryptPassPhraseToMD5(u);
		System.out.println("length: " + encrypted.length());
		System.out.println("hashcode generated  is " + encrypted);
		System.out.println(encrypted.equals(e.encryptPassPhraseToMD5(u)));
	}

}
