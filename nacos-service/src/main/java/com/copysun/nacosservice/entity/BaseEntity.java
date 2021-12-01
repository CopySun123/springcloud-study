package com.copysun.nacosservice.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author copysun
 * 数据库实体基础类
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = -6314402184890971666L;

    /**
     * 主键ID,自动生成32位uuid
     */
    @TableId(value = "id",type = IdType.ASSIGN_UUID)
    private String id;

    /**
     * 数据创建者
     */
    @TableField(fill = FieldFill.INSERT)
    private String createUser;

    /**
     * 数据修改者
     */
    @TableField(fill = FieldFill.UPDATE)
    private String updateUser;


    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.UPDATE)
    private Date updateTime;
}
