package com.ghtn.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * 通讯录类别实体类
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
    private Long id; //主键
    private Tenant tenant; //租户
    private String name; //类别名称
    private ContactsType parent; //父节点
    private Boolean root; //是否根节点, 是:true, 否:false
    private Boolean leaf; //是否叶子节点, 是:true, 否:false
    private String pathId; //树形结构的id路径
    private String pathName; //树形结构的名称路径

    //关系映射
    private List<ContactsType> children; //子节点
    private Set<Contacts> contactsSet; //通讯录集合

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
