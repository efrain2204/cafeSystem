package com.inn.cafe.cafebackend.JWT;

import com.inn.cafe.cafebackend.POJO.User;
import com.inn.cafe.cafebackend.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Objects;

@Slf4j
@Service
public class CustomerUsersDetailsService implements UserDetailsService {
    private final UserDao userDao;

    public CustomerUsersDetailsService(UserDao userDao) {
        this.userDao = userDao;
    }

    private com.inn.cafe.cafebackend.POJO.User userDetail;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Loading UserDetails for {}", username);
        userDetail = userDao.findByEmailId(username);
        if(!Objects.isNull(userDetail)){
            return new org.springframework.security.core.userdetails.User(userDetail.getEmail(),userDetail.getPassword(),new ArrayList<>());
        }else {
            throw  new UsernameNotFoundException("User not found");
        }
    }

    public com.inn.cafe.cafebackend.POJO.User getUserDetail(){
        com.inn.cafe.cafebackend.POJO.User user = userDetail;
        user.setPassword(null);
        return  user;
    }
}
