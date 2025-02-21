package jmu.zx.controller;

import jmu.zx.pojo.JobCategory;
import jmu.zx.pojo.JobPosting;
import jmu.zx.pojo.Result;
import jmu.zx.service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/jobPosting")
public class JobPostingController {

    @Autowired
    private JobPostingService jobPostingService;

    @PostMapping("/add")
    public Result add(@RequestBody JobPosting jobPosting) {
        jobPostingService.add(jobPosting);
        return Result.success();
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam("postingId") Integer postingId) {
        jobPostingService.deleteByPostingId(postingId);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody JobPosting jobPosting) {
        jobPostingService.update(jobPosting);
        return Result.success();
    }

    @GetMapping("/searchAll")
    public Result<List<JobPosting>> searchAll() {
        List<JobPosting> list = jobPostingService.searchAll();
        return Result.success(list);
    }

    @GetMapping("/searchByCompanyId")
    public Result<List<JobPosting>> searchByCompanyId(@RequestParam("companyId") String companyId) {
        List<JobPosting> list = jobPostingService.searchByCompanyId(companyId);
        return Result.success(list);
    }

    @GetMapping("/searchByCategoryName")
    public Result<List<JobPosting>> searchByCategoryName(@RequestParam("categoryName") String categoryName) {
        List<JobPosting> list = jobPostingService.searchByCategoryName(categoryName);
        return Result.success(list);
    }

}
