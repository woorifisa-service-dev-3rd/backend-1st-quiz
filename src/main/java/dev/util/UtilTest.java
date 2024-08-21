//package dev.util;
//
//import javax.crypto.SecretKey;
//import javax.crypto.spec.IvParameterSpec;
//
//public class UtilTest {
//
//	public static void main(String[] args) throws Exception {
//		String plainText = "Hello, MadPlay!";
//
//		SecretKey key = AESCryptoUtil.getKey();
//		IvParameterSpec ivParameterSpec = AESCryptoUtil.getIv();
//		String specName = "AES/CBC/PKCS5Padding";
//
//		String encryptedText = AESCryptoUtil.encrypt(specName, key, ivParameterSpec, plainText);
//		String decryptedText = AESCryptoUtil.decrypt(specName, key, ivParameterSpec, encryptedText);
//
//		System.out.println("cipherText: " + encryptedText);
//		System.out.println("plainText: " + decryptedText);
//
//	}
//
//}
