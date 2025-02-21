package jmu.zx.service.impl;

import jmu.zx.mapper.JobPostingMapper;
import jmu.zx.pojo.JobCategory;
import jmu.zx.pojo.JobPosting;
import jmu.zx.service.JobPostingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingServiceImpl implements JobPostingService {
    @Autowired
    JobPostingMapper jobPostingMapper;

    @Override
    public void add(JobPosting jobPosting) {
        jobPostingMapper.add(jobPosting);
    }

    @Override
    public void deleteByPostingId(Integer postingId) {
        jobPostingMapper.deleteByPostingId(postingId);
    }

    @Override
    public void update(JobPosting jobPosting) {
        jobPostingMapper.update(jobPosting);
    }

    @Override
    public List<JobPosting> searchAll() {
        List<JobPosting> list = jobPostingMapper.searchAll();
        return list;
    }

    @Override
    public List<JobPosting> searchByCompanyId(String companyId) {
        List<JobPosting> list = jobPostingMapper.searchByCompanyId(companyId);
        return list;
    }

    @Override
    public List<JobPosting> searchByCategoryName(String categoryName) {
        List<JobPosting> list = jobPostingMapper.searchByCategoryName(categoryName);
        return list;
    }
}
