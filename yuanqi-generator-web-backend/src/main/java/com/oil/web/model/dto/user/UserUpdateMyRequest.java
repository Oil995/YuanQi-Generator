package com.oil.web.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 走肖
 * @version 2.3
 * 用户更新个人信息请求
 */
@Data
public class UserUpdateMyRequest implements Serializable {

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户头像
     */
    private String userAvatar;

    /**
     * 简介
     */
    private String userProfile;

    private static final long serialVersionUID = 1L;
}