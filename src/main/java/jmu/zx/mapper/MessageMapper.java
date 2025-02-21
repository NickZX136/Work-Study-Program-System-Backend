package jmu.zx.mapper;

import jmu.zx.pojo.Message;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MessageMapper {

    //添加
    @Insert("insert into message(title, content, writer) " +
            "values(#{title},#{content},#{writer})")
    void add(Message message);

    //查找全部
    @Select("select * from message")
    List<Message> searchAll();

    //通过Id删除留言
    @Delete("delete from message where message_id=#{messageId}")
    void deleteMessageByMessageId(Integer messageId);

    @Update("update message set title=#{title}, content=#{content} where message_id=#{messageId}")
    void update(Message message);

    @Select("select * from message where message_id=#{messageId}")
    Message searchByMessageId(Integer messageId);
}
