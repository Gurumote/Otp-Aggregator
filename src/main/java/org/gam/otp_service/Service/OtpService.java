package org.gam.otp_service.Service;


import lombok.RequiredArgsConstructor;
import org.gam.otp_service.Enum.OtpStatus;
import org.gam.otp_service.Model.Otp;
import org.gam.otp_service.Model.OtpRequest;
import org.gam.otp_service.Model.OtpResponse;
import org.gam.otp_service.Repo.OtpRepo;
import org.gam.otp_service.Service.Componet.OtpUtil;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class OtpService {
    private final OtpRepo otpRepo;
    private final OtpUtil otpUtil;
    private final OtpDispatchService otpDispatchService;
    public  OtpResponse sendOtp(OtpRequest otp) {
        Otp otp1=Otp.builder()
                .target(otp.getTarget())
                .OtpPurpose(otp.getPurpose())
                .otpHash(otpUtil.generateOtp())
                .channel(otp.getType())
                .status(OtpStatus.PENDING)
                .attempts(0)
                .resendCount(0)
                .createdAt(LocalDateTime.now())
                .expiresAt(LocalDateTime.now().plusMinutes(10))
                .verifiedAt(null)
                .build();
        otpRepo.save(otp1);
        boolean resp=otpDispatchService.sendService(otp1);
        OtpResponse otpResponse = null;
        if(resp){
            otpResponse=convertToResp(otp1);
        }
        if (otpResponse == null) {
            throw new RuntimeException("OTP not found");
        }
        return otpResponse;
    }

    private OtpResponse convertToResp(Otp otp1) {
        return  OtpResponse.builder()
                .status(otp1.getStatus())
                .type(otp1.getChannel())
                .target(otp1.getTarget()).build();
    }
}
