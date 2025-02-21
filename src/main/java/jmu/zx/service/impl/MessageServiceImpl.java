package jmu.zx.service.impl;

import jmu.zx.mapper.MessageMapper;
import jmu.zx.pojo.Message;
import jmu.zx.service.MessageService;
import jmu.zx.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageMapper messageMapper;

    @Override
    public void add(Message message) {

        messageMapper.add(message);
    }

    @Override
    public void delete(Integer messageId) {
        messageMapper.deleteMessageByMessageId(messageId);
    }

    @Override
    public List<Message> searchAll() {
        List<Message> message = messageMapper.searchAll();
        return message;
    }

    @Override
    public void updateMessage(Message message) {
        messageMapper.update(message);
    }

    @Override
    public Message searchByMessageId(Integer messageId) {
        Message message = messageMapper.searchByMessageId(messageId);
        return message;
    }
}
