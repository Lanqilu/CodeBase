package com.halo.pojo;


import lombok.*;

/**
 * @author Halo
 * @date Created in 2020/11/07  11:08
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private String pwd;
}
