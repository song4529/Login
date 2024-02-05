package com.example.login.user;

import com.example.login.user.entity.User;
import com.example.login.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoginService {
    @Autowired
    private final UserRepository userRepository;

    public boolean login(User user) {

        User findUser = userRepository.findByUserId(user.getUserId());

        if(findUser == null){
            return false;
        }

        if(!findUser.getPassword().equals(user.getPassword())){
            return false;
        }

        return true;
    }

}