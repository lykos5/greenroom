package com.lykos.mvcapi.po;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zw on 15/9/10.
 */
@Entity
@Table(name = "user")
public class TUserEntity implements Serializable{
    private long id;
    private String name;


    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = false, insertable = true, updatable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
