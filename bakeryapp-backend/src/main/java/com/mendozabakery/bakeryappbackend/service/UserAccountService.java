package com.mendozabakery.bakeryappbackend.service;

<<<<<<< HEAD
=======
import com.mendozabakery.bakeryappbackend.model.UserAccount;
import com.mendozabakery.bakeryappbackend.repository.IUserAccountRepositoryI;
>>>>>>> 548ce5e59d8f02655bdaa7f4d5a5315cf75b3dd1
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import com.mendozabakery.bakeryappbackend.model.UserAccount;
import com.mendozabakery.bakeryappbackend.repository.IUserAccountRepository;

@Service
@RequiredArgsConstructor
<<<<<<< HEAD
public class UserAccountService implements IUserAccountService {

    private final IUserAccountRepository repo;
=======
public class UserAccountService implements IUserAccountService{
    private final IUserAccountRepositoryI repo;
>>>>>>> 548ce5e59d8f02655bdaa7f4d5a5315cf75b3dd1

    @Override
    public UserAccount save(UserAccount user) throws Exception {
        return repo.save(user);
    }

    @Override
    public UserAccount update(UserAccount user, Integer id) throws Exception{

        user.setIdUser(id);
        return repo.save(user);
    }

    @Override

    public List<UserAccount> findAll() throws Exception {
        return repo.findAll();
    }

    @Override

    public UserAccount findById(Integer id) throws Exception {
        return repo.findById(id).orElse(new UserAccount());
    }

    @Override
    public void delete(Integer id) throws Exception {
        repo.deleteById(id);
    }
}
