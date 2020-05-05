package sample;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Encryption {

    private SecretKeySpec secretKey;
    private byte[] key;

    public void setKey(String myKey) throws NoSuchAlgorithmException {
        MessageDigest sha = MessageDigest.getInstance("SHA-512");
        key = myKey.getBytes();
        key = sha.digest(key);
        key = Arrays.copyOf(key, 16);
        secretKey = new SecretKeySpec(key, "AES");
    }

    public String encrypt(String strToEncrypt, String secret) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
        setKey(secret);

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte [] strToEncryptBytes = strToEncrypt.getBytes("UTF-8");
        byte [] finalCipher = cipher.doFinal(strToEncryptBytes);

        return Base64.getEncoder().encodeToString(finalCipher);
    }

    public String decrypt(String strToDecrypt, String secret) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        setKey(secret);

        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte [] finalByteString = Base64.getDecoder().decode(strToDecrypt);
        return new String(cipher.doFinal(finalByteString));
    }


}