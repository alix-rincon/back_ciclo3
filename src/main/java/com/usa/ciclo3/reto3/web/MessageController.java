package com.usa.ciclo3.reto3.web;

import java.util.List;
import java.util.Optional;
import com.usa.ciclo3.reto3.model.Message;
import com.usa.ciclo3.reto3.service.MessageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getMessages() {
        return messageService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Message> getMessage(@PathVariable("id") int messageId) {
        return messageService.getMessageId(messageId);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Message saveMessage(@RequestBody Message message) {
        return messageService.saveMessage(message);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Message update(@RequestBody Message message) {
        return messageService.updateMessage(message);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int messageId) {
        return messageService.deleteMessage(messageId);
    }

}
