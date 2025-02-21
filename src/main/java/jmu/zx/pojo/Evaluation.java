package jmu.zx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Evaluation {
    private Integer evaluationId;
    private String studentId;
    private String companyId;
    private String companyScore;
    private String stuScore;
    private String content;
    //(11)评价信息（评价编号，评价方ID、被评价方ID、评价分数、评价内容）
}
