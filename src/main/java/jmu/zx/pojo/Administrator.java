package jmu.zx.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Administrator {
    private String administratorId;
    private String administratorName;
    @JsonIgnore
    private String administratorPassword;
}
