package com.tpm.tobitoi.prototype.internal.data.remote.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Tobitoi on 20/10/2018.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse {

    @JsonProperty(value = "code")
    public String code;

    @JsonProperty(value = "success")
    public Boolean success;

    @JsonProperty(value = "user")
    public User user;

    @JsonProperty(value = "accessToken")
    public String accessToken;

    @JsonProperty(value = "timestamp")
    public Date timestamp;

    @JsonProperty(value = "message")
    public String message;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class User{
        @JsonProperty(value = "id")
        public long id;

        @JsonProperty(value = "createBy")
        public String createBy;

        @JsonProperty(value = "createTime")
        public String createTime;

        @JsonProperty(value = "updatebBy")
        public String updateBy;

        @JsonProperty(value = "updateTime")
        public String updateTime;

        @JsonProperty("delFlag")
        public Integer delFlag;

        @JsonProperty("username")
        public String username;

        @JsonProperty("password")
        public String password;

        @JsonProperty("nickName")
        public String nickName;

        @JsonProperty("mobile")
        public String mobile;

        @JsonProperty("email")
        public String email;

        @JsonProperty("address")
        public String address;

        @JsonProperty("street")
        public String street;

        @JsonProperty("sex")
        public Integer sex;

        @JsonProperty("avatar")
        public String avatar;

        @JsonProperty("type")
        public Integer type;

        @JsonProperty("status")
        public Integer status;

        @JsonProperty("description")
        public String description;

        @JsonProperty("departmentId")
        public String departmentId;

        @JsonProperty("departmentTitle")
        public String departmentTitle;

        @JsonProperty("roles")
        public List<Role> roles;

        @JsonProperty("permissions")
        public List<Permission> permissions;

    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Role{
        @JsonProperty("id")
        public long id;

        @JsonProperty("createBy")
        public String createBy;

        @JsonProperty("createTime")
        public String createTime;

        @JsonProperty("updateBy")
        public String updateBy;

        @JsonProperty("updateTime")
        public String updateTime;

        @JsonProperty("delFlag")
        public Integer delFlag;

        @JsonProperty("name")
        public String name;

        @JsonProperty("defaultRole")
        public Boolean defaultRole;

        @JsonProperty("description")
        public String description;

        @JsonProperty("permissions")
        public List<Permission> permissions;

    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Permission{

        @JsonProperty("id")
        public long id;

        @JsonProperty("createBy")
        public String createBy;

        @JsonProperty("createTime")
        public String createTime;

        @JsonProperty("updateBy")
        public String updateBy;

        @JsonProperty("updateTime")
        public String updateTime;

        @JsonProperty("delFlag")
        public Integer delFlag;

        @JsonProperty("name")
        public String name;

        @JsonProperty("level")
        public Integer level;

        @JsonProperty("type")
        public Integer type;

        @JsonProperty("title")
        public String title;

        @JsonProperty("path")
        public String path;

        @JsonProperty("component")
        public String component;

        @JsonProperty("icon")
        public String icon;

        @JsonProperty("buttonType")
        public String buttonType;

        @JsonProperty("parentId")
        public String parentId;

        @JsonProperty("description")
        public String description;

        @JsonProperty("sortOrder")
        public BigDecimal sortOrder;

        @JsonProperty("status")
        public Integer status;

        @JsonProperty("url")
        public String url;

        @JsonProperty("children")
        public List<Permission> children;

        @JsonProperty("permTypes")
        public List<String> permTypes;

        @JsonProperty("expand")
        public Boolean expand;

        @JsonProperty("checked")
        public Boolean checked;

        @JsonProperty("selected")
        public Boolean selected;

    }

}
