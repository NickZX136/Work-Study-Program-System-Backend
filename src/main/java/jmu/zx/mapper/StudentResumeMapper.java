package jmu.zx.mapper;

import jmu.zx.pojo.StudentResume;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentResumeMapper {

    @Insert("insert into student_resume(student_id, publication_id, available_time, remarks, expired_status) " +
            "VALUES(#{studentId},#{publicationId},#{availableTime},#{remarks},#{expiredStatus}) ")
    void add(StudentResume studentResume);

    @Delete("delete from student_resume where resume_id=#{resumeId}")
    void deleteByResumeId(Integer resumeId);

    @Update("update student_resume set publication_id=#{publicationId}, available_time=#{availableTime}, remarks=#{remarks}, expired_status=#{expiredStatus} " +
            "where resume_id=#{resumeId}")
    void update(StudentResume studentResume);

    @Select("select * from student_resume where student_id=#{studentId}")
    List<StudentResume> searchByCompanyId(String studentId);
}
