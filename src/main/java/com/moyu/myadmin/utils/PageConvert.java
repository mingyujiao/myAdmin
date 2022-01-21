package com.moyu.myadmin.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @author jiaomingyu5778@gmail.com
 * @date 2022/1/21 14:50
 * 将 entity page 转换为 vo page
 */

public class PageConvert {

    private PageConvert(){}

    public static <T, V> Page<T> convert(Page<V> page, List<T> list) {
        Page<T> tPage = new Page<>();
        tPage.setRecords(list);
        tPage.setTotal(page.getTotal());
        return tPage;
    }
}
