package com.ghtn.vo;

import java.util.List;

/**
 * User: Administrator
 * Date: 13-12-3
 * Time: 下午3:39
 */
public class ContactsTypeVO {
    private Long id;
    private String text;
    private Boolean leaf;
    private Boolean expanded;
    private List<ContactsTypeVO> children;

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
