package jmu.zx.service.impl;

import jmu.zx.mapper.EmployerMapper;
import jmu.zx.mapper.EvaluationMapper;
import jmu.zx.pojo.Evaluation;
import jmu.zx.service.EvaluationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaluationServiceImpl implements EvaluationService {
    @Autowired
    EvaluationMapper evaluationMapper;

    @Override
    public void add(Evaluation evaluation) {
        evaluationMapper.add(evaluation);
    }

    @Override
    public void deleteByEvaluationId(Integer evaluationId) {
        evaluationMapper.deleteByEvaluationId(evaluationId);
    }

    @Override
    public void update(Evaluation evaluation) {
        evaluationMapper.update(evaluation);
    }

    @Override
    public List<Evaluation> searchAll() {
        List<Evaluation> list = evaluationMapper.searchAll();
        return list;
    }

    @Override
    public List<Evaluation> searchByCompanyId(String companyId) {
        List<Evaluation> list = evaluationMapper.searchByCompanyId(companyId);
        return list;
    }

    @Override
    public List<Evaluation> searchByStudentId(String studentId) {
        List<Evaluation> list = evaluationMapper.searchByStudentId(studentId);
        return list;
    }


}
