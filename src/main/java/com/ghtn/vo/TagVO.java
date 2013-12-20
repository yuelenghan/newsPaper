package com.ghtn.vo;

/**
 * 标签vo
 * User: Administrator
 * Date: 13-11-27
 * Time: 下午4:49
 */
public class TagVO {
    private Long id;    //主键
    private String text;    //树形结构的节点名称
    private Boolean leaf;   //是否叶子节点, 叶子:true, 非叶子:false

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
