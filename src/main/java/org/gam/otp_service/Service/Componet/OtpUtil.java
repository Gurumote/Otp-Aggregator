package org.gam.otp_service.Service.Componet;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;


@Component
public class OtpUtil {
    private final SecureRandom random = new SecureRandom();

    public  String generateOtp() {
        int otp = 100000 + random.nextInt(900000); // 6-digit OTP
        return hashOtp(Integer.toString(otp));
    }

    public  String hashOtp(String otp) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(otp.getBytes(StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Error while hashing OTP", e);
        }
    }
}
