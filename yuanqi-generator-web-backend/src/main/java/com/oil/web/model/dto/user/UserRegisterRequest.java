package com.oil.web.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 走肖
 * @version 2.3
 * 用户注册请求体
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;
}
