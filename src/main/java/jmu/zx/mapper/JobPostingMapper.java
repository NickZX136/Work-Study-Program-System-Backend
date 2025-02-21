package jmu.zx.mapper;

import jmu.zx.pojo.JobPosting;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface JobPostingMapper {
    @Insert("insert into job_posting(job_title, category_id, publication_id, click_count, company_id,detailed_requirements, salary_info, filled_status, expired_status) values " +
            "(#{jobTitle},#{categoryId},#{publicationId},#{clickCount},#{companyId},#{detailedRequirements},#{salaryInfo},#{filledStatus},#{expiredStatus})")
    void add(JobPosting jobPosting);

    @Delete("delete from job_posting where posting_id=#{postingId}")
    void deleteByPostingId(Integer postingId);

    @Update("update job_posting set job_title=#{jobTitle},category_id=#{categoryId},publication_id=#{publicationId},click_count=#{clickCount},company_id=#{companyId},detailed_requirements=#{detailedRequirements},salary_info=#{salaryInfo},filled_status=#{filledStatus},expired_status=#{expiredStatus} " +
            "where posting_id=#{postingId}")
    void update(JobPosting jobPosting);

    @Select("select * from job_posting")
    List<JobPosting> searchAll();

    @Select("select * from job_posting where company_id=#{companyId}")
    List<JobPosting> searchByCompanyId(String companyId);

    @Select("select jp.* from job_posting jp left join job_category jc on jc.category_id=jp.category_id " +
            "where jc.category_name like concat('%',#{categoryName},'%')")
    List<JobPosting> searchByCategoryName(String categoryName);
}
