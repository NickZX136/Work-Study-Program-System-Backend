package jmu.zx.controller;

import jmu.zx.pojo.Employer;
import jmu.zx.pojo.Result;
import jmu.zx.service.EmployerService;
import jmu.zx.utils.JwtUtil;
import jmu.zx.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employer")
public class EmployerController {
    @Autowired
    private EmployerService employerService;

    @PostMapping("/register")
    public Result register(String companyId, String companyName, String loginPassword,
                           String contactPerson, String contactPhone) {
        //查询用户
        Employer employer = employerService.findEmployerByCompanyId(companyId);
        //判断是否存在用户
        if (employer == null) {
            //注册
            employerService.register(companyId, companyName, loginPassword,
                    contactPerson, contactPhone);
            return Result.success();
        }else {
            return Result.error("1","已存在该用人单位");
        }
    }

    @PostMapping("/login")
    public Result login(String companyId, String loginPassword) {
        //判断是否存在该用户
        Employer employer = employerService.findEmployerByCompanyId(companyId);
        if (employer == null) {
            return Result.error("1","该用人单位不存在");
        }else {
            //判断审核是否通过
            if(employer.isReviewStatus()){
                //判断密码是否正确
                if(employerService.login(companyId, loginPassword)){
                    //生成token
                    Map<String, Object> claims = new HashMap<>();
                    claims.put("companyId", employer.getCompanyId());
                    claims.put("loginPassword", employer.getLoginPassword());
                    String token = JwtUtil.generateToken(claims);
                    return Result.success(token);
                }else {
                    return Result.error("1","密码错误");
                }
            }else {
                return Result.error("1","审核仍未通过");
            }

        }
    }

    //获取用户详细信息
    @GetMapping("/employerInfo")
    public Result<Employer> employerInfo(){

        Map<String,Object> map = ThreadLocalUtil.get();
        String companyId = (String) map.get("companyId");

        Employer employer = employerService.findEmployerByCompanyId(companyId);
        return Result.success(employer);
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam("companyId") String companyId) {
        employerService.deleteByEmployerId(companyId);
        return Result.success();
    }

    @GetMapping("searchAll")
    public Result<List<Employer>> searchAll(){
        List<Employer> list = employerService.searchAll();
        return Result.success(list);
    }

    @PutMapping("/update")
    public Result update(@RequestBody Employer employer) {
        employerService.update(employer);
        return Result.success(employer);
    }

    @PutMapping("/updateInfo")
    public Result updateEmployerInfo(@RequestBody Employer employer) {
        employerService.updateEmployerInfo(employer);
        return Result.success(employer);
    }

    @PatchMapping("/updatePassword")
    public Result updatePassword(@RequestBody Map<String, String> params) {
        String password = params.get("loginPassword");
        employerService.updatePassword(password);
        return Result.success();
    }

}
