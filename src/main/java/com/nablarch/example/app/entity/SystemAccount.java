package com.nablarch.example.app.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * SystemAccountエンティティクラス
 *
 */
@Generated("GSP")
@Entity
@Table(name = "SYSTEM_ACCOUNT")
public class SystemAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    /** userNumプロパティ */
    private Integer userNum;

    /** loginIdプロパティ */
    private String loginId;

    /** userPasswordプロパティ */
    private String userPassword;

    /** userIdLockedプロパティ */
    private boolean userIdLocked;

    /** passwordExpirationDateプロパティ */
    private Date passwordExpirationDate;

    /** failedCountプロパティ */
    private Short failedCount;

    /** effectiveDateFromプロパティ */
    private Date effectiveDateFrom;

    /** effectiveDateToプロパティ */
    private Date effectiveDateTo;

    /** lastLoginDateTimeプロパティ */
    private Timestamp lastLoginDateTime;

    /** versionプロパティ */
    private Long version;

    /** passwordHistoryList関連プロパティ */
    private List<PasswordHistory> passwordHistoryList;

    /** projectList関連プロパティ */
    private List<Project> projectList;

    /** users関連プロパティ */
    private Users users;
    /**
     * userNumを返します。
     *
     * @return userNum
     */
    @Id
    @Column(name = "USER_NUM", precision = 10, nullable = false, unique = true)
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
     * loginIdを返します。
     *
     * @return loginId
     */
    @Column(name = "LOGIN_ID", length = 20, nullable = false, unique = true)
    public String getLoginId() {
        return loginId;
    }

    /**
     * loginIdを設定します。
     *
     * @param loginId
     */
    public void setLoginId(String loginId) {
        this.loginId = loginId;
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
     * userIdLockedを返します。
     *
     * @return userIdLocked
     */
    @Column(name = "USER_ID_LOCKED", length = 1, nullable = false, unique = false)
    public boolean isUserIdLocked() {
        return userIdLocked;
    }

    /**
     * userIdLockedを設定します。
     *
     * @param userIdLocked
     */
    public void setUserIdLocked(boolean userIdLocked) {
        this.userIdLocked = userIdLocked;
    }
    /**
     * passwordExpirationDateを返します。
     *
     * @return passwordExpirationDate
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "PASSWORD_EXPIRATION_DATE", nullable = false, unique = false)
    public Date getPasswordExpirationDate() {
        return passwordExpirationDate;
    }

    /**
     * passwordExpirationDateを設定します。
     *
     * @param passwordExpirationDate
     */
    public void setPasswordExpirationDate(Date passwordExpirationDate) {
        this.passwordExpirationDate = passwordExpirationDate;
    }
    /**
     * failedCountを返します。
     *
     * @return failedCount
     */
    @Column(name = "FAILED_COUNT", precision = 5, nullable = false, unique = false)
    public Short getFailedCount() {
        return failedCount;
    }

    /**
     * failedCountを設定します。
     *
     * @param failedCount
     */
    public void setFailedCount(Short failedCount) {
        this.failedCount = failedCount;
    }
    /**
     * effectiveDateFromを返します。
     *
     * @return effectiveDateFrom
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "EFFECTIVE_DATE_FROM", nullable = true, unique = false)
    public Date getEffectiveDateFrom() {
        return effectiveDateFrom;
    }

    /**
     * effectiveDateFromを設定します。
     *
     * @param effectiveDateFrom
     */
    public void setEffectiveDateFrom(Date effectiveDateFrom) {
        this.effectiveDateFrom = effectiveDateFrom;
    }
    /**
     * effectiveDateToを返します。
     *
     * @return effectiveDateTo
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "EFFECTIVE_DATE_TO", nullable = true, unique = false)
    public Date getEffectiveDateTo() {
        return effectiveDateTo;
    }

    /**
     * effectiveDateToを設定します。
     *
     * @param effectiveDateTo
     */
    public void setEffectiveDateTo(Date effectiveDateTo) {
        this.effectiveDateTo = effectiveDateTo;
    }
    /**
     * lastLoginDateTimeを返します。
     *
     * @return lastLoginDateTime
     */
    @Column(name = "LAST_LOGIN_DATE_TIME", nullable = true, unique = false)
    public Timestamp getLastLoginDateTime() {
        return lastLoginDateTime;
    }

    /**
     * lastLoginDateTimeを設定します。
     *
     * @param lastLoginDateTime
     */
    public void setLastLoginDateTime(Timestamp lastLoginDateTime) {
        this.lastLoginDateTime = lastLoginDateTime;
    }
    /**
     * versionを返します。
     *
     * @return version
     */
    @Version
    @Column(name = "VERSION", precision = 19, nullable = false, unique = false)
    public Long getVersion() {
        return version;
    }

    /**
     * versionを設定します。
     *
     * @param version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * passwordHistoryListを返します。
     *
     * @return passwordHistoryList
     */
    @OneToMany(mappedBy = "systemAccount")
    public List<PasswordHistory> getPasswordHistoryList() {
        return passwordHistoryList;
    }

    /**
     * passwordHistoryListを設定します。
     *
     * @param passwordHistoryList passwordHistoryList
     */
    public void setPasswordHistoryList(List<PasswordHistory> passwordHistoryList) {
        this.passwordHistoryList = passwordHistoryList;
    }

    /**
     * projectListを返します。
     *
     * @return projectList
     */
    @OneToMany(mappedBy = "systemAccount")
    public List<Project> getProjectList() {
        return projectList;
    }

    /**
     * projectListを設定します。
     *
     * @param projectList projectList
     */
    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }

    /**
     * usersを返します。
     *
     * @return users
     */
    @OneToOne(mappedBy = "systemAccount")
    public Users getUsers() {
        return users;
    }

    /**
     * usersを設定します。
     *
     * @param users users
     */
    public void setUsers(Users users) {
        this.users = users;
    }
}
