package jmu.zx.mapper;

import jmu.zx.pojo.Administrator;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdministratorMapper {
    //根据管理员ID查询管理员
    @Select("select * from administrator where administrator_id=#{administratorId}")
    Administrator findAdministratorByAdministratorId(String administratorId);

    //添加
    @Insert("insert into administrator(administrator_id,administrator_name,administrator_password) values(#{administratorId},#{administratorName},#{administratorPassword})")
    void add(String administratorId, String administratorName, String administratorPassword);

    @Update("update administrator set administrator_name=#{administratorName}, administrator_password=#{administratorPassword} where administrator_id=#{administratorId}")
    void update(Administrator administrator);

    @Update("update administrator set administrator_password=#{password} where administrator_id=#{administratorId}")
    void updatePassword(String administratorId, String password);
}
