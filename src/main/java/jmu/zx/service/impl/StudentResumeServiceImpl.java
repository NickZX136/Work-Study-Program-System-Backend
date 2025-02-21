package jmu.zx.service.impl;


import jmu.zx.mapper.StudentResumeMapper;
import jmu.zx.pojo.StudentApplication;
import jmu.zx.pojo.StudentResume;
import jmu.zx.service.StudentResumeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentResumeServiceImpl implements StudentResumeService {

    @Autowired
    StudentResumeMapper studentResumeMapper;

    @Override
    public void add(StudentResume studentResume) {
        studentResumeMapper.add(studentResume);
    }

    @Override
    public void deleteByResumeId(Integer resumeId) {
        studentResumeMapper.deleteByResumeId(resumeId);

    }

    @Override
    public void update(StudentResume studentResume) {
        studentResumeMapper.update(studentResume);
    }

    @Override
    public List<StudentResume> searchByStudentId(String studentId) {
        List<StudentResume> list = studentResumeMapper.searchByCompanyId(studentId);
        return list;
    }
}
