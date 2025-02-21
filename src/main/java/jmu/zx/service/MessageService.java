package jmu.zx.service;

import jmu.zx.pojo.Message;

import java.util.List;

public interface MessageService {
    void add(Message message);

    void delete(Integer messageId);

    List<Message> searchAll();

    void updateMessage(Message message);

    Message searchByMessageId(Integer messageId);
}
