package jmu.zx.service.impl;

import jmu.zx.mapper.JobCategoryMapper;
import jmu.zx.mapper.RevertMapper;
import jmu.zx.pojo.JobCategory;
import jmu.zx.pojo.Revert;
import jmu.zx.service.JobCategoryService;
import jmu.zx.service.RevertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobCategoryServiceImpl implements JobCategoryService {

    @Autowired
    JobCategoryMapper jobCategoryMapper;

    @Override
    public void add(JobCategory jobCategory) {
        jobCategoryMapper.add(jobCategory);
    }

    @Override
    public void deleteByCategoryId(Integer categoryId) {
        jobCategoryMapper.deleteByCategoryId(categoryId);
    }

    @Override
    public void update(JobCategory jobCategory) {
        jobCategoryMapper.update(jobCategory);
    }

    @Override
    public List<JobCategory> searchAll() {
        List<JobCategory> list = jobCategoryMapper.searchAll();
        return list;
    }

    @Override
    public List<JobCategory> searchByCategoryName(String categoryName) {
        List<JobCategory> list = jobCategoryMapper.searchByCategoryName(categoryName);
        return list;
    }
}
