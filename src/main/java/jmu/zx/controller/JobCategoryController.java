package jmu.zx.controller;

import jmu.zx.pojo.JobCategory;
import jmu.zx.pojo.Result;
import jmu.zx.pojo.Revert;
import jmu.zx.service.JobCategoryService;
import jmu.zx.service.RevertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobCategory")
public class JobCategoryController {

    @Autowired
    JobCategoryService jobCategoryService;

    @PostMapping("/add")
    public Result add(@RequestBody JobCategory jobCategory) {
        jobCategoryService.add(jobCategory);
        return Result.success();
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam("categoryId") Integer categoryId) {
        jobCategoryService.deleteByCategoryId(categoryId);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody JobCategory jobCategory) {
        jobCategoryService.update(jobCategory);
        return Result.success();
    }

    @GetMapping("/searchAll")
    public Result<List<JobCategory>> searchAll() {
        List<JobCategory> list = jobCategoryService.searchAll();
        return Result.success(list);
    }

    @GetMapping("/searchByCategoryName")
    public Result<List<JobCategory>> searchByCategoryName(@RequestParam("categoryName") String categoryName) {
        List<JobCategory> list = jobCategoryService.searchByCategoryName(categoryName);
        return Result.success(list);
    }

}
