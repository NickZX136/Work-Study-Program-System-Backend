package jmu.zx.mapper;


import jmu.zx.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    //根据学生ID查询学生
    @Select("select * from student where student.student_id=#{studentId}")
    Student findStudentByStudentId(String studentId);

    //添加
    @Insert("insert into student(student_id,student_name,student_password) values(#{studentId},#{studentName},#{studentPassword})")
    void add(String studentId, String studentName, String studentPassword);

    @Delete("delete from student where student_id=#{studentId}")
    void deleteByStudentId(String studentId);

    @Select("select * from student")
    List<Student> searchAll();

    @Update("update student set student_name=#{studentName}, sex=#{sex}, nation=#{nation}, native_place=#{nativePlace}, birth_date=#{birthDate}, political_status=#{politicalStatus} where student_id=#{studentId}")
    void update(Student student);

    @Update("update student set student_password=#{password} where student_id=#{studentId}")
    void updatePassword(String studentId, String password);
}

