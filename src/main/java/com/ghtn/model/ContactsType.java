package com.ghtn.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-6
 * Time: 上午11:22
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "t_contacts_type")
public class ContactsType implements Serializable {
    private Long id;
    private Tenant tenant;
    private String name;
    private String ext1;
    private String ext2;
    private String ext3;
    private String ext4;
    private String ext5;

    private Set<Contacts> contactsSet;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "tenantId")
    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    public String getExt4() {
        return ext4;
    }

    public void setExt4(String ext4) {
        this.ext4 = ext4;
    }

    public String getExt5() {
        return ext5;
    }

    public void setExt5(String ext5) {
        this.ext5 = ext5;
    }

    @OneToMany(mappedBy = "contactsType", cascade = CascadeType.ALL)
    public Set<Contacts> getContactsSet() {
        return contactsSet;
    }

    public void setContactsSet(Set<Contacts> contactsSet) {
        this.contactsSet = contactsSet;
    }
}
