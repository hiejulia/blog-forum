package com.project.blogforum.repository;

import com.project.blogforum.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    /**
     * FIND USER BY ID
     */

    User findById(Long id);

    @Query(value = "select u from User u where u.id = ?1")
    User findUserById(Long id);

    /**
     * FIND USER BY USERNAME
     */
    @Query(value = "select u from User u where u.username = ?1")
    User findUserByUsername(String username);


    /**
     * FIND USER BY EMAIL
     */
    @Query(value = "SELECT u FROM User u WHERE u.email = ?1")
    User findUserByEmail(String email);

    /**
     * FIND USER BY LOGIN
     */
    @Query(value = "SELECT u FROM User u WHERE u.login = ?1")
    User findUserByLogin(String login);

    /**
     * UPDATE USERNAME
     */
    @Modifying(clearAutomatically = true)
    @Query(value = "update User u set u.username=?1 where u.id=?2")
    void changeUserUsername(String username,Long id);

    /**
     * DELETE USER BY ID
     */
    @Modifying
    @Query(value = "delete from User u where u.id=?1")
    void deleteUserById(Long id);


}
