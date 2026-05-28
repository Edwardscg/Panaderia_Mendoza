package com.mendozabakery.bakeryappbackend.service;

import com.mendozabakery.bakeryappbackend.model.UserAccount;
import com.mendozabakery.bakeryappbackend.repository.IUserAccountRepositoryI;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAccountService implements IUserAccountService{
    private final IUserAccountRepositoryI repo;

    @Override
    public UserAccount save(UserAccount user) throws Exception{
        return repo.save(user);
    }

    @Override
    public UserAccount update(UserAccount user, Integer id) throws Exception{
        user.setIdUser(id);
        return repo.save(user);
    }

    @Override
    public List<UserAccount> findAll() throws Exception{
        return repo.findAll();
    }

    @Override
    public UserAccount findById(Integer id) throws Exception{
        return repo.findById(id).orElse(new UserAccount());
    }

    @Override
    public void delete(Integer id) throws Exception{
        repo.deleteById(id);
    }
}
