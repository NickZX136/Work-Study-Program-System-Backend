package jmu.zx.mapper;

import jmu.zx.pojo.Evaluation;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EvaluationMapper {
    @Insert("insert into evaluation(student_id, company_id, stu_score, company_score, content) values (#{studentId},#{companyId},#{stuScore},#{companyScore},#{content})")
    void add(Evaluation evaluation);

    @Delete("delete from evaluation where evaluation_id=#{evaluationId}")
    void deleteByEvaluationId(Integer evaluationId);

    @Update("update evaluation set stu_score=#{stuScore}, company_score=#{companyScore}, content=#{content} where evaluation_id=#{evaluationId}")
    void update(Evaluation evaluation);

    @Select("select * from evaluation")
    List<Evaluation> searchAll();

    @Select("select * from evaluation where company_id=#{companyId}")
    List<Evaluation> searchByCompanyId(String companyId);

    @Select("select * from evaluation where student_id=#{studentId}")
    List<Evaluation> searchByStudentId(String studentId);
}
