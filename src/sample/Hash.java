package sample;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Hash {

    public String getHash(String passwordToHash, byte[] salt) throws NoSuchAlgorithmException {
        String generatedPassword = null;
        // https://docs.oracle.com/javase/7/docs/technotes/guides/security/StandardNames.html#MessageDigest
        MessageDigest md = MessageDigest.getInstance("SHA-512");

        byte[] saltValue = salt;
        md.update(saltValue);

        byte[] bytes = md.digest(passwordToHash.getBytes());
//        byte[] bytes = md.digest(passwordToHash.getBytes());
        StringBuilder sb = new StringBuilder();

        for (int i=0; i < bytes.length; i++) {
            sb.append(String.format("%02x", bytes[i]));
        }

        generatedPassword = sb.toString();

        return generatedPassword;
    }

    public byte[] getSalt() throws NoSuchAlgorithmException {
        // https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#SecureRandom
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    public String byteToString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i < bytes.length; i++) {
            sb.append(String.format("%02x", bytes[i]));
        }
        return sb.toString();
    }

    public byte[] stringToByteArray(String string) {
        return null;
    }

}