package com.mendozabakery.bakeryappbackend.service;

import java.util.List;
import com.mendozabakery.bakeryappbackend.model.UserAccount;

public interface IUserAccountService {

    UserAccount save(UserAccount user) throws Exception;

    UserAccount update(UserAccount user, Integer id) throws Exception;

    List<UserAccount> findAll() throws Exception;

    UserAccount findById(Integer id) throws Exception;

    void delete(Integer id) throws Exception;
}