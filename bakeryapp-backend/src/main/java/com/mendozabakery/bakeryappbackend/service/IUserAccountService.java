package com.mendozabakery.bakeryappbackend.service;

<<<<<<< HEAD
import com.mendozabakery.bakeryappbackend.model.UserAccount;

import java.util.List;

public interface IUserAccountService {
    UserAccount save(UserAccount user) throws Exception;
    UserAccount update(UserAccount user, Integer id) throws Exception;
    List<UserAccount> findAll() throws Exception;
    UserAccount findById(Integer id) throws Exception;
    void delete(Integer id) throws Exception;
}
=======
import java.util.List;
import com.mendozabakery.bakeryappbackend.model.UserAccount;

public interface IUserAccountService {

    UserAccount save(UserAccount user) throws Exception;

    UserAccount update(UserAccount user, Integer id) throws Exception;

    List<UserAccount> findAll() throws Exception;

    UserAccount findById(Integer id) throws Exception;

    void delete(Integer id) throws Exception;
}
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
