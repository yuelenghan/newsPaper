package com.ghtn.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

/**
 * 标签的实体类
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-6
 * Time: 上午11:08
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "t_tag")
public class Tag implements Serializable {
    private Long id; //主键
    private String name; //标签名称
    private Tenant tenant; //租户

    //关系映射
    private Set<Frame> frameSet; //帧集合
    private List<Material> materialList; //素材集合
    private Set<Template> templateSet; //模板集合

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

    @ManyToMany(mappedBy = "tagList", fetch = FetchType.LAZY)
    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
    }

    @ManyToMany(mappedBy = "tagSet", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    public Set<Template> getTemplateSet() {
        return templateSet;
    }

    public void setTemplateSet(Set<Template> templateSet) {
        this.templateSet = templateSet;
    }
}
