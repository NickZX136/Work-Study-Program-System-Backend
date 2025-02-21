package jmu.zx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.DateFormat;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Revert {
    private Integer revertId;
    private String messageId;
    private String content;
    private String writer;
    private LocalDateTime writeDate;
}
