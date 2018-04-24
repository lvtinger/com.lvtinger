package com.lvtinger.demo.domain;

import java.util.Date;

public class PersistentObject {
    private Integer identity;

    private Long version;

    private ObjectStatus Status;

    private Date createTime;
    private Date modifyTime;
    private Date deleteTime;

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public ObjectStatus getStatus() {
        return Status;
    }

    public void setStatus(ObjectStatus status) {
        Status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }
}
