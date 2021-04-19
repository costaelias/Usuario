package com.costaelias.agenda.controllers;

import com.costaelias.agenda.models.UserModel;
import com.costaelias.agenda.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping()
    public ArrayList<UserModel> getUsers(){
        return userService.getUsers();
    }

    @PostMapping()
    public UserModel setUsers(@RequestBody UserModel user){
        return this.userService.setUser(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<UserModel> getUserById(@PathVariable("id") Long id){
        return this.userService.getUserById(id);
    }
    @GetMapping(path = "/puesto")
    public ArrayList<UserModel> getUserByPriority(@RequestParam("prioridad") Integer prioridad){
        return this.userService.getUserByPriority(prioridad);
    }

    @DeleteMapping(path = "/{id}")
    public String  deleteUser(Long id){
        return this.userService.deleteUser(id);
    }
}
