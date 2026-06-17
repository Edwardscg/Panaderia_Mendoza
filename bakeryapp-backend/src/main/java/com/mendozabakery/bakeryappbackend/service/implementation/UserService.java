package com.mendozabakery.bakeryappbackend.service.implementation;

import com.mendozabakery.bakeryappbackend.model.User;
import com.mendozabakery.bakeryappbackend.repository.IGenericRepository;
import com.mendozabakery.bakeryappbackend.repository.IUserRepository;
import com.mendozabakery.bakeryappbackend.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService extends GenericService<User, Integer> implements IUserService {
    private final IUserRepository repo;
    private final PasswordEncoder bcrypt;

    @Override
    protected IGenericRepository<User, Integer> getRepo(){return repo;}


    @Override
    public User findOneByUsername(String username) {
        return repo.findOneByUsername(username);
    }

    @Override
    public void changePassword(String username, String newPassword) {
        repo.changePassword(username, bcrypt.encode(newPassword));
    }
//    @Override
//    public User save(User user) throws Exception {
//        return repo.save(user);
//    }
//
//    @Override
//    public User update(User user, Integer id) throws Exception{
//
//        user.setIdUser(id);
//        return repo.save(user);
//    }
//
//    @Override
//
//    public List<User> findAll() throws Exception {
//        return repo.findAll();
//    }
//
//    @Override
//
//    public User findById(Integer id) throws Exception {
//        return repo.findById(id).orElse(new User());
//    }
//
//    @Override
//    public void delete(Integer id) throws Exception {
//        repo.deleteById(id);
//    }
}
