package jmu.zx.service.impl;


import jmu.zx.mapper.EmploymentMapper;
import jmu.zx.pojo.Employment;
import jmu.zx.pojo.JobPosting;
import jmu.zx.pojo.Result;
import jmu.zx.service.EmploymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmploymentServiceImpl implements EmploymentService {
    @Autowired
    EmploymentMapper employmentMapper;

    @Override
    public void add(Employment employment) {
        employmentMapper.add(employment);
    }

    @Override
    public void deleteByEmploymentId(String employmentId) {
        employmentMapper.deleteByEmploymentId(employmentId);
    }

    @Override
    public void update(Employment employment) {
        employmentMapper.update(employment);
    }

    @Override
    public List<Employment> searchAll() {
        List<Employment> list = employmentMapper.searchAll();
        return list;
    }

    @Override
    public List<Employment> searchByCompanyId(String companyId) {
        List<Employment> list = employmentMapper.searchByCompanyId(companyId);
        return list;
    }

    @Override
    public List<Employment> searchByStudentId(String studentId) {
        List<Employment> list = employmentMapper.searchByStudentId(studentId);
        return list;
    }


}
