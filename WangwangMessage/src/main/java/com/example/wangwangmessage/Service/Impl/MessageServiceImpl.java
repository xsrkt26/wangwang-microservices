package com.example.wangwangmessage.Service.Impl;

import com.example.wangwangmessage.Entity.Message;
import com.example.wangwangmessage.Dao.MessageMapper;
import org.bouncycastle.asn1.x509.Time;
import com.example.wangwangmessage.Service.MessageService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
@Service("MessageService")
public class MessageServiceImpl implements MessageService{
    @Resource
    private MessageMapper messageMapper;

    @Override
    public void CreateMessage(String sender, int receiver, String title, String body, LocalDate sendDate, LocalTime sendTime){
        messageMapper.CreateMessage(sender, receiver, title, body, sendDate, sendTime);
    }

    @Override
    public List<Message> SelectMessageByReceiver(int receiver){
        return messageMapper.SelectMessageByReceiver(receiver);
    }

    @Override
    public int CountNumberOfMessageByReceiver(int receiver){
        return messageMapper.CountNumberOfMessageByReceiver(receiver);
    }

    @Override
    public int CountNumberOfUnreadMessageByReceiver(int receiver){
        return messageMapper.CountNumberOfUnreadMessageByReceiver(receiver);
    }

    @Override
    public List<Message> SelectUnreadMessageByReceiver(int receiver){
        return messageMapper.SelectUnreadMessageByReceiver(receiver);
    }

    @Override
    public List<Message> SelectMessageByDateAndReceiver(int receiver, LocalDate sendDate){
        return messageMapper.SelectMessageByDateAndReceiver(receiver, sendDate);
    }

    @Override
    public List<Message> SelectUnreadMessageByDateAndReceiver(int receiver, LocalDate sendDate){
        return messageMapper.SelectUnreadMessageByDateAndReceiver(receiver, sendDate);
    }

    @Override
    public void SetRead(int messageId){
        messageMapper.SetRead(messageId);
    }
}
