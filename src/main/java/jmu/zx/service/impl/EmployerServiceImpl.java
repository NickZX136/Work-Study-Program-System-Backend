package jmu.zx.service.impl;

import jmu.zx.mapper.EmployerMapper;
import jmu.zx.pojo.Employer;
import jmu.zx.service.EmployerService;
import jmu.zx.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.List;
import java.util.Map;

@Service
public class EmployerServiceImpl implements EmployerService {

    @Autowired
    EmployerMapper employerMapper;

    @Override
    public Employer findEmployerByCompanyId(String companyId) {
        return employerMapper.findEmployerByCompanyId(companyId);
    }

    @Override
    public void register(String companyId, String companyName, String loginPassword,
                         String contactPerson, String contactPhone) {
        //加密
        String md5Password = DigestUtils.md5DigestAsHex(loginPassword.getBytes());
        //添加学生
        employerMapper.add(companyId, "用人单位" + companyId, md5Password, contactPerson, contactPhone);
    }

    @Override
    public boolean login(String companyId, String loginPassword) {
        //解密
        String md5Password = DigestUtils.md5DigestAsHex(loginPassword.getBytes());
        //查找对应管理员密码
        String realPassword = employerMapper.findEmployerByCompanyId(companyId).getLoginPassword();
        //判断密码并返回boolean值
        return md5Password.equals(realPassword);
    }

    @Override
    public void deleteByEmployerId(String employerId) {
        employerMapper.delete(employerId);
    }

    @Override
    public List<Employer> searchAll() {
        List<Employer> list = employerMapper.searchAll();
        return list;
    }

    @Override
    public void update(Employer employer) {
        employerMapper.update(employer);
    }

    @Override
    public void updateEmployerInfo(Employer employer) {
        employerMapper.updateEmployerInfo(employer);
    }

    @Override
    public void updatePassword(String password) {
        Map<String,Object> map = ThreadLocalUtil.get();
        String companyId = (String) map.get("companyId");

        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        employerMapper.updatePassword(companyId, md5Password);
    }

}
