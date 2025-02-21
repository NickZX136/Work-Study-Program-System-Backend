package jmu.zx.service;

import jmu.zx.pojo.Student;

import java.util.List;

public interface StudentService {
    //根据学生用户名查询学生
    Student findStudentByStudentId(String studentId);

    //注册
    void register(String studentId, String studentName, String studentPassword);

    //登录
    boolean login(String studentId, String studentPassword);

    void deleteByStudentId(String studentId);

    List<Student> searchAll();

    void update(Student student);

    void updateStudentPassword(String password);
}
