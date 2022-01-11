package com.moyu.myadmin.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2022/1/11 22:58
 */

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 单位编号
     * */
    private static final String CUST_NO = "custNo";

    /**
     * 单位名称
     * */
    private static final String CUST_NAME = "custName";

    /**
     * 创建人编号
     * */
    private static final String CREATOR_NO = "creatorNo";

    /**
     * 创建人名称
     * */
    private static final String CREATOR_NAME = "creatorName";

    /**
     * 最后修改人编号
     * */
    private static final String LAST_UPDATOR_NO = "lastUpdatorNo";

    /**
     * 最后修改人名称
     * */
    private static final String LAST_UPDATOR_NAME = "lastUpdatorName";

    /**
     * 版本号
     * */
    private static final String VERSION = "version";

    /**
     * 逻辑删除状态(0-正常;1-已删除)
     * */
    private static final String DEL_FLAG = "delFlag";

    /**
     * 创建时间
     * */
    private static final String CREATE_TIME = "createTime";

    /**
     * 最后修改时间
     * */
    private static final String LAST_UPDATE_TIME = "lastUpdateTime";

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        this.strictInsertFill(metaObject, VERSION, Integer.class, 0);
        this.strictInsertFill(metaObject, DEL_FLAG, Integer.class, 0);
        this.strictInsertFill(metaObject, CREATE_TIME, LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, LAST_UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, CUST_NO, String.class, "");
        this.strictInsertFill(metaObject, CUST_NAME, String.class, "");
        this.strictInsertFill(metaObject, CREATOR_NO, String.class, "");
        this.strictInsertFill(metaObject, CREATOR_NAME, String.class, "");
        this.strictInsertFill(metaObject, LAST_UPDATOR_NO, String.class, "");
        this.strictInsertFill(metaObject, LAST_UPDATOR_NAME, String.class, "");
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        String userNo = "";
        String userName = "";
        this.strictUpdateFill(metaObject, LAST_UPDATE_TIME, LocalDateTime.class, LocalDateTime.now());
        this.strictInsertFill(metaObject, LAST_UPDATOR_NO, String.class, userNo);
        this.strictInsertFill(metaObject, LAST_UPDATOR_NAME, String.class, userName);
    }
}
