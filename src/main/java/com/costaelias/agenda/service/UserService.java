package com.costaelias.agenda.service;

import com.costaelias.agenda.models.UserModel;
import com.costaelias.agenda.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ArrayList<UserModel> getUsers(){

        return (ArrayList<UserModel>) this.userRepository.findAll();
    }

    public UserModel setUser(UserModel userModel){

        return this.userRepository.save(userModel);
    }

    public Optional<UserModel> getUserById(Long id){
        return this.userRepository.findById(id);
    }

    public ArrayList<UserModel> getUserByPriority(Integer prioridad){
        return this.userRepository.findByPrioridad(prioridad);
    }

    public String deleteUser(Long id){
        try{
            this.userRepository.deleteById(id);
            return "Usuario eliminado";
        } catch (Exception e){
            return "No existe usuario con el id " + id;
        }
    }
}
