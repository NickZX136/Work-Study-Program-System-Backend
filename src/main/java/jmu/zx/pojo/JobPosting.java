package jmu.zx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
public class JobPosting {
    private Integer postingId;
    private String jobTitle;
    private Integer categoryId;
    private Integer publicationId;
    private LocalDateTime publicationDate;
    private Integer clickCount;
    private String companyId;
    private String detailedRequirements;
    private String salaryInfo;
    private boolean filledStatus;
    private boolean expiredStatus;

    //(5) 用人单位招聘信息（招聘编号，岗位名称，岗位类别编号，发布编号，发布时间，点击量，用人单位编号，详细要求，薪酬信息，招满状态，过期状态）
}
