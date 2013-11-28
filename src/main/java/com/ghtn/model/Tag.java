package com.ghtn.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-6
 * Time: 上午11:08
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "t_tag")
public class Tag implements Serializable {
    private Long id;
    private String name;
    private Tenant tenant;

    private Set<Frame> frameSet;
    private Set<Material> materialSet;
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

    @ManyToOne
    @JoinColumn(name = "tenantId")
    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    @ManyToMany(mappedBy = "tagSet", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    public Set<Frame> getFrameSet() {
        return frameSet;
    }

    public void setFrameSet(Set<Frame> frameSet) {
        this.frameSet = frameSet;
    }

    @ManyToMany(mappedBy = "tagList", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    public Set<Material> getMaterialSet() {
        return materialSet;
    }

    public void setMaterialSet(Set<Material> materialSet) {
        this.materialSet = materialSet;
    }

    @ManyToMany(mappedBy = "tagSet", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    public Set<Template> getTemplateSet() {
        return templateSet;
    }

    public void setTemplateSet(Set<Template> templateSet) {
        this.templateSet = templateSet;
    }
}
