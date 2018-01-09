package com.nablarch.example.app.entity;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PasswordHistoryエンティティクラス
 *
 */
@Generated("GSP")
@Entity
@Table(name = "PASSWORD_HISTORY")
public class PasswordHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /** passwordHistoryIdプロパティ */
    private Long passwordHistoryId;

    /** userNumプロパティ */
    private Integer userNum;

    /** userPasswordプロパティ */
    private String userPassword;

    /** systemAccount関連プロパティ */
    private SystemAccount systemAccount;
    /**
     * passwordHistoryIdを返します。
     *
     * @return passwordHistoryId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PASSWORD_HISTORY_ID", precision = 19, nullable = false, unique = true)
    public Long getPasswordHistoryId() {
        return passwordHistoryId;
    }

    /**
     * passwordHistoryIdを設定します。
     *
     * @param passwordHistoryId
     */
    public void setPasswordHistoryId(Long passwordHistoryId) {
        this.passwordHistoryId = passwordHistoryId;
    }
    /**
     * userNumを返します。
     *
     * @return userNum
     */
    @Column(name = "USER_NUM", precision = 10, nullable = false, unique = false, insertable = false, updatable = false)
    public Integer getUserNum() {
        return userNum;
    }

    /**
     * userNumを設定します。
     *
     * @param userNum
     */
    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }
    /**
     * userPasswordを返します。
     *
     * @return userPassword
     */
    @Column(name = "USER_PASSWORD", length = 44, nullable = false, unique = false)
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * userPasswordを設定します。
     *
     * @param userPassword
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * systemAccountを返します。
     *
     * @return systemAccount
     */
    @ManyToOne
    @JoinColumn(name = "USER_NUM", referencedColumnName = "USER_NUM")
    public SystemAccount getSystemAccount() {
        return systemAccount;
    }

    /**
     * systemAccountを設定します。
     *
     * @param systemAccount systemAccount
     */
    public void setSystemAccount(SystemAccount systemAccount) {
        this.systemAccount = systemAccount;
    }
}
