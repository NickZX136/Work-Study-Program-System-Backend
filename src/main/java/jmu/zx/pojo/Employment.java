package jmu.zx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Employment {
    private String employmentId;
    private String companyId;
    private String studentId;
    private String startDate;
    private String salaryInfo;
    private boolean isTerminated;
    //(8) 用工表（用工ID，用人单位ID，学号，用工开始时间，薪酬信息，是否结束标记）
}
