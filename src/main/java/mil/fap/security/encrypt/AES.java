package mil.fap.security.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * @author Fabian Perez Vasquez
 */

public class AES {

    private final byte[] password = "9827637890298371".getBytes();
    private final byte[] vector = "1738920987367289".getBytes();

    IvParameterSpec iv;
    SecretKeySpec keySpec;
    Cipher cipher;

    public AES() {
        try {
            iv = new IvParameterSpec(vector);
            keySpec = new SecretKeySpec(password, "AES");
            cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public String encrypt(String value) throws Exception {
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, iv);

        byte[] encrypted = cipher.doFinal(value.getBytes());

        return Base64.encodeBase64String(encrypted);
    }

    public String decrypt(String value) throws Exception {
        cipher.init(Cipher.DECRYPT_MODE, keySpec, iv);
        
        byte[] original = cipher.doFinal(Base64.decodeBase64(value));
        
        return new String(original);
    }
    
}
