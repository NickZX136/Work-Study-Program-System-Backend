package jmu.zx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JobCategory {
    private String categoryId;
    private String categoryName;
    //(4) 岗位类别（岗位类别编号，类别名称）
}
