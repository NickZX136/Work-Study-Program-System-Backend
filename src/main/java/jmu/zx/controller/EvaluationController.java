package jmu.zx.controller;


import jmu.zx.pojo.Evaluation;
import jmu.zx.pojo.Result;
import jmu.zx.pojo.Revert;
import jmu.zx.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluation")
public class EvaluationController {
    @Autowired
    private EvaluationService evaluationService;

    @PostMapping("/add")
    public Result add(@RequestBody Evaluation evaluation) {
        evaluationService.add(evaluation);
        System.out.println(evaluation);
        return Result.success();
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam("evaluationId") Integer evaluationId) {
        evaluationService.deleteByEvaluationId(evaluationId);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Evaluation evaluation) {
        evaluationService.update(evaluation);
        return Result.success();
    }

    @GetMapping("/searchAll")
    public Result<List<Evaluation>> searchAll() {
        List<Evaluation> list = evaluationService.searchAll();
        return Result.success(list);
    }

    @GetMapping("/searchByCompanyId")
    public Result<List<Evaluation>> searchByCompanyId(@RequestParam("companyId") String companyId) {
        List<Evaluation> list = evaluationService.searchByCompanyId(companyId);
        return Result.success(list);
    }

    @GetMapping("/searchByStudentId")
    public Result<List<Evaluation>> searchByStudentId(@RequestParam("studentId") String studentId) {
        List<Evaluation> list = evaluationService.searchByStudentId(studentId);
        return Result.success(list);
    }

}
