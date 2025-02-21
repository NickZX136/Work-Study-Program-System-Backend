package jmu.zx.controller;


import jmu.zx.pojo.Result;
import jmu.zx.pojo.StudentApplication;
import jmu.zx.service.StudentApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stuApp")
public class StudentApplicationController {

    @Autowired
    StudentApplicationService studentApplicationService;

    @PostMapping("/add")
    public Result add(@RequestBody StudentApplication studentApplication) {
        studentApplicationService.add(studentApplication);
        return Result.success();
    }

    @DeleteMapping("/delete")
    public Result deleteByApplicationId(@RequestParam("applicationId") Integer applicationId) {
        studentApplicationService.deleteByApplicationId(applicationId);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody StudentApplication studentApplication) {
        studentApplicationService.update(studentApplication);
        return Result.success();
    }

    @GetMapping("/searchAll")
    public Result<List<StudentApplication>> searchAll() {
        List<StudentApplication> list = studentApplicationService.searchAll();
        return Result.success(list);
    }

    @GetMapping("/searchByCompanyId")
    public Result<List<StudentApplication>> searchByCompanyId(@RequestParam("companyId") String companyId) {
        List<StudentApplication> list = studentApplicationService.searchByCompanyId(companyId);
        return Result.success(list);
    }

    @GetMapping("/searchByStudentId")
    public Result<List<StudentApplication>> searchByStudentId(@RequestParam("studentId") String studentId) {
        List<StudentApplication> list = studentApplicationService.searchByStudentId(studentId);
        return Result.success(list);
    }

}
