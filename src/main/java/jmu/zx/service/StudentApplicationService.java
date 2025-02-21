package jmu.zx.service;

import jmu.zx.pojo.Employment;
import jmu.zx.pojo.StudentApplication;

import java.util.List;

public interface StudentApplicationService {
    void add(StudentApplication studentApplication);

    void deleteByApplicationId(Integer applicationId);

    void update(StudentApplication studentApplication);

    List<StudentApplication> searchAll();

    List<StudentApplication> searchByCompanyId(String companyId);

    List<StudentApplication> searchByStudentId(String studentId);
}
