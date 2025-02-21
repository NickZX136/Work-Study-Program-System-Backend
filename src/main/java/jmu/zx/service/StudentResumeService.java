package jmu.zx.service;

import jmu.zx.pojo.StudentResume;

import java.util.List;

public interface StudentResumeService {
    void add(StudentResume studentResume);

    void deleteByResumeId(Integer resumeId);

    void update(StudentResume studentResume);

    List<StudentResume> searchByStudentId(String studentId);
}
