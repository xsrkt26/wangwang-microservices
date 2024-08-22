package com.example.wangwangmessage.Service;

import com.example.wangwangmessage.Entity.Message;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
public interface MessageService {
    void CreateMessage(String sender, int receiver, String title, String body, LocalDate send_date, LocalTime send_time);

    List<Message> SelectMessageByReceiver(int receiver);

    int CountNumberOfMessageByReceiver(int receiver);

    int CountNumberOfUnreadMessageByReceiver(int receiver);

    List<Message> SelectUnreadMessageByReceiver(int receiver);

    List<Message> SelectMessageByDateAndReceiver(int receiver, LocalDate send_date);

    List<Message> SelectUnreadMessageByDateAndReceiver(int receiver, LocalDate send_date);

    void SetRead(int message_id);

}
