package jmu.zx.service.impl;

import jmu.zx.mapper.StudentMapper;
import jmu.zx.pojo.Student;
import jmu.zx.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements jmu.zx.service.StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student findStudentByStudentId(String studentId) {
        return studentMapper.findStudentByStudentId(studentId);
    }

    @Override
    public void register(String studentId, String studentName, String studentPassword) {
        //加密
        String md5Password = DigestUtils.md5DigestAsHex(studentPassword.getBytes());
        //添加学生
        studentMapper.add(studentId, "学生" + studentId, md5Password);
    }

    @Override
    public boolean login(String studentId, String studentPassword) {
        //解密
        String md5Password = DigestUtils.md5DigestAsHex(studentPassword.getBytes());
        //查找对应管理员密码
        String realPassword = studentMapper.findStudentByStudentId(studentId).getStudentPassword();
        //判断密码并返回boolean值
        return md5Password.equals(realPassword);

    }

    @Override
    public void deleteByStudentId(String studentId) {
        studentMapper.deleteByStudentId(studentId);
    }

    @Override
    public List<Student> searchAll() {
        List<Student> list = studentMapper.searchAll();
        return list;
    }

    @Override
    public void update(Student student) {
        studentMapper.update(student);
    }

    @Override
    public void updateStudentPassword(String password) {
        Map<String,Object> map = ThreadLocalUtil.get();
        String studentId = (String) map.get("studentId");

        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        studentMapper.updatePassword(studentId, md5Password);
    }
}
