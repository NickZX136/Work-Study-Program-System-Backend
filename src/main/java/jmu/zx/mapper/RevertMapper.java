package jmu.zx.mapper;

import jmu.zx.pojo.Revert;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RevertMapper {

    @Insert("insert into revert(message_id, content, writer) values(#{messageId},#{content},#{writer}) ")
    void add(Revert revert);

    @Delete("delete from revert where revert_id=#{revertId}")
    void deleteByRevertId(Integer revertId);

    @Update("update revert set content=#{content} where revert_id=#{revertId}")
    void updateRevert(Revert revert);

    @Select("select * from revert where message_id=#{messageId}")
    List<Revert> searchByMessageId(Integer messageId);
}
