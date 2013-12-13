package com.ghtn.vo;

/**
 * User: Administrator
 * Date: 13-11-27
 * Time: 下午4:49
 */
public class TagVO {
    private Long id;
    private String text;
    private Boolean leaf;

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

}
