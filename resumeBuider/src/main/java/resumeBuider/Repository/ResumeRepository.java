package resumeBuider.Repository; // This is a sub-package of 'resumeBuider'

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import resumeBuider.Entity.ResumeEntity;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ResumeRepository extends JpaRepository<ResumeEntity, UUID> {
    Optional<ResumeEntity> findByEmail(String email);
    Optional<ResumeEntity> findByEmailOrPhone(
            @Param("email") String email,
            @Param("phone") String phone
    );
}