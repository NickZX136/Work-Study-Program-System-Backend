package jmu.zx.service;

import jmu.zx.pojo.Employment;

import java.util.List;

public interface EmploymentService {

    void add(Employment employment);

    void deleteByEmploymentId(String employmentId);

    void update(Employment employment);

    List<Employment> searchAll();

    List<Employment> searchByCompanyId(String companyId);

    List<Employment> searchByStudentId(String studentId);
}
