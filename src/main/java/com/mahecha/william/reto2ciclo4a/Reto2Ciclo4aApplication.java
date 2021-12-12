package com.mahecha.william.reto2ciclo4a;

import com.mahecha.william.reto2ciclo4a.model.User;
import com.mahecha.william.reto2ciclo4a.repository.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.util.List;

@SpringBootApplication(exclude= {DataSourceAutoConfiguration.class})
public class Reto2Ciclo4aApplication implements CommandLineRunner {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public static void main(String[] args) {
        SpringApplication.run(Reto2Ciclo4aApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userCrudRepository.deleteAll();
        /*userCrudRepository.saveAll(List.of(
                new User(1, "1118557622", "William Mahecha", "cll 38 # 44 - 51", "3208088701", "wsmh99@hotmail.com", "Demo", "Zona1", "ADM")
        ));*/
    }
}
