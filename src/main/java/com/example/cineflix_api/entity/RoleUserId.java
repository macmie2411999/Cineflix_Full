package com.example.cineflix_api.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/*
* class chứa 2 khóa chính của bảng trung gian trong quan hệ n-n
* */
@Embeddable
public class RoleUserId implements Serializable {
    @Column(name = "role_id")
    private long roleId;

    @Column(name = "user_id")
    private long userId;

    public RoleUserId(long roleid, long userid){
        this.roleId = roleid;
        this.userId = userid;
    }

    public RoleUserId() {

    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
