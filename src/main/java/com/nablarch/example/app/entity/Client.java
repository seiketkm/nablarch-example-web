package com.nablarch.example.app.entity;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Clientエンティティクラス
 *
 */
@Generated("GSP")
@Entity
@Table(name = "CLIENT")
public class Client implements Serializable {

    private static final long serialVersionUID = 1L;

    /** clientNumプロパティ */
    private Integer clientNum;

    /** clientNameプロパティ */
    private String clientName;

    /** industryCodeプロパティ */
    private String industryCode;

    /** industry関連プロパティ */
    private Industry industry;

    /** projectList関連プロパティ */
    private List<Project> projectList;
    /**
     * clientNumを返します。
     *
     * @return clientNum
     */
    @Id
    @Column(name = "CLIENT_NUM", precision = 10, nullable = false, unique = true)
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
     * clientNameを返します。
     *
     * @return clientName
     */
    @Column(name = "CLIENT_NAME", length = 128, nullable = false, unique = false)
    public String getClientName() {
        return clientName;
    }

    /**
     * clientNameを設定します。
     *
     * @param clientName
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    /**
     * industryCodeを返します。
     *
     * @return industryCode
     */
    @Column(name = "INDUSTRY_CODE", length = 2, nullable = false, unique = false, insertable = false, updatable = false)
    public String getIndustryCode() {
        return industryCode;
    }

    /**
     * industryCodeを設定します。
     *
     * @param industryCode
     */
    public void setIndustryCode(String industryCode) {
        this.industryCode = industryCode;
    }

    /**
     * industryを返します。
     *
     * @return industry
     */
    @ManyToOne
    @JoinColumn(name = "INDUSTRY_CODE", referencedColumnName = "INDUSTRY_CODE")
    public Industry getIndustry() {
        return industry;
    }

    /**
     * industryを設定します。
     *
     * @param industry industry
     */
    public void setIndustry(Industry industry) {
        this.industry = industry;
    }

    /**
     * projectListを返します。
     *
     * @return projectList
     */
    @OneToMany(mappedBy = "client")
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
}
