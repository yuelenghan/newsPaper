package com.ghtn.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 素材实体类
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-6
 * Time: 上午10:35
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "t_material")
public class Material implements Serializable {
    private Long id; //主键
    private MaterialType materialType; //素材类别
    private String title; //素材标题
    private String type; //素材类型, 文本或图片
    private String text; //文本素材的文本内容
    private String image; //图片素材的图片路径
    private Tenant tenant; //租户
    private Material parent; //父节点

    //关系映射
    private List<Material> children; //子节点
    private List<Tag> tagList; //标签

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "materialTypeId")
    public MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(MaterialType materialType) {
        this.materialType = materialType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
    @JoinColumn(name = "parentId")
    public Material getParent() {
        return parent;
    }

    public void setParent(Material parent) {
        this.parent = parent;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    public List<Material> getChildren() {
        return children;
    }

    public void setChildren(List<Material> children) {
        this.children = children;
    }

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "t_material_tag",
            joinColumns = {@JoinColumn(name = "materialId")},
            inverseJoinColumns = {@JoinColumn(name = "tagId")})
    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }
}
