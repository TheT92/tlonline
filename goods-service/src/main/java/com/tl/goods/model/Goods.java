package com.tl.goods.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private Integer id;
    private UUID uuid;
    private String name;
    private String desc;
    private Integer state;
    private Integer delFlag; // 0 not deleted, 1 deleted
}
