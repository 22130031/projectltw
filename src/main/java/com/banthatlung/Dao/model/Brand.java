package com.banthatlung.Dao.model;

import java.sql.Date;

public class Brand {
    private int id;
    private String name;
    private Date createAt;

    public Brand(int id,String name, Date createAt) {
        this.name = name;
        this.createAt = createAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }
}
