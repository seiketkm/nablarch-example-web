package com.nablarch.example.app.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserSessionエンティティクラス
 *
 */
@Generated("GSP")
@Entity
@Table(name = "USER_SESSION")
public class UserSession implements Serializable {

    private static final long serialVersionUID = 1L;

    /** sessionIdプロパティ */
    private String sessionId;

    /** sessionObjectプロパティ */
    private byte[] sessionObject;

    /** expirationDatetimeプロパティ */
    private Timestamp expirationDatetime;
    /**
     * sessionIdを返します。
     *
     * @return sessionId
     */
    @Id
    @Column(name = "SESSION_ID", length = 100, nullable = false, unique = true)
    public String getSessionId() {
        return sessionId;
    }

    /**
     * sessionIdを設定します。
     *
     * @param sessionId
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }
    /**
     * sessionObjectを返します。
     *
     * @return sessionObject
     */
    @Column(name = "SESSION_OBJECT", length = 2147483647, nullable = false, unique = false)
    public byte[] getSessionObject() {
        return sessionObject;
    }

    /**
     * sessionObjectを設定します。
     *
     * @param sessionObject
     */
    public void setSessionObject(byte[] sessionObject) {
        this.sessionObject = sessionObject;
    }
    /**
     * expirationDatetimeを返します。
     *
     * @return expirationDatetime
     */
    @Column(name = "EXPIRATION_DATETIME", nullable = false, unique = false)
    public Timestamp getExpirationDatetime() {
        return expirationDatetime;
    }

    /**
     * expirationDatetimeを設定します。
     *
     * @param expirationDatetime
     */
    public void setExpirationDatetime(Timestamp expirationDatetime) {
        this.expirationDatetime = expirationDatetime;
    }
}
