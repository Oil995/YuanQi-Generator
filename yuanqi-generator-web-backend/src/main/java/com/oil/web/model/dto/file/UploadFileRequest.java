package com.oil.web.model.dto.file;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 走肖
 * @version 2.3
 * 文件上传请求
 */
@Data
public class UploadFileRequest implements Serializable {

    /**
     * 业务
     */
    private String biz;

    private static final long serialVersionUID = 1L;
}