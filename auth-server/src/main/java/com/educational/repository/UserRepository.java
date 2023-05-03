package com.educational.repository;

import com.educational.domain.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByEmail(String email);
}
