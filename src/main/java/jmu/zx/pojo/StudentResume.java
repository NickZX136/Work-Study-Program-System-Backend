package jmu.zx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.DateFormat;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class StudentResume {
    private Integer resumeId;
    private String studentId;
    private Integer publicationId;
    private String availableTime;
    private LocalDateTime uploadTime;
    private String remarks;
    private boolean expiredStatus;
    //(6)学生求职简历（简历编号，学号，求职岗位，空闲时间，上传时间，备注，过期状态）
}
