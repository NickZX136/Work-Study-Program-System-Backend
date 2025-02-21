package jmu.zx.mapper;

import jmu.zx.pojo.StudentApplication;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentApplicationMapper {

//    @Insert("insert into student_application(student_id, posting_id, application_time, feedback_result, expired_status) " +
//            "VALUES (#{studentId},#{postingId},#{applicationTime},#{feedbackResult},#{expiredStatus})")
//    void add(StudentApplication studentApplication);

    @Insert("SELECT sa.application_id, sa.student_id, sa.posting_id, sa.application_time, sa.feedback_result, sa.feedback_time, sa.expired_status\n" +
            "FROM student_application sa\n" +
            "JOIN job_posting jp ON sa.posting_id = jp.posting_id\n" +
            "WHERE jp.company_id = 'company1';\n")
    void add(StudentApplication studentApplication);

    @Delete("delete from student_application where application_id=#{applicationId}")
    void deleteByApplicationId(Integer applicationId);

    @Update("update student_application set student_id=#{studentId},posting_id=#{postingId},application_time=#{applicationTime},feedback_result=#{feedbackResult},feedback_time=#{feedbackTime},expired_status=#{expiredStatus} " +
            "where application_id=#{applicationId}")
    void update(StudentApplication studentApplication);

    @Select("select * from student_application")
    List<StudentApplication> searchAll();

    @Select("select sa.* from student_application sa join job_posting jp on sa.posting_id=jp.posting_id where jp.company_id=#{companyId}")
    List<StudentApplication> searchByCompanyId(String companyId);

    @Select("select * from student_application where student_id=#{studentId}")
    List<StudentApplication> searchByStudentId(String studentId);
}
