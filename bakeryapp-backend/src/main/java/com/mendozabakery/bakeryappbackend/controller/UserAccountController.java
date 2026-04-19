package com.mendozabakery.bakeryappbackend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.mendozabakery.bakeryappbackend.model.UserAccount;
import com.mendozabakery.bakeryappbackend.service.IUserAccountService;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserAccountController {

    private final IUserAccountService service;

    @GetMapping
    public List<UserAccount> findAll() throws Exception {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public UserAccount findById(@PathVariable Integer id) throws Exception {
        return service.findById(id);
    }

    @PostMapping
    public UserAccount save(@RequestBody UserAccount user) throws Exception {
        return service.save(user);
    }

    @PutMapping("/{id}")
    public UserAccount update(@RequestBody UserAccount user, @PathVariable Integer id) throws Exception {
        return service.update(user, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) throws Exception {
        service.delete(id);
    }
}