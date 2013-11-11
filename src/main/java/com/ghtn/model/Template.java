package com.ghtn.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-6
 * Time: 上午11:11
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "t_template")
public class Template implements Serializable {
    private Long id;
    private String name;
    private Tenant tenant;
    private NewsType newsType;

    private Set<FrameTemp> frameTempSet;
    private List<TemplateFrame> templateFrameList;
    private Set<Tag> tagSet;

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

    @ManyToOne
    @JoinColumn(name = "tenantId")
    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @ManyToOne
    @JoinColumn(name = "newsTypeId")
    public NewsType getNewsType() {
        return newsType;
    }

    public void setNewsType(NewsType newsType) {
        this.newsType = newsType;
    }

    @OneToMany(mappedBy = "template", cascade = CascadeType.ALL)
    public Set<FrameTemp> getFrameTempSet() {
        return frameTempSet;
    }

    public void setFrameTempSet(Set<FrameTemp> frameTempSet) {
        this.frameTempSet = frameTempSet;
    }

    @OneToMany(mappedBy = "template", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @OrderBy("frameIndex")
    public List<TemplateFrame> getTemplateFrameList() {
        return templateFrameList;
    }

    public void setTemplateFrameList(List<TemplateFrame> templateFrameList) {
        this.templateFrameList = templateFrameList;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "t_template_tag",
            joinColumns = {@JoinColumn(name = "templateId")},
            inverseJoinColumns = {@JoinColumn(name = "tagId")})
    public Set<Tag> getTagSet() {
        return tagSet;
    }

    public void setTagSet(Set<Tag> tagSet) {
        this.tagSet = tagSet;
    }
}
