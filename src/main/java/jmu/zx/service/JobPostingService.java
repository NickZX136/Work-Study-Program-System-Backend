package jmu.zx.service;

import jmu.zx.pojo.JobPosting;

import java.util.List;

public interface JobPostingService {
    void add(JobPosting jobPosting);

    void deleteByPostingId(Integer postingId);

    void update(JobPosting jobPosting);

    List<JobPosting> searchAll();

    List<JobPosting> searchByCompanyId(String companyId);

    List<JobPosting> searchByCategoryName(String categoryName);
}
