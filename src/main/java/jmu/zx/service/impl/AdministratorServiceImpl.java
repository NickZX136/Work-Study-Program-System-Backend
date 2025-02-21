package jmu.zx.service.impl;

import jmu.zx.mapper.AdministratorMapper;
import jmu.zx.pojo.Administrator;
import jmu.zx.service.AdministratorService;
import jmu.zx.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Map;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    AdministratorMapper administratorMapper;

    @Override
    public Administrator findAdministratorByAdministratorId(String administratorId) {
        return administratorMapper.findAdministratorByAdministratorId(administratorId);
    }

    @Override
    public void register(String administratorId, String administratorName, String administratorPassword) {
        //加密
        String md5Password = DigestUtils.md5DigestAsHex(administratorPassword.getBytes());
        //添加管理员
        administratorMapper.add(administratorId, "管理员" + administratorId, md5Password);
    }

    @Override
    public boolean login(String administratorId, String administratorPassword) {
        //解密
        String md5Password = DigestUtils.md5DigestAsHex(administratorPassword.getBytes());
        //查找对应管理员密码
        String realPassword = administratorMapper.findAdministratorByAdministratorId(administratorId).getAdministratorPassword();
        //判断密码并返回boolean值
        return md5Password.equals(realPassword);

    }

    @Override
    public void updateAdministratorName(String administratorId, String administratorName) {
        Administrator administrator = administratorMapper.findAdministratorByAdministratorId(administratorId);
        administrator.setAdministratorName(administratorName);
        administrator.setAdministratorPassword(administrator.getAdministratorPassword());
        System.out.println(administrator);
        administratorMapper.update(administrator);
    }

    @Override
    public void updateAdministratorPassword(String password) {
        Map<String,Object> map = ThreadLocalUtil.get();
        String administratorId = (String) map.get("administratorId");

        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        administratorMapper.updatePassword(administratorId, md5Password);
    }
}
