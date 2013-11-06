package com.ghtn.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-6
 * Time: 上午10:21
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "t_dictionary")
public class Dictionary implements Serializable {
    private Long id;
    private Double globalPrice;
    private String ext1;
    private String ext2;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getGlobalPrice() {
        return globalPrice;
    }

    public void setGlobalPrice(Double globalPrice) {
        this.globalPrice = globalPrice;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }
}
