package com.moyu.myadmin.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 查询参数
 * @author jiaomingyu5778@gmail.com
 * @date 2022/1/19 22:47
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryData<T> {

    private int pageNum = 1;
    private int pageSize = 10;
    private T data;
}
