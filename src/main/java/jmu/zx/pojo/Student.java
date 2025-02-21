package jmu.zx.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Student {
    private String studentId;
    private String studentName;
    @JsonIgnore
    private String studentPassword;
    private String sex;
    private String nation;
    private String nativePlace;
    private String birthDate;
    private String politicalStatus;
}
