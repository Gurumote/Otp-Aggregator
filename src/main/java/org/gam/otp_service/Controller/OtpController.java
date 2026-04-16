package org.gam.otp_service.Controller;



import lombok.RequiredArgsConstructor;
import org.gam.otp_service.Model.OtpRequest;
import org.gam.otp_service.Model.OtpResponse;
import org.gam.otp_service.Service.OtpService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/otpservice")
@RequiredArgsConstructor
public class OtpController {

    private final OtpService otpService;
    @PostMapping("/send")
    public OtpResponse send(@RequestBody OtpRequest otp) {
        return otpService.sendOtp(otp);
    }
}
