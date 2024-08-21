package dev.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHashing {

    public String hashPassword(String password) {
        String hashed = "";
        try {
            // SHA-256 알고리즘 객체 생성
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // 비밀번호의 바이트 배열에 SHA-256 적용
            byte[] bytes = md.digest(password.getBytes());

            // 바이트 배열을 16진수 문자열로 변환
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }

            hashed = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace(); // 예외 처리
        }

        return hashed;
    }
}
