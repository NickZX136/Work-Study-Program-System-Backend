package jmu.zx.service;

import jmu.zx.pojo.Administrator;

public interface AdministratorService {
    //根据管理员用户名查询管理员
    Administrator findAdministratorByAdministratorId(String administratorId);

    //注册
    void register(String administratorId, String administratorName, String administratorPassword);

    //登录
    boolean login(String administratorId, String administratorPassword);

    void updateAdministratorName(String administratorId, String administratorName);

    void updateAdministratorPassword(String password);
}
