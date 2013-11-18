package com.ghtn.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.Cache;
import org.hibernate.type.YesNoType;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;
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
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ContactsType implements Serializable {
    private Long id;
    private Tenant tenant;
    private String name;
    private ContactsType parent;
    private Boolean root;
    private Boolean leaf;
    private String pathId;
    private String pathName;

    private List<ContactsType> children;
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

    @ManyToOne
    @JoinColumn(name = "parentId")
    public ContactsType getParent() {
        return parent;
    }

    public void setParent(ContactsType parent) {
        this.parent = parent;
    }

    @OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE)
    @OrderBy("id")
    public List<ContactsType> getChildren() {
        return children;
    }

    public void setChildren(List<ContactsType> children) {
        this.children = children;
    }

    @OneToMany(mappedBy = "contactsType", cascade = CascadeType.ALL)
    public Set<Contacts> getContactsSet() {
        return contactsSet;
    }

    public void setContactsSet(Set<Contacts> contactsSet) {
        this.contactsSet = contactsSet;
    }

    @Type(type = "yes_no")
    public Boolean getRoot() {
        return root;
    }

    public void setRoot(Boolean root) {
        this.root = root;
    }

    @Type(type = "yes_no")
    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public String getPathId() {
        return pathId;
    }

    public void setPathId(String pathId) {
        this.pathId = pathId;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }
}
