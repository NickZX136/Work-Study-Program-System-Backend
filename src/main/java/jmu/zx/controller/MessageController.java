package jmu.zx.controller;

import jmu.zx.pojo.Message;
import jmu.zx.pojo.Result;
import jmu.zx.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @PostMapping("/add")
    public Result add(@RequestBody Message message){
        messageService.add(message);
        return Result.success();
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam("messageId") Integer messageId){
        System.out.println(messageId);
        messageService.delete(messageId);
        return Result.success();
    }

    @GetMapping("/searchAll")
    public Result<List<Message>> searchAll(){
        List<Message> message = messageService.searchAll();
        return Result.success(message);
    }

    @PutMapping("/update")
    public Result updateMessage(@RequestBody Message message){
        messageService.updateMessage(message);
        return Result.success();
    }

    @GetMapping("searchByMessageId")
    public Result searchByMessageId(@RequestParam("messageId") Integer messageId){
        Message message = messageService.searchByMessageId(messageId);
        return Result.success(message);
    }

}
