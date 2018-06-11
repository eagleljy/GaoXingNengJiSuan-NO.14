package com.sinosoft.cpyy.controller.index.ordervo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderVo implements Comparable<OrderVo> {
    /**
     * 年份
     */
    private int year;
    /**
     * 数量
     */
    private int num;

    @Override
    public int compareTo(OrderVo orderVo) {
        return this.year - orderVo.year;
    }
}
