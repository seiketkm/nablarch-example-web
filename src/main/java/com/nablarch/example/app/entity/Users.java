package com.nablarch.example.app.entity;

import java.io.Serializable;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Usersエンティティクラス
 *
 */
@Generated("GSP")
@Entity
@Table(name = "USERS")
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    /** userNumプロパティ */
    private Integer userNum;

    /** kanjiNameプロパティ */
    private String kanjiName;

    /** kanaNameプロパティ */
    private String kanaName;

    /** systemAccount関連プロパティ */
    private SystemAccount systemAccount;
    /**
     * userNumを返します。
     *
     * @return userNum
     */
    @Id
    @Column(name = "USER_NUM", precision = 10, nullable = false, unique = true, insertable = false, updatable = false)
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
     * kanjiNameを返します。
     *
     * @return kanjiName
     */
    @Column(name = "KANJI_NAME", length = 128, nullable = false, unique = false)
    public String getKanjiName() {
        return kanjiName;
    }

    /**
     * kanjiNameを設定します。
     *
     * @param kanjiName
     */
    public void setKanjiName(String kanjiName) {
        this.kanjiName = kanjiName;
    }
    /**
     * kanaNameを返します。
     *
     * @return kanaName
     */
    @Column(name = "KANA_NAME", length = 128, nullable = false, unique = false)
    public String getKanaName() {
        return kanaName;
    }

    /**
     * kanaNameを設定します。
     *
     * @param kanaName
     */
    public void setKanaName(String kanaName) {
        this.kanaName = kanaName;
    }

    /**
     * systemAccountを返します。
     *
     * @return systemAccount
     */
    @OneToOne
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
