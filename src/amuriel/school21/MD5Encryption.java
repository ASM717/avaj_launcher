package amuriel.school21;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class MD5Encryption {

    public static boolean checkEncrypt(String text, String hash) throws NoSuchAlgorithmException {
        String myHash = encryptToMD5(text);
        return myHash.equals(hash);
    }

    private static String encryptToMD5(String text) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(text.getBytes());
        byte[] digest = md.digest();
        BigInteger no = new BigInteger(1, digest);
        StringBuilder hashText = new StringBuilder(no.toString(16));
        while (hashText.length() < 32) {
            hashText.insert(0, "0");
        }
        return hashText.toString();
    }
}
