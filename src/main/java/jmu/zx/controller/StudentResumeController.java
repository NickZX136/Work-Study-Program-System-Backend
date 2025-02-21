package jmu.zx.controller;


import jmu.zx.pojo.Result;
import jmu.zx.pojo.StudentApplication;
import jmu.zx.pojo.StudentResume;
import jmu.zx.service.StudentResumeService;
import jmu.zx.service.impl.StudentResumeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("stuRes")
public class StudentResumeController {

    @Autowired
    StudentResumeService studentResumeService;

    @PostMapping("/add")
    public Result add(@RequestBody StudentResume studentResume) {
        studentResumeService.add(studentResume);
        return Result.success();
    }

    @DeleteMapping("/delete")
    public Result deleteByResumeId(@RequestParam("resumeId") Integer resumeId) {
        studentResumeService.deleteByResumeId(resumeId);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody StudentResume studentResume) {
        studentResumeService.update(studentResume);
        return Result.success();
    }

    @GetMapping("/searchByStudentId")
    public Result<List<StudentResume>> searchByStudentId(@RequestParam("studentId") String studentId) {
        List<StudentResume> list = studentResumeService.searchByStudentId(studentId);
        return Result.success(list);
    }

}
