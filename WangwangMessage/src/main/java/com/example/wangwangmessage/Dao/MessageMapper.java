package com.example.wangwangmessage.Dao;

import com.example.wangwangmessage.Entity.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Mapper
public interface MessageMapper {
    @Insert("insert into messages (sender, receiver, title, body, send_date, send_time) values (#{sender}, #{receiver}, #{title}, #{body}, #{send_date}, #{send_time});")
    void CreateMessage(String sender, int receiver, String title, String body, LocalDate send_date, LocalTime send_time);

    @Select("select * from messages where receiver = #{receiver} order by send_date DESC, send_time DESC;")
    List<Message> SelectMessageByReceiver(int receiver);

    @Select("select count(*) from messages where receiver = #{receiver} order by send_date DESC, send_time DESC;")
    int CountNumberOfMessageByReceiver(int receiver);

    @Select("select count(*) from messages where receiver = #{receiver} and is_read = false order by send_date DESC, send_time DESC;")
    int CountNumberOfUnreadMessageByReceiver(int receiver);

    @Select("select * from messages where receiver = #{receiver} and is_read = false order by send_date DESC, send_time DESC;")
    List<Message> SelectUnreadMessageByReceiver(int receiver);

    @Select("select * from messages where receiver = #{receiver} and send_date <= #{send_date} order by send_date DESC, send_time DESC;")
    List<Message> SelectMessageByDateAndReceiver(int receiver, LocalDate send_date);

    @Select("select * from messages where receiver = #{receiver} and send_date <= #{send_date} and is_read = false order by send_date DESC, send_time DESC;")
    List<Message> SelectUnreadMessageByDateAndReceiver(int receiver, LocalDate send_date);

    @Update("update messages set is_read = true where message_id = #{messageId};")
    void SetRead(int messageId);
}