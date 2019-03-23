package com.red.red2.been;

import lombok.Data;

@Data
public class User {
    //id 自增
    private Integer id;

    private String username;

    //密码
    private String password;

    //角色："admin":管理员 "user":用户
    private String role;

    //组织
    private String company;



    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getRole() == null ? other.getRole() == null : this.getRole().equals(other.getRole()))
            && (this.getCompany() == null ? other.getCompany() == null : this.getCompany().equals(other.getCompany()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getRole() == null) ? 0 : getRole().hashCode());
        result = prime * result + ((getCompany() == null) ? 0 : getCompany().hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                " id = "+id+
                " username = "+username+
                " password = "+password+
                " role = "+role+
                " company = "+company+
                "}";
    }
}