package jmu.zx.mapper;

import jmu.zx.pojo.JobCategory;
import jmu.zx.pojo.Revert;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface JobCategoryMapper {

    @Insert("insert into job_category(category_name) values (#{categoryName})")
    void add(JobCategory jobCategory);

    @Delete("delete from job_category where category_id=#{categoryId}")
    void deleteByCategoryId(Integer categoryId);

    @Update("update job_category set category_name=#{categoryName} where category_id=#{categoryId}")
    void update(JobCategory jobCategory);

    @Select("select * from job_category")
    List<JobCategory> searchAll();

    @Select("select * from job_category where category_name like concat('%',#{categoryName},'%')")
    List<JobCategory> searchByCategoryName(String categoryName);
}
