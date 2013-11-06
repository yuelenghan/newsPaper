package com.ghtn.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-6
 * Time: 上午9:23
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "t_tenant")
public class Tenant implements Serializable {
    private Long id;
    private String name; //姓名
    private String type; //租户类型
    private String password; //密码
    private String idCard; //身份证号
    private String phone; //手机号
    private String email; //邮箱
    private String sex; //性别
    private Integer age; //年龄
    private String industry; //行业
    private String education; //学历
    private String unit; //单位
    private String unitType; //单位类型
    private String duty; //职务
    private String tenantType; //租户类别
    private Double balance; //余额
    private Date rdate; //注册时间
    private String ext1; //扩展字段1
    private String ext2; //扩展字段2

    private Set<ContactsType> contactsTypeSet;
    private Set<Contacts> contactsSet;
    private Set<Favorite> favoriteSet;
    private Set<Frame> frameSet;
    private Set<Material> materialSet;
    private Set<MaterialType> materialTypeSet;
    private Set<NewsPaper> newsPaperSet;
    private Set<NewsType> newsTypeSet;
    private Set<SubscribeList> subscribeListSet;
    private Set<Tag> tagSet;
    private Set<Template> templateSet;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getUnitType() {
        return unitType;
    }

    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getTenantType() {
        return tenantType;
    }

    public void setTenantType(String tenantType) {
        this.tenantType = tenantType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    public Date getRdate() {
        return rdate;
    }

    public void setRdate(Date rdate) {
        this.rdate = rdate;
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

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    public Set<ContactsType> getContactsTypeSet() {
        return contactsTypeSet;
    }

    public void setContactsTypeSet(Set<ContactsType> contactsTypeSet) {
        this.contactsTypeSet = contactsTypeSet;
    }

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    public Set<Contacts> getContactsSet() {
        return contactsSet;
    }

    public void setContactsSet(Set<Contacts> contactsSet) {
        this.contactsSet = contactsSet;
    }

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    public Set<Favorite> getFavoriteSet() {
        return favoriteSet;
    }

    public void setFavoriteSet(Set<Favorite> favoriteSet) {
        this.favoriteSet = favoriteSet;
    }

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    public Set<Frame> getFrameSet() {
        return frameSet;
    }

    public void setFrameSet(Set<Frame> frameSet) {
        this.frameSet = frameSet;
    }

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    public Set<Material> getMaterialSet() {
        return materialSet;
    }

    public void setMaterialSet(Set<Material> materialSet) {
        this.materialSet = materialSet;
    }

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    public Set<MaterialType> getMaterialTypeSet() {
        return materialTypeSet;
    }

    public void setMaterialTypeSet(Set<MaterialType> materialTypeSet) {
        this.materialTypeSet = materialTypeSet;
    }

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    public Set<NewsPaper> getNewsPaperSet() {
        return newsPaperSet;
    }

    public void setNewsPaperSet(Set<NewsPaper> newsPaperSet) {
        this.newsPaperSet = newsPaperSet;
    }

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    public Set<NewsType> getNewsTypeSet() {
        return newsTypeSet;
    }

    public void setNewsTypeSet(Set<NewsType> newsTypeSet) {
        this.newsTypeSet = newsTypeSet;
    }

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    public Set<SubscribeList> getSubscribeListSet() {
        return subscribeListSet;
    }

    public void setSubscribeListSet(Set<SubscribeList> subscribeListSet) {
        this.subscribeListSet = subscribeListSet;
    }

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    public Set<Tag> getTagSet() {
        return tagSet;
    }

    public void setTagSet(Set<Tag> tagSet) {
        this.tagSet = tagSet;
    }

    @OneToMany(mappedBy = "tenant", cascade = CascadeType.ALL)
    public Set<Template> getTemplateSet() {
        return templateSet;
    }

    public void setTemplateSet(Set<Template> templateSet) {
        this.templateSet = templateSet;
    }
}
