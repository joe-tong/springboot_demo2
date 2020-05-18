package com.example.login.service;


import com.example.login.pojo.UserBO;

public interface UserService {

    String buildUserInfo(UserBO userBO);

    void logout(String jwt);

}
