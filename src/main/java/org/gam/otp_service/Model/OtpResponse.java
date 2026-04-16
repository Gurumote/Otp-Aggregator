package org.gam.otp_service.Model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.gam.otp_service.Enum.OtpStatus;
import org.gam.otp_service.Enum.OtpType;

@Builder
@Getter
@Setter

public class OtpResponse {
    OtpStatus status;
    OtpType type;
    String target;
}
