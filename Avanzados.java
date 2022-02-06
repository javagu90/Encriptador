/**
 * @(#)MD5.java
 *
 *
 * @author Javier Valderrábano Gutiérrez
 * @version 1.00 2013/3/27
 */
package Cryptography;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class Avanzados 
{
 private static String toHexadecimal(byte[] digest)
 {
  String hash = "";

        for(byte aux : digest) {
        	System.out.println("aux: "+aux);

            int b = aux & 0xff;
            System.out.println("b: "+b);

            if (Integer.toHexString(b).length() == 1) hash += "0";

            hash += Integer.toHexString(b);
            System.out.println(hash);

        }

        return hash;

    }

    public static String getStringMessageDigest(String message, String algorithm){

        byte[] digest = null;

        byte[] buffer = message.getBytes();

        try {

            MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

            messageDigest.reset();
            
            messageDigest.update(buffer);

            digest = messageDigest.digest();
            System.out.println("dig:"+ digest);

        } catch (NoSuchAlgorithmException ex) {

            System.out.println("Error creando Digest");

        }

        return toHexadecimal(digest);
    }

}
