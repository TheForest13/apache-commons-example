package com.theforest.apachecommonsexample.codec;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.net.URLCodec;

/**
 * General encoding/decoding algorithms (for example phonetic, base64, URL).
 */
public class CodecExample {
    public static void main(String[] args) throws DecoderException {
        String base64 = Base64.encodeBase64String(new byte[]{64, 44});
        System.out.println(base64);
        String hex = Hex.encodeHexString(new byte[]{64, 44});
        System.out.println(hex);
        byte[] urlCodec = URLCodec.decodeUrl(new byte[]{64, 44});
        System.out.println(urlCodec.length);
    }
}
