package com.moyu.myadmin.config;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.util.Date;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2022/1/11 23:01
 */
@Data
public class PublicField {

    /**
     * 创建人单位编码
     */
    @TableField(fill = FieldFill.INSERT)
    private String custNo;
    /**
     * 创建人单位编码
     */
    @TableField(fill = FieldFill.INSERT)
    private String custName;
    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String creatorNo;
    /**
     * 创建人名称
     */
    @TableField(fill = FieldFill.INSERT)
    private String creatorName;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String lastUpdatorNo;
    /**
     * 更新人名称
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String lastUpdatorName;
    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date lastUpdateTime;
    /**
     * 版本（用于乐观锁）
     */
    @Version
    @TableField(fill = FieldFill.INSERT,update = "%s+1")
    private Integer version;

    /**
     * 逻辑删除 0 未删除 1 删除
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer delFlag;


}
