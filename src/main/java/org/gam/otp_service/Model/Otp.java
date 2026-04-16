package org.gam.otp_service.Model;


import jakarta.persistence.*;
import lombok.*;
import org.gam.otp_service.Enum.OtpStatus;
import org.gam.otp_service.Enum.OtpType;
import org.gam.otp_service.Enum.OtpPurpose;

import java.time.LocalDateTime;

@Getter@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Otp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String target;

    

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OtpType channel;
    @Column(nullable = false)
    private String otpHash;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OtpPurpose OtpPurpose;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private OtpStatus status;

    @Column(updatable = false,nullable = false)
    private LocalDateTime expiresAt;
    @Column(updatable = false,nullable = false)
    private LocalDateTime createdAt;
    private LocalDateTime verifiedAt;

    @Column(nullable = false)
    private int attempts;
    @Column(nullable = false)
    private int resendCount;

}
