package com.tpm.tobitoi.prototype.internal.data.local.pojo;



import org.parceler.Parcel;
import org.parceler.ParcelConstructor;
import org.parceler.ParcelProperty;


import java.util.Date;
import java.util.List;

/**
 * Created by Tobitoi on 20/10/2018.
 */

@Parcel(Parcel.Serialization.BEAN)
public class User {

    @ParcelProperty(value = "id")
     long id;

    @ParcelProperty(value = "createBy")
     String createBy;

    @ParcelProperty(value = "createTime")
     Date createTime;

    @ParcelProperty(value = "updatebBy")
     String updateBy;

    @ParcelProperty(value = "updateTime")
     Date updateTime;

    @ParcelProperty("delFlag")
     Integer delFlag;

    @ParcelProperty("username")
     String username;

    @ParcelProperty("password")
     String password;

    @ParcelProperty("nickName")
     String nickName;

    @ParcelProperty("mobile")
     String mobile;

    @ParcelProperty("email")
     String email;

    @ParcelProperty("address")
     String address;

    @ParcelProperty("street")
     String street;

    @ParcelProperty("sex")
     Integer sex;

    @ParcelProperty("avatar")
     String avatar;

    @ParcelProperty("type")
     Integer type;

    @ParcelProperty("status")
     Integer status;

    @ParcelProperty("description")
     String description;

    @ParcelProperty("departmentId")
     String departmentId;

    @ParcelProperty("departmentTitle")
     String departmentTitle;

    @ParcelProperty("roles")
     List<String> roles;

    @ParcelProperty("permissions")
     List<String> permissions;

    @ParcelProperty("token")
    String token;

    @ParcelConstructor
    public User(){

    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentTitle() {
        return departmentTitle;
    }

    public void setDepartmentTitle(String departmentTitle) {
        this.departmentTitle = departmentTitle;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
