package com.mahecha.william.reto2ciclo4a.repository;

import com.mahecha.william.reto2ciclo4a.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository crudRepository;

    public Optional<User> getUser(int id) {
        return crudRepository.findById(id);
    }

    public User create(User user) {
        return crudRepository.save(user);
    }

    public void update(User user) {
        crudRepository.save(user);
    }

    public void delete(User user) {
        crudRepository.delete(user);
    }

    public List<User> listar() {
        return crudRepository.findAll();
    }

    public boolean emailExist(String email) {
        Optional<User> usuario = crudRepository.findByEmail(email);
        return !usuario.isEmpty();
    }

    public Optional<User> authenticateUser(String email, String password) {
        return crudRepository.findByEmailAndPassword(email, password);
    }
}
