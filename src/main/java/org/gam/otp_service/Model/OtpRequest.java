package org.gam.otp_service.Model;


import lombok.Getter;
import lombok.Setter;
import org.gam.otp_service.Enum.OtpPurpose;
import org.gam.otp_service.Enum.OtpType;

@Getter@Setter
public class OtpRequest {

    String target;
    OtpType type;
    OtpPurpose purpose;
}
