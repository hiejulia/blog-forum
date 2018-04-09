package com.project.blogforum.service.impl;
import com.project.blogforum.domain.User;
import com.project.blogforum.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(User user) {
        userRepository.save(user);
    }

    public User findUserById(Long id) {
        return userRepository.findUserById(id);
    }

    public void changeUserNickname(String nickname, Long id) {
        userRepository.changeUserUsername(nickname, id);
    }

    public User findUserByNickname(String username) {
        return userRepository.findUserByUsername(username);
    }

    public User findUserByLogin(String login) {
        return userRepository.findUserByLogin(login);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteUserById(id);
    }
}