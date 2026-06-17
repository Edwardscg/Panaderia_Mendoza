package com.mendozabakery.bakeryappbackend.service;

import com.mendozabakery.bakeryappbackend.model.User;

public interface IUserService extends IGenericService<User, Integer>{

    User findOneByUsername(String username);
    void changePassword(String username, String password);

//    User save(User user) throws Exception;
//
//    User update(User user, Integer id) throws Exception;
//
//    List<User> findAll() throws Exception;
//
//    User findById(Integer id) throws Exception;
//
//    void delete(Integer id) throws Exception;
}

