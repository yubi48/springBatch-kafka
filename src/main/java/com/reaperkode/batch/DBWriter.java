package com.reaperkode.batch;

import com.reaperkode.model.User;
import com.reaperkode.repository.UserRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<User> {

    private final UserRepository userRepository;

    @Autowired
    public DBWriter(UserRepository userRepository){
        this.userRepository = userRepository;
    }


    @Override
    public void write(List<? extends User> users) throws Exception {
        System.out.println("data save for users: " + users);
        userRepository.saveAll(users);
    }
}
