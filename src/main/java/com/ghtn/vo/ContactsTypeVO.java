package com.ghtn.vo;

import java.util.List;

/**
 * 通讯录类别vo, 树形结构
 * User: Administrator
 * Date: 13-12-3
 * Time: 下午3:39
 */
public class ContactsTypeVO {
    private Long id; //主键
    private String text; //树形节点名称
    private Boolean leaf; //是否叶子节点, 叶子:true, 非叶子:false
    private Boolean expanded; //是否展开, 展开:true, 不展开:false
    private List<ContactsTypeVO> children; //子节点

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public Boolean getExpanded() {
        return expanded;
    }

    public void setExpanded(Boolean expanded) {
        this.expanded = expanded;
    }

    public List<ContactsTypeVO> getChildren() {
        return children;
    }

    public void setChildren(List<ContactsTypeVO> children) {
        this.children = children;
    }
}
