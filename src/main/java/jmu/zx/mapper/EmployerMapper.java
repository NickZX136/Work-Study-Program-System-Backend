package jmu.zx.mapper;

import jmu.zx.pojo.Employer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployerMapper {
    //根据管理员ID查询管理员
    @Select("select * from employer where employer.company_id=#{companyId}")
    Employer findEmployerByCompanyId(String companyId);

    //添加
    @Insert("insert into employer(company_id, company_name, login_password, contact_person, contact_phone) " +
            "values(#{companyId},#{companyName},#{loginPassword},#{contactPerson},#{contactPhone})")
    void add(String companyId, String companyName, String loginPassword,
             String contactPerson, String contactPhone);

    @Delete("delete from employer where company_id=#{companyId}")
    void delete(String employerId);

    @Select("select * from employer")
    List<Employer> searchAll();

    @Update("update employer set company_name=#{companyName},contact_person=#{contactPerson},address=#{address}," +
            "company_nature=#{companyNature},email=#{email},scale=#{scale},administrator_id=#{administratorId}," +
            "contact_phone=#{contactPhone},review_status=#{reviewStatus},review_time=#{reviewTime} where company_id=#{companyId}")
    void update(Employer employer);

    @Update("update employer set company_name=#{companyName},contact_person=#{contactPerson},address=#{address}," +
            "company_nature=#{companyNature},email=#{email},scale=#{scale},contact_phone=#{contactPhone} where company_id=#{companyId}")
    void updateEmployerInfo(Employer employer);

    @Update("update employer set login_password=#{password} where company_id=#{companyId}")
    void updatePassword(String companyId, String password);
}
