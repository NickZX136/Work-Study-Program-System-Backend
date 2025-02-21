package jmu.zx.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Employer {
    private String companyId;
    private String companyName;//
    @JsonIgnore
    private String loginPassword;
    private String contactPerson;//
    private String address;//
    private String registrationTime;
    private String companyNature;//
    private String email;//
    private String scale;//
    private String administratorId;//
    private String contactPhone;//
    private boolean reviewStatus;//
    private LocalDateTime reviewTime;//

    //(3)用人单位（企业编号，企业名称，登录密码，联系人，地址，注册时间，性质，电子邮箱，规模，审核员编号，联系电话，审核状态，审核时间


}