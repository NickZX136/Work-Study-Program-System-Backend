package jmu.zx.controller;

import jmu.zx.pojo.Result;
import jmu.zx.pojo.Revert;
import jmu.zx.service.RevertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/revert")
public class RevertController {

    @Autowired
    RevertService revertService;

    @PostMapping("/add")
    public Result add(@RequestBody Revert revert) {
        revertService.add(revert);
        return Result.success();
    }

    @DeleteMapping("/delete")
    public Result delete(@RequestParam("revertId") Integer revertId) {
        revertService.deleteByRevertId(revertId);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Revert revert) {
        revertService.update(revert);
        return Result.success();
    }

    @GetMapping("/searchByMessageId")
    public Result<List<Revert>> searchByMessageId(@RequestParam("messageId") Integer messageId) {
        List<Revert> list = revertService.searchByMessageId(messageId);
        return Result.success(list);
    }

}
