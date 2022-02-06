package com.moyu.myadmin.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2022/1/11 23:01
 */
@Data
public class PublicField {


    /**
     * 创建人
     */
    @TableField(fill = FieldFill.INSERT)
    private String createBy;

    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createDate;
    /**
     * 更新人
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private String updateBy;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateDate;
    /**
     * 版本（用于乐观锁）
     */
    @Version
    @TableField(fill = FieldFill.INSERT_UPDATE, update = "%s+1")
    private Integer rowVersion;

    /**
     * 逻辑删除 0 未删除 1 删除
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer delFlag;


}
