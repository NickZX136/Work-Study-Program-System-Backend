package jmu.zx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class StudentApplication {
    private Integer applicationId;
    private String studentId;
    private String postingId;
    private String applicationTime;
    private String feedbackResult;
    private String feedbackTime;
    private boolean expiredStatus;
    //(7)学生应聘信息（应聘编号，学号，招聘编号，应聘时间，反馈结果，反馈时间，过期状态）
}
