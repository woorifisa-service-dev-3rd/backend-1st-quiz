package dev.util;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AESCryptoUtil {
	
    /**
     * 키 반환
     */
    public static SecretKey getKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey secretKey = keyGenerator.generateKey();
        return secretKey;
    }
	
    /**
     * 초기화 벡터 반환
     */
    public static IvParameterSpec getIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return new IvParameterSpec(iv);
    }
	public static String encrypt(String specName, SecretKey key, IvParameterSpec iv,
			String plainText) throws Exception {
			Cipher cipher = Cipher.getInstance(specName);
			cipher.init(Cipher.ENCRYPT_MODE, key, iv);
			byte[] encrypted = cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
			return new String(Base64.getEncoder().encode(encrypted));
		}

		public static String decrypt(String specName, SecretKey key, IvParameterSpec iv,
			String cipherText) throws Exception {
			Cipher cipher = Cipher.getInstance(specName);
			cipher.init(Cipher.DECRYPT_MODE, key, iv); // 모드가 다르다.
			byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(cipherText));
			return new String(decrypted, StandardCharsets.UTF_8);
		}

}
