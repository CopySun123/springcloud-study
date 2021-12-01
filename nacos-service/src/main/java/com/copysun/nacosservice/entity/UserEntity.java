package com.copysun.nacosservice.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author CopySun
 * @date 2020/12/4 17:16
 * @Description
 */
@Data
@TableName(value = "`user`")
@NoArgsConstructor
public class UserEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -3218090418254758863L;

    @TableField(value = "name")
    private String name;

    /**
     * 年龄
     */
    @TableField(value = "age")
    private Integer age;

}