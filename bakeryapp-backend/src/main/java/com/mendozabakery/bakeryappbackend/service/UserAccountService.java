package com.mendozabakery.bakeryappbackend.service;

<<<<<<< HEAD
import com.mendozabakery.bakeryappbackend.model.UserAccount;
import com.mendozabakery.bakeryappbackend.repository.IUserAccountRepository;
=======
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

<<<<<<< HEAD
@Service
@RequiredArgsConstructor
public class UserAccountService implements IUserAccountService{
    private final IUserAccountRepository repo;

    @Override
    public UserAccount save(UserAccount user) throws Exception{
=======
import com.mendozabakery.bakeryappbackend.model.UserAccount;
import com.mendozabakery.bakeryappbackend.repository.IUserAccountRepository;

@Service
@RequiredArgsConstructor
public class UserAccountService implements IUserAccountService {

    private final IUserAccountRepository repo;

    @Override
    public UserAccount save(UserAccount user) throws Exception {
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
        return repo.save(user);
    }

    @Override
<<<<<<< HEAD
    public UserAccount update(UserAccount user, Integer id) throws Exception{
=======
    public UserAccount update(UserAccount user, Integer id) throws Exception {
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
        user.setIdUser(id);
        return repo.save(user);
    }

    @Override
<<<<<<< HEAD
    public List<UserAccount> findAll() throws Exception{
=======
    public List<UserAccount> findAll() throws Exception {
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
        return repo.findAll();
    }

    @Override
<<<<<<< HEAD
    public UserAccount findById(Integer id) throws Exception{
=======
    public UserAccount findById(Integer id) throws Exception {
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
        return repo.findById(id).orElse(new UserAccount());
    }

    @Override
<<<<<<< HEAD
    public void delete(Integer id) throws Exception{
        repo.deleteById(id);
    }
}
=======
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
