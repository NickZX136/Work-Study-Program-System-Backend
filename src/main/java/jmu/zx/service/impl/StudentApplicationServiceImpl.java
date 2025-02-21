package jmu.zx.service.impl;

import jmu.zx.mapper.StudentApplicationMapper;
import jmu.zx.pojo.Employment;
import jmu.zx.pojo.StudentApplication;
import jmu.zx.service.StudentApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentApplicationServiceImpl implements StudentApplicationService {

    @Autowired
    StudentApplicationMapper studentApplicationMapper;

    @Override
    public void add(StudentApplication studentApplication) {
        studentApplicationMapper.add(studentApplication);
    }

    @Override
    public void deleteByApplicationId(Integer applicationId) {
        studentApplicationMapper.deleteByApplicationId(applicationId);
    }

    @Override
    public void update(StudentApplication studentApplication) {
        studentApplicationMapper.update(studentApplication);
    }

    @Override
    public List<StudentApplication> searchAll() {
        List<StudentApplication> list = studentApplicationMapper.searchAll();
        return list;
    }

    @Override
    public List<StudentApplication> searchByCompanyId(String companyId) {
        List<StudentApplication> list = studentApplicationMapper.searchByCompanyId(companyId);
        return list;
    }

    @Override
    public List<StudentApplication> searchByStudentId(String studentId) {
        List<StudentApplication> list = studentApplicationMapper.searchByStudentId(studentId);
        return list;
    }
}
