package com.nablarch.example.app.entity;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Industryエンティティクラス
 *
 */
@Generated("GSP")
@Entity
@Table(name = "INDUSTRY")
public class Industry implements Serializable {

    private static final long serialVersionUID = 1L;

    /** industryCodeプロパティ */
    private String industryCode;

    /** industryNameプロパティ */
    private String industryName;

    /** clientList関連プロパティ */
    private List<Client> clientList;
    /**
     * industryCodeを返します。
     *
     * @return industryCode
     */
    @Id
    @Column(name = "INDUSTRY_CODE", length = 2, nullable = false, unique = true)
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
     * industryNameを返します。
     *
     * @return industryName
     */
    @Column(name = "INDUSTRY_NAME", length = 50, nullable = true, unique = false)
    public String getIndustryName() {
        return industryName;
    }

    /**
     * industryNameを設定します。
     *
     * @param industryName
     */
    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    /**
     * clientListを返します。
     *
     * @return clientList
     */
    @OneToMany(mappedBy = "industry")
    public List<Client> getClientList() {
        return clientList;
    }

    /**
     * clientListを設定します。
     *
     * @param clientList clientList
     */
    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }
}
