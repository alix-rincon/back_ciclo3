package com.usa.ciclo3.reto3.service;

import java.util.List;
import java.util.Optional;
import com.usa.ciclo3.reto3.model.Message;
import com.usa.ciclo3.reto3.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Alix Rincón
 */
@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    /**
     * @return
     */
    public List<Message> getAll() {
        return messageRepository.getAll();
    }

    /**
     * @param messageId
     * @return
     */
    public Optional<Message> getMessageId(int messageId) {
        return messageRepository.getMessageId(messageId);
    }

    /**
     * 
     * @param message
     * @return
     */
    public Message saveMessage(Message message) {
        if (message.getIdMessage() == null) {
            return messageRepository.saveMessage(message);
        } else {
            Optional<Message> e = messageRepository.getMessageId(message.getIdMessage());
            if (e.isEmpty()) {
                return messageRepository.saveMessage(message);
            } else {
                return message;
            }
        }
    }

    /**
     * 
     * @param message
     * @return
     */
    public Message updateMessage(Message message) {
        if (message.getIdMessage() != null) {
            Optional<Message> e = messageRepository.getMessageId(message.getIdMessage());
            if (!e.isEmpty()) {
                if (message.getMessageText() != null) {
                    e.get().setMessageText(message.getMessageText());
                }
                messageRepository.saveMessage(e.get());
                return e.get();
            } else {
                return message;
            }
        } else {
            return message;
        }
    }

    /**
     * 
     * @param messageId
     * @return
     */
    public boolean deleteMessage(int messageId) {
        Boolean aBoolean = getMessageId(messageId).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return aBoolean;
    }

}
