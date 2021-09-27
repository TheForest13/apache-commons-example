package com.theforest.apachecommonsexample.crypto;

import org.apache.commons.crypto.cipher.CryptoCipher;
import org.apache.commons.crypto.cipher.CryptoCipherFactory;
import org.apache.commons.crypto.random.CryptoRandom;
import org.apache.commons.crypto.random.CryptoRandomFactory;
import org.apache.commons.crypto.utils.Utils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import java.util.Properties;

/**
 * A cryptographic library optimized with AES-NI wrapping Openssl or JCE algorithm implementations.
 */
public class CryptoExample {

    public static void main(String[] args) throws InvalidAlgorithmParameterException, ShortBufferException, IllegalBlockSizeException, IOException, BadPaddingException, InvalidKeyException {
//        cryptoRandom();
            usageOfByteArrayEncryptionDecryption();

    }

    private static void usageOfByteArrayEncryptionDecryption() throws IOException, ShortBufferException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        final SecretKeySpec key = new SecretKeySpec(getUTF8Bytes("1234567890123456"), "AES");
        final IvParameterSpec iv = new IvParameterSpec(getUTF8Bytes("1234567890123456"));

        final Properties properties = new Properties();
        properties.setProperty(CryptoCipherFactory.CLASSES_KEY, CryptoCipherFactory.CipherProvider.OPENSSL.getClassName());
        //Creates a CryptoCipher instance with the transformation and properties.
        final String transform = "AES/CBC/PKCS5Padding";
        final CryptoCipher encipher = Utils.getCipherInstance(transform, properties);
        System.out.println("Cipher:  " + encipher.getClass().getCanonicalName());

        final String sampleInput = "hello world!";
        System.out.println("input:  " + sampleInput);

        final byte[] input = getUTF8Bytes(sampleInput);
        final byte[] output = new byte[32];

        //Initializes the cipher with ENCRYPT_MODE, key and iv.
        encipher.init(Cipher.ENCRYPT_MODE, key, iv);
        //Continues a multiple-part encryption/decryption operation for byte array.
        final int updateBytes = encipher.update(input, 0, input.length, output, 0);
        System.out.println(updateBytes);
        //We must call doFinal at the end of encryption/decryption.
        final int finalBytes = encipher.doFinal(input, 0, 0, output, updateBytes);
        System.out.println(finalBytes);
        //Closes the cipher.
        encipher.close();

        System.out.println(Arrays.toString(Arrays.copyOf(output, updateBytes + finalBytes)));

        // Now reverse the process using a different implementation with the same settings
        properties.setProperty(CryptoCipherFactory.CLASSES_KEY, CryptoCipherFactory.CipherProvider.JCE.getClassName());
        final CryptoCipher decipher = Utils.getCipherInstance(transform, properties);
        System.out.println("Cipher:  " + encipher.getClass().getCanonicalName());

        decipher.init(Cipher.DECRYPT_MODE, key, iv);
        final byte[] decoded = new byte[32];
        decipher.doFinal(output, 0, updateBytes + finalBytes, decoded, 0);

        System.out.println("output: " + new String(decoded, StandardCharsets.UTF_8));
    }

    /**
     * Converts String to UTF8 bytes
     *
     * @param input the input string
     * @return UTF8 bytes
     */
    private static byte[] getUTF8Bytes(final String input) {
        return input.getBytes(StandardCharsets.UTF_8);
    }

    /**
     * CryptoRandom provides a cryptographically strong random number generators.
     * The default implementation will use Intel® Digital Random Number Generator (DRNG) for accelerating the random generation.
     */
    private static void cryptoRandom() {
        // Constructs a byte array to store random data.
        final byte[] key = new byte[16];
        final byte[] iv = new byte[32];

        final Properties properties = new Properties();
        properties.put(CryptoRandomFactory.CLASSES_KEY,
                CryptoRandomFactory.RandomProvider.OPENSSL.getClassName());

        // Gets the 'CryptoRandom' instance.
        try (CryptoRandom random = CryptoRandomFactory.getCryptoRandom(properties)) {

            // Show the actual class (may be different from the one requested)
            System.out.println(random.getClass().getCanonicalName());

            // Generate random bytes and places them into the byte arrays.
            random.nextBytes(key);
            random.nextBytes(iv);

        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Show the generated output
        System.out.println(Arrays.toString(key));
        System.out.println(Arrays.toString(iv));
    }
}
