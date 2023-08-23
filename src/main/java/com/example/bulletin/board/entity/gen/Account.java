package com.example.bulletin.board.entity.gen;

import java.util.Date;

public class Account extends AccountKey {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.password
     *
     * @mbg.generated
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.authority
     *
     * @mbg.generated
     */
    private String authority;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.del_flg
     *
     * @mbg.generated
     */
    private String delFlg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.expiration
     *
     * @mbg.generated
     */
    private Date expiration;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.password_expiration
     *
     * @mbg.generated
     */
    private Date passwordExpiration;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.login_failure_count
     *
     * @mbg.generated
     */
    private Integer loginFailureCount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.created_at
     *
     * @mbg.generated
     */
    private Date createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account.updated_at
     *
     * @mbg.generated
     */
    private Date updatedAt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.name
     *
     * @return the value of account.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.name
     *
     * @param name the value for account.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.password
     *
     * @return the value of account.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.password
     *
     * @param password the value for account.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.authority
     *
     * @return the value of account.authority
     *
     * @mbg.generated
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.authority
     *
     * @param authority the value for account.authority
     *
     * @mbg.generated
     */
    public void setAuthority(String authority) {
        this.authority = authority;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.del_flg
     *
     * @return the value of account.del_flg
     *
     * @mbg.generated
     */
    public String getDelFlg() {
        return delFlg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.del_flg
     *
     * @param delFlg the value for account.del_flg
     *
     * @mbg.generated
     */
    public void setDelFlg(String delFlg) {
        this.delFlg = delFlg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.expiration
     *
     * @return the value of account.expiration
     *
     * @mbg.generated
     */
    public Date getExpiration() {
        return expiration;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.expiration
     *
     * @param expiration the value for account.expiration
     *
     * @mbg.generated
     */
    public void setExpiration(Date expiration) {
        this.expiration = expiration;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.password_expiration
     *
     * @return the value of account.password_expiration
     *
     * @mbg.generated
     */
    public Date getPasswordExpiration() {
        return passwordExpiration;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.password_expiration
     *
     * @param passwordExpiration the value for account.password_expiration
     *
     * @mbg.generated
     */
    public void setPasswordExpiration(Date passwordExpiration) {
        this.passwordExpiration = passwordExpiration;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.login_failure_count
     *
     * @return the value of account.login_failure_count
     *
     * @mbg.generated
     */
    public Integer getLoginFailureCount() {
        return loginFailureCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.login_failure_count
     *
     * @param loginFailureCount the value for account.login_failure_count
     *
     * @mbg.generated
     */
    public void setLoginFailureCount(Integer loginFailureCount) {
        this.loginFailureCount = loginFailureCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.created_at
     *
     * @return the value of account.created_at
     *
     * @mbg.generated
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.created_at
     *
     * @param createdAt the value for account.created_at
     *
     * @mbg.generated
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account.updated_at
     *
     * @return the value of account.updated_at
     *
     * @mbg.generated
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account.updated_at
     *
     * @param updatedAt the value for account.updated_at
     *
     * @mbg.generated
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account
     *
     * @mbg.generated
     */
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
        Account other = (Account) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getAuthority() == null ? other.getAuthority() == null : this.getAuthority().equals(other.getAuthority()))
            && (this.getDelFlg() == null ? other.getDelFlg() == null : this.getDelFlg().equals(other.getDelFlg()))
            && (this.getExpiration() == null ? other.getExpiration() == null : this.getExpiration().equals(other.getExpiration()))
            && (this.getPasswordExpiration() == null ? other.getPasswordExpiration() == null : this.getPasswordExpiration().equals(other.getPasswordExpiration()))
            && (this.getLoginFailureCount() == null ? other.getLoginFailureCount() == null : this.getLoginFailureCount().equals(other.getLoginFailureCount()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getUpdatedAt() == null ? other.getUpdatedAt() == null : this.getUpdatedAt().equals(other.getUpdatedAt()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getAuthority() == null) ? 0 : getAuthority().hashCode());
        result = prime * result + ((getDelFlg() == null) ? 0 : getDelFlg().hashCode());
        result = prime * result + ((getExpiration() == null) ? 0 : getExpiration().hashCode());
        result = prime * result + ((getPasswordExpiration() == null) ? 0 : getPasswordExpiration().hashCode());
        result = prime * result + ((getLoginFailureCount() == null) ? 0 : getLoginFailureCount().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        result = prime * result + ((getUpdatedAt() == null) ? 0 : getUpdatedAt().hashCode());
        return result;
    }
}