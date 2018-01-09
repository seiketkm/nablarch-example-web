package com.nablarch.example.app.entity;

import java.io.Serializable;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * Projectエンティティクラス
 *
 */
@Generated("GSP")
@Entity
@Table(name = "PROJECT")
public class Project implements Serializable {

    private static final long serialVersionUID = 1L;

    /** projectIdプロパティ */
    private Integer projectId;

    /** projectNameプロパティ */
    private String projectName;

    /** projectTypeプロパティ */
    private String projectType;

    /** projectClassプロパティ */
    private String projectClass;

    /** projectStartDateプロパティ */
    private Date projectStartDate;

    /** projectEndDateプロパティ */
    private Date projectEndDate;

    /** clientNumプロパティ */
    private Integer clientNum;

    /** projectManagerプロパティ */
    private String projectManager;

    /** projectLeaderプロパティ */
    private String projectLeader;

    /** userNumプロパティ */
    private Integer userNum;

    /** noteプロパティ */
    private String note;

    /** salesプロパティ */
    private Integer sales;

    /** costOfGoodsSoldプロパティ */
    private Integer costOfGoodsSold;

    /** sgaプロパティ */
    private Integer sga;

    /** allocationOfCorpExpensesプロパティ */
    private Integer allocationOfCorpExpenses;

    /** versionプロパティ */
    private Long version;

    /** client関連プロパティ */
    private Client client;

    /** systemAccount関連プロパティ */
    private SystemAccount systemAccount;
    /**
     * projectIdを返します。
     *
     * @return projectId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROJECT_ID", precision = 10, nullable = false, unique = true)
    public Integer getProjectId() {
        return projectId;
    }

    /**
     * projectIdを設定します。
     *
     * @param projectId
     */
    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }
    /**
     * projectNameを返します。
     *
     * @return projectName
     */
    @Column(name = "PROJECT_NAME", length = 128, nullable = false, unique = false)
    public String getProjectName() {
        return projectName;
    }

    /**
     * projectNameを設定します。
     *
     * @param projectName
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    /**
     * projectTypeを返します。
     *
     * @return projectType
     */
    @Column(name = "PROJECT_TYPE", length = 128, nullable = false, unique = false)
    public String getProjectType() {
        return projectType;
    }

    /**
     * projectTypeを設定します。
     *
     * @param projectType
     */
    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }
    /**
     * projectClassを返します。
     *
     * @return projectClass
     */
    @Column(name = "PROJECT_CLASS", length = 128, nullable = false, unique = false)
    public String getProjectClass() {
        return projectClass;
    }

    /**
     * projectClassを設定します。
     *
     * @param projectClass
     */
    public void setProjectClass(String projectClass) {
        this.projectClass = projectClass;
    }
    /**
     * projectStartDateを返します。
     *
     * @return projectStartDate
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "PROJECT_START_DATE", nullable = true, unique = false)
    public Date getProjectStartDate() {
        return projectStartDate;
    }

    /**
     * projectStartDateを設定します。
     *
     * @param projectStartDate
     */
    public void setProjectStartDate(Date projectStartDate) {
        this.projectStartDate = projectStartDate;
    }
    /**
     * projectEndDateを返します。
     *
     * @return projectEndDate
     */
    @Temporal(TemporalType.DATE)
    @Column(name = "PROJECT_END_DATE", nullable = true, unique = false)
    public Date getProjectEndDate() {
        return projectEndDate;
    }

    /**
     * projectEndDateを設定します。
     *
     * @param projectEndDate
     */
    public void setProjectEndDate(Date projectEndDate) {
        this.projectEndDate = projectEndDate;
    }
    /**
     * clientNumを返します。
     *
     * @return clientNum
     */
    @Column(name = "CLIENT_NUM", precision = 10, nullable = false, unique = false, insertable = false, updatable = false)
    public Integer getClientNum() {
        return clientNum;
    }

    /**
     * clientNumを設定します。
     *
     * @param clientNum
     */
    public void setClientNum(Integer clientNum) {
        this.clientNum = clientNum;
    }
    /**
     * projectManagerを返します。
     *
     * @return projectManager
     */
    @Column(name = "PROJECT_MANAGER", length = 128, nullable = true, unique = false)
    public String getProjectManager() {
        return projectManager;
    }

    /**
     * projectManagerを設定します。
     *
     * @param projectManager
     */
    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }
    /**
     * projectLeaderを返します。
     *
     * @return projectLeader
     */
    @Column(name = "PROJECT_LEADER", length = 128, nullable = true, unique = false)
    public String getProjectLeader() {
        return projectLeader;
    }

    /**
     * projectLeaderを設定します。
     *
     * @param projectLeader
     */
    public void setProjectLeader(String projectLeader) {
        this.projectLeader = projectLeader;
    }
    /**
     * userNumを返します。
     *
     * @return userNum
     */
    @Column(name = "USER_NUM", precision = 10, nullable = true, unique = false, insertable = false, updatable = false)
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
     * noteを返します。
     *
     * @return note
     */
    @Column(name = "NOTE", length = 512, nullable = true, unique = false)
    public String getNote() {
        return note;
    }

    /**
     * noteを設定します。
     *
     * @param note
     */
    public void setNote(String note) {
        this.note = note;
    }
    /**
     * salesを返します。
     *
     * @return sales
     */
    @Column(name = "SALES", precision = 10, nullable = true, unique = false)
    public Integer getSales() {
        return sales;
    }

    /**
     * salesを設定します。
     *
     * @param sales
     */
    public void setSales(Integer sales) {
        this.sales = sales;
    }
    /**
     * costOfGoodsSoldを返します。
     *
     * @return costOfGoodsSold
     */
    @Column(name = "COST_OF_GOODS_SOLD", precision = 10, nullable = true, unique = false)
    public Integer getCostOfGoodsSold() {
        return costOfGoodsSold;
    }

    /**
     * costOfGoodsSoldを設定します。
     *
     * @param costOfGoodsSold
     */
    public void setCostOfGoodsSold(Integer costOfGoodsSold) {
        this.costOfGoodsSold = costOfGoodsSold;
    }
    /**
     * sgaを返します。
     *
     * @return sga
     */
    @Column(name = "SGA", precision = 10, nullable = true, unique = false)
    public Integer getSga() {
        return sga;
    }

    /**
     * sgaを設定します。
     *
     * @param sga
     */
    public void setSga(Integer sga) {
        this.sga = sga;
    }
    /**
     * allocationOfCorpExpensesを返します。
     *
     * @return allocationOfCorpExpenses
     */
    @Column(name = "ALLOCATION_OF_CORP_EXPENSES", precision = 10, nullable = true, unique = false)
    public Integer getAllocationOfCorpExpenses() {
        return allocationOfCorpExpenses;
    }

    /**
     * allocationOfCorpExpensesを設定します。
     *
     * @param allocationOfCorpExpenses
     */
    public void setAllocationOfCorpExpenses(Integer allocationOfCorpExpenses) {
        this.allocationOfCorpExpenses = allocationOfCorpExpenses;
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
     * clientを返します。
     *
     * @return client
     */
    @ManyToOne
    @JoinColumn(name = "CLIENT_NUM", referencedColumnName = "CLIENT_NUM")
    public Client getClient() {
        return client;
    }

    /**
     * clientを設定します。
     *
     * @param client client
     */
    public void setClient(Client client) {
        this.client = client;
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
