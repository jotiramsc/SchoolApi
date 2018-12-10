package com.spi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spi.model.User;

/**
 * Created by rajeevkumarsingh on 02/08/17.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsernameOrEmail(String username, String email);

    List<User> findByIdIn(List<Long> userIds);

    Optional<User> findByUsername(String username);
    
    Optional<User> findByRefIdAndTypeId(int refId,int typeId);

    Boolean existsByUsername(String username);
    Optional<User> findByMobile(String mobile);
    Boolean existsByMobile(String mobile);

    Boolean existsByEmail(String email);
}
