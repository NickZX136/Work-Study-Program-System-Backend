package jmu.zx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Message {
    private Integer messageId;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime writeDate;
}
