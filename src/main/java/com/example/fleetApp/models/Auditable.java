package com.example.fleetApp.models;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Auditable<T> {
    @CreatedBy
    public T createdBy;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    public Date createdOn;

    @LastModifiedBy
    public T modifiedBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    public Date modifiedOn;

    public T getCreatedBy() {
        return createdBy;
    }

    public Auditable<T> setCreatedBy(T createdBy) {
        this.createdBy = createdBy;
        return this;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public Auditable<T> setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    public T getModifiedBy() {
        return modifiedBy;
    }

    public Auditable<T> setModifiedBy(T modifiedBy) {
        this.modifiedBy = modifiedBy;
        return this;
    }

    public Date getModifiedOn() {
        return modifiedOn;
    }

    public Auditable<T> setModifiedOn(Date modifiedOn) {
        this.modifiedOn = modifiedOn;
        return this;
    }
}
