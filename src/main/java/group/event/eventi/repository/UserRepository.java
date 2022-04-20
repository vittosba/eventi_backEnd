package group.event.eventi.repository;

// import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import group.event.eventi.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	// List<User> findLogin(String email);
}
