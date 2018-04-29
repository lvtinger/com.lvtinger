package com.lvtinger.demo.domain;

import java.io.Serializable;

public abstract class PersistentObject implements Serializable {
    private Long createTime;
    private Long updateTime;
    private int status;
    private Long version;

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "PersistentObject{" +
                "createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", status=" + status +
                ", version=" + version +
                '}';
    }
}
