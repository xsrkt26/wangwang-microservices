package com.example.wangwangmessage.Controller;

import com.example.wangwangmessage.Entity.Message;
import com.example.wangwangmessage.Entity.R;
import com.example.wangwangmessage.Service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@CrossOrigin
@Slf4j
@Controller
@RestController
@RequestMapping(value = "/message")
public class MessageController {
    @Autowired
    MessageService messageService;
    @PostMapping(value = "/create")
    public R createMessage(@RequestBody Map<String, String> messageMap){
        String send = messageMap.get("sender");
        int receive = Integer.parseInt(messageMap.get("receiver"));
        String title = messageMap.get("title");
        String body = messageMap.get("body");
        LocalDate send_date = LocalDate.now();
        LocalTime send_time = LocalTime.now();
        try {
            messageService.CreateMessage(send, receive, title, body, send_date, send_time);
            return R.ok("消息推送成功！");
        }catch (Exception e){
            return R.error("消息推送失败！");
        }
    }

    @GetMapping(value = "/baseselect")
    public List<Message> selectMessage(@RequestParam("receiver") int receiver){
        List<Message> messages = messageService.SelectMessageByReceiver(receiver);
        return messages;
    }

    @GetMapping(value = "/numberselect")
    public int selectNumberOfMessage(@RequestParam("receiver") int receiver){
        int num = messageService.CountNumberOfMessageByReceiver(receiver);
        return num;
    }

    @GetMapping(value = "/unreadnumberselect")
    public int selectNumberOfUnreadMessage(@RequestParam("receiver") int receiver){
        int num = messageService.CountNumberOfUnreadMessageByReceiver(receiver);
        return num;
    }

    @GetMapping(value = "/unreadselect")
    public List<Message> selectUnreadMessage(@RequestParam("receiver") int receiver){
        List<Message> messages = messageService.SelectUnreadMessageByReceiver(receiver);
        return messages;
    }

    @GetMapping(value = "/dateselect")
    public List<Message> selectMessageByDate(@RequestParam("receiver") int receiver, @RequestParam("send_date") LocalDate send_date){
        List<Message> messages = messageService.SelectMessageByDateAndReceiver(receiver, send_date);
        return messages;
    }

    @GetMapping(value = "/unreaddateselect")
    public List<Message> selectUnreadMessageByDate(@RequestParam("receiver") int receiver, @RequestParam("send_date") LocalDate send_date){
        List<Message> messages = messageService.SelectUnreadMessageByDateAndReceiver(receiver, send_date);
        return messages;
    }

    @PutMapping(value = "/setread")
    public R setRead(@RequestParam("message_id") int message_id){
        try {
            messageService.SetRead(message_id);
            return R.ok("已设置为已读。");
        }catch (Exception e){
            return R.error(e.toString());
        }
    }
}
