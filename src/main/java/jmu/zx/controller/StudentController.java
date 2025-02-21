package jmu.zx.controller;

import jmu.zx.pojo.Result;
import jmu.zx.pojo.Revert;
import jmu.zx.pojo.Student;
import jmu.zx.service.StudentService;
import jmu.zx.utils.JwtUtil;
import jmu.zx.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stu")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public Result register(String studentId, String studentName, String studentPassword) {
        //查询用户
        Student student = studentService.findStudentByStudentId(studentId);
        //判断是否存在用户
        if (student == null) {
            //注册
            studentService.register(studentId, studentName, studentPassword);
            return Result.success();
        }else {
            return Result.error("1","用户名已被占用");
        }
    }

    @PostMapping("/login")
    public Result login(String studentId, String studentPassword) {
        //判断是否存在该用户
        Student student = studentService.findStudentByStudentId(studentId);
        if (student == null) {
            return Result.error("1","用户不存在");
        }else {
            //判断密码是否正确
            if(studentService.login(studentId, studentPassword)){
                //生成token
                Map<String, Object> claims = new HashMap<>();
                claims.put("studentId", student.getStudentId());
                claims.put("studentName", student.getStudentName());
                String token = JwtUtil.generateToken(claims);
                return Result.success(token);
            }else {
                return Result.error("1","密码错误");
            }
        }
    }

    //获取用户详细信息
    @GetMapping("/stuInfo")
    public Result<Student> stuInfo(){

        Map<String,Object> map = ThreadLocalUtil.get();
        String studentId = (String) map.get("studentId");

        Student student = studentService.findStudentByStudentId(studentId);
        return Result.success(student);
    }

    //删除学生信息
    @DeleteMapping("/delete")
    public Result delete(@RequestParam("studentId") String studentId) {
        studentService.deleteByStudentId(studentId);
        return Result.success();
    }

    //获取所有学生信息
    @GetMapping("searchAll")
    public Result<List<Student>> searchAll(){
        List<Student> list = studentService.searchAll();
        return Result.success(list);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Student student) {
        studentService.update(student);
        return Result.success(student);
    }

    @PatchMapping("/updatePassword")
    public Result updatePassword(@RequestBody Map<String, String> params) {
        String password = params.get("studentPassword");
        studentService.updateStudentPassword(password);
        return Result.success();
    }

}
