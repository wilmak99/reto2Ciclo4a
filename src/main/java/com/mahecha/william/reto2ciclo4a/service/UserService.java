package com.mahecha.william.reto2ciclo4a.service;

import com.mahecha.william.reto2ciclo4a.model.User;
import com.mahecha.william.reto2ciclo4a.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repositorio;

    public List<User> listar() {
        return repositorio.listar();
    }

    public Optional<User> getUser(int id) {
        return repositorio.getUser(id);
    }

    public User create(User user) {
        if (user.getId() != null) {
            Optional<User> e = repositorio.getUser(user.getId());
            if (e.isEmpty()) {
                if (!emailExist(user.getEmail())) {
                    return repositorio.create(user);
                }
            }
        }
        return user;
    }

    public User update(User user) {
        if (user.getId() != null) {
            Optional<User> userDb = repositorio.getUser(user.getId());
            if (!userDb.isEmpty()) {
                if (user.getIdentification() != null) {
                    userDb.get().setIdentification(user.getIdentification());
                }
                if (user.getName() != null) {
                    userDb.get().setName(user.getName());
                }
                if (user.getAddress() != null) {
                    userDb.get().setAddress(user.getAddress());
                }
                if (user.getCellPhone() != null) {
                    userDb.get().setCellPhone(user.getCellPhone());
                }
                if (user.getEmail() != null) {
                    userDb.get().setEmail(user.getEmail());
                }
                if (user.getPassword() != null) {
                    userDb.get().setPassword(user.getPassword());
                }
                if (user.getZone() != null) {
                    userDb.get().setZone(user.getZone());
                }
                repositorio.update(userDb.get());
                return userDb.get();
            }
        }
        return user;
    }

    public boolean delete(int id) {
        Boolean aBoolean = getUser(id).map(user -> {
            repositorio.delete(user);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public boolean emailExist(String email) {
        return repositorio.emailExist(email);
    }

    public User authenticateUser(String email, String password) {
        Optional<User> usuario = repositorio.authenticateUser(email, password);
        if (usuario.isEmpty()){
            return new User();
        }
        return usuario.get();
    }
}
