package org.gam.otp_service.Repo;

import org.gam.otp_service.Model.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepo extends JpaRepository<Otp,Long> {
}
