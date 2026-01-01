package resumeBuider.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import resumeBuider.model.UserLogin;

import java.util.Optional;

public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {

    Optional<UserLogin> findByEmailAndPassword(String email, String password);
}

