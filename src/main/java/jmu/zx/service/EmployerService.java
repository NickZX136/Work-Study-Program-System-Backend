package jmu.zx.service;

import jmu.zx.pojo.Employer;

import java.util.List;

public interface EmployerService {
    //根据学生用户名查询学生
    Employer findEmployerByCompanyId(String companyId);

    //注册
    void register(String companyId, String companyName, String loginPassword,
                  String contactPerson, String contactPhone);

    //登录
    boolean login(String companyId, String loginPassword);

    void deleteByEmployerId(String employerId);

    List<Employer> searchAll();

    void update(Employer employer);

    void updateEmployerInfo(Employer employer);

    void updatePassword(String password);
}
