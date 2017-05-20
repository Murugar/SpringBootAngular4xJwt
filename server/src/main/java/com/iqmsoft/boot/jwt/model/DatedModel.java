package com.iqmsoft.boot.jwt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.joda.time.DateTime;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.io.Serializable;


@MappedSuperclass
public class DatedModel implements Serializable {

    @Column( name = "created_at" )
    private DateTime createdAt;

    @Column( name = "updated_at" )
    private DateTime updatedAt;

    public DatedModel() {
    }

    @JsonIgnore
    public DateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt( DateTime createdAt ) {
        this.createdAt = createdAt;
    }

    @JsonIgnore
    public DateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt( DateTime updatedAt ) {
        this.updatedAt = updatedAt;
    }

    @PrePersist
    @PreUpdate
    public void preSave() {
        preSaveImpl();
    }

    protected void preSaveImpl() {
        DateTime now = new DateTime();
        if ( getCreatedAt() == null ) {
            setCreatedAt( now );
        }
        setUpdatedAt( now );
    }

}
