package jmu.zx.mapper;

import jmu.zx.pojo.Employment;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmploymentMapper {

    @Insert("insert into employment(company_id, student_id, start_date, salary_info, is_terminated) " +
            "values(#{companyId},#{studentId},#{startDate},#{salaryInfo},#{isTerminated}) ")
    void add(Employment employment);

    @Delete("delete from employment where employment_id=#{employmentId}")
    void deleteByEmploymentId(String employmentId);

    @Update("update employment set company_id=#{companyId},student_id=#{studentId},start_date=#{startDate},salary_info=#{salaryInfo},is_terminated=#{isTerminated} " +
            "where employment_id=#{employmentId}")
    void update(Employment employment);

    @Select("select * from employment")
    List<Employment> searchAll();

    @Select("select * from employment where company_id=#{companyId}")
    List<Employment> searchByCompanyId(String companyId);

    @Select("select * from employment where student_id=#{studentId}")
    List<Employment> searchByStudentId(String studentId);
}
