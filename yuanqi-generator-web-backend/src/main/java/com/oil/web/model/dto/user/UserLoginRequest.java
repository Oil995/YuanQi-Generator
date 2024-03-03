package com.oil.web.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 走肖
 * @version 2.3
 * 用户登录请求
 */
@Data
public class UserLoginRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    private String userAccount;

    private String userPassword;
}
