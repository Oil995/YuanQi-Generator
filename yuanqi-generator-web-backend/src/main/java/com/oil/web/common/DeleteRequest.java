package com.oil.web.common;

import lombok.Data;

import java.io.Serializable;

/**
 * 删除请求
 *
 * @author 走肖
 * @version 2.3
 */
@Data
public class DeleteRequest implements Serializable {

    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 1L;
}