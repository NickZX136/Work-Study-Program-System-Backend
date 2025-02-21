package jmu.zx.service;

import jmu.zx.pojo.Evaluation;

import java.util.List;

public interface EvaluationService {
    void add(Evaluation evaluation);

    void deleteByEvaluationId(Integer evaluationId);

    void update(Evaluation evaluation);

    List<Evaluation> searchAll();

    List<Evaluation> searchByCompanyId(String companyId);

    List<Evaluation> searchByStudentId(String studentId);
}
