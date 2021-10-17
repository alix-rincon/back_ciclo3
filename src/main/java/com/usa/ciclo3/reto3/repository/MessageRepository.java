package com.usa.ciclo3.reto3.repository;

import com.usa.ciclo3.reto3.repository.crud.MessageCrudRepository;
import org.springframework.stereotype.Repository;
import com.usa.ciclo3.reto3.model.Message;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<Message> getAll() {
        return (List<Message>) messageCrudRepository.findAll();
    }

    public Optional<Message> getMessageId(int id) {
        return messageCrudRepository.findById(id);
    }

    public Message saveMessage(Message message) {
        return messageCrudRepository.save(message);
    }

    public void delete(Message message){
        messageCrudRepository.delete(message);
    }
    
}
