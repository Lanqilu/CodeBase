package com.halo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * (Books)实体类
 *
 * @author makejava
 * @since 2020-12-19 14:16:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Books {

    /**
     * 书id
     */
    private Integer bookID;
    /**
     * 书名
     */
    private String bookName;
    /**
     * 数量
     */
    private Integer bookCounts;
    /**
     * 描述
     */
    private String detail;


}
