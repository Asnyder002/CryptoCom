
package cripto;


import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;


public class Decryption
{

    public static String decrypt(String strToDecrypt, SecretKey secretKey)
    {
        try
        {

            Cipher decrypt = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            decrypt.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(decrypt.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        }
        catch (Exception e)
        {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

}
