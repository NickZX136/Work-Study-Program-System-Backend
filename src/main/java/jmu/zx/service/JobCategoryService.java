package jmu.zx.service;

import jmu.zx.pojo.JobCategory;
import jmu.zx.pojo.Revert;

import java.util.List;

public interface JobCategoryService {

    void add(JobCategory jobCategory);

    void deleteByCategoryId(Integer categoryId);

    void update(JobCategory jobCategory);

    List<JobCategory> searchAll();

    List<JobCategory> searchByCategoryName(String categoryName);
}
