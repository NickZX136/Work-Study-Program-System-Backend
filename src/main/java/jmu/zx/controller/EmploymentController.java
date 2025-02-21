package jmu.zx.controller;


import jmu.zx.pojo.Employment;
import jmu.zx.pojo.JobPosting;
import jmu.zx.pojo.Result;
import jmu.zx.service.EmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employment")
public class EmploymentController {
    @Autowired
    private EmploymentService employmentService;

    @PostMapping("/add")
    public Result add(@RequestBody Employment employment) {
        employmentService.add(employment);
        return Result.success();
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam("employmentId") String employmentId) {
        employmentService.deleteByEmploymentId(employmentId);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Employment employment) {
        employmentService.update(employment);
        return Result.success();
    }

    @GetMapping("/searchAll")
    public Result<List<Employment>> searchAll() {
        List<Employment> list = employmentService.searchAll();
        return Result.success(list);
    }

    @GetMapping("/searchByCompanyId")
    public Result<List<Employment>> searchByCompanyId(@RequestParam("companyId") String companyId) {
        List<Employment> list = employmentService.searchByCompanyId(companyId);
        return Result.success(list);
    }

    @GetMapping("/searchByStudentId")
    public Result<List<Employment>> searchByStudentId(@RequestParam("studentId") String studentId) {
        List<Employment> list = employmentService.searchByStudentId(studentId);
        return Result.success(list);
    }

}
