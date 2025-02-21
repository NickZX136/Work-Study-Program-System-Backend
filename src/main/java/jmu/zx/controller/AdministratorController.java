package jmu.zx.controller;

import jmu.zx.pojo.Administrator;
import jmu.zx.pojo.Result;
import jmu.zx.service.AdministratorService;
import jmu.zx.utils.JwtUtil;
import jmu.zx.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @PostMapping("/register")
    public Result register(String administratorId, String administratorName, String administratorPassword) {
        //查询用户
        Administrator administrator = administratorService.findAdministratorByAdministratorId(administratorId);
        //判断是否存在用户
        if (administrator == null) {
            //注册
            administratorService.register(administratorId, administratorName, administratorPassword);
            return Result.success();
        }else {
            return Result.error("1","用户名已被占用");
        }
    }

    @PostMapping("/login")
    public Result login(String administratorId, String administratorPassword) {
        //判断是否存在该用户
        Administrator administrator = administratorService.findAdministratorByAdministratorId(administratorId);
        if (administrator == null) {
            return Result.error("1","用户不存在");
        }else {
            //判断密码是否正确
            if(administratorService.login(administratorId, administratorPassword)){
                //生成token
                Map<String, Object> claims = new HashMap<>();
                claims.put("administratorId", administrator.getAdministratorId());
                claims.put("administratorName", administrator.getAdministratorName());
                String token = JwtUtil.generateToken(claims);
                return Result.success(token);
            }else {
                return Result.error("1","密码错误");
            }
        }
    }

    //获取用户详细信息
    @GetMapping("/adminInfo")
    public Result<Administrator> adminInfo(){

        Map<String,Object> map = ThreadLocalUtil.get();
        String administratorId = (String) map.get("administratorId");

        Administrator administrator = administratorService.findAdministratorByAdministratorId(administratorId);
        return Result.success(administrator);
    }

    @PutMapping("/updateName")
    public Result updateAdministratorName(@RequestBody Administrator administrator) {

        String administratorId = administrator.getAdministratorId();
        String administratorName = administrator.getAdministratorName();

        administratorService.updateAdministratorName(administratorId, administratorName);

        return Result.success();
    }

    @PatchMapping("/updatePassword")
    public Result updatePassword(@RequestBody Map<String, String> params) {
        String password = params.get("administratorPassword");
        administratorService.updateAdministratorPassword(password);
        return Result.success();
    }

}
