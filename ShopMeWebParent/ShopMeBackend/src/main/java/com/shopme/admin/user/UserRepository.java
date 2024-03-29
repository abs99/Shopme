package com.shopme.admin.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopme.common.entity.User;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("Select u from User u where u.email = :email")
    public User getUserByEmailId(@Param("email") String email);

}
