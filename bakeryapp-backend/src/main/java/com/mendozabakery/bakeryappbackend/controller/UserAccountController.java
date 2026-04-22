package com.mendozabakery.bakeryappbackend.controller;

<<<<<<< HEAD
import com.mendozabakery.bakeryappbackend.model.UserAccount;
import com.mendozabakery.bakeryappbackend.service.IUserAccountService;
=======
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

<<<<<<< HEAD
=======
import com.mendozabakery.bakeryappbackend.model.UserAccount;
import com.mendozabakery.bakeryappbackend.service.IUserAccountService;

>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserAccountController {
<<<<<<< HEAD
    private final IUserAccountService service;

    @GetMapping
    public List<UserAccount> findAll() throws Exception{
=======

    private final IUserAccountService service;

    @GetMapping
    public List<UserAccount> findAll() throws Exception {
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
        return service.findAll();
    }

    @GetMapping("/{id}")
<<<<<<< HEAD
    public UserAccount findById(@PathVariable("id") Integer id) throws Exception{
=======
    public UserAccount findById(@PathVariable Integer id) throws Exception {
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
        return service.findById(id);
    }

    @PostMapping
<<<<<<< HEAD
    public UserAccount save(@RequestBody UserAccount user) throws Exception{
=======
    public UserAccount save(@RequestBody UserAccount user) throws Exception {
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
        return service.save(user);
    }

    @PutMapping("/{id}")
<<<<<<< HEAD
    public UserAccount update(@RequestBody UserAccount user, @PathVariable("id") Integer id) throws Exception{
=======
    public UserAccount update(@RequestBody UserAccount user, @PathVariable Integer id) throws Exception {
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
        return service.update(user, id);
    }

    @DeleteMapping("/{id}")
<<<<<<< HEAD
    public void delete(@PathVariable("id") Integer id) throws Exception{
        service.delete(id);
    }
}
=======
    public void delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
    }
}
>>>>>>> 11700e352c685a1e20412792ab1fe30558dfa39e
