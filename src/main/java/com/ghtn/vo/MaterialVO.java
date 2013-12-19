package com.ghtn.vo;

/**
 * User: Administrator
 * Date: 13-11-28
 * Time: 上午10:26
 */
public class MaterialVO {
    private Long id;
    private String title;
    private String type;
    private String text;
    private String image;
    private Long[] tagIds;
    private String[] tagNames;
    private String tagNameStr;
    private Long materialTypeId;
    private String materialTypeName;
    private Long parentId;
    private String parentTitle;
    private Long[] childIds;
    private String[] childTitle;
    private String[] childPath;
    private Integer childCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long[] getTagIds() {
        return tagIds;
    }

    public void setTagIds(Long[] tagIds) {
        this.tagIds = tagIds;
    }

    public String getParentTitle() {
        return parentTitle;
    }

    public void setParentTitle(String parentTitle) {
        this.parentTitle = parentTitle;
    }

    public String[] getChildTitle() {
        return childTitle;
    }

    public void setChildTitle(String[] childTitle) {
        this.childTitle = childTitle;
    }

    public String[] getChildPath() {
        return childPath;
    }

    public void setChildPath(String[] childPath) {
        this.childPath = childPath;
    }

    public Integer getChildCount() {
        return childCount;
    }

    public void setChildCount(Integer childCount) {
        this.childCount = childCount;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long[] getChildIds() {
        return childIds;
    }

    public void setChildIds(Long[] childIds) {
        this.childIds = childIds;
    }

    public Long getMaterialTypeId() {
        return materialTypeId;
    }

    public void setMaterialTypeId(Long materialTypeId) {
        this.materialTypeId = materialTypeId;
    }

    public String[] getTagNames() {
        return tagNames;
    }

    public void setTagNames(String[] tagNames) {
        this.tagNames = tagNames;
    }

    public String getTagNameStr() {
        return tagNameStr;
    }

    public void setTagNameStr(String tagNameStr) {
        this.tagNameStr = tagNameStr;
    }

    public String getMaterialTypeName() {
        return materialTypeName;
    }

    public void setMaterialTypeName(String materialTypeName) {
        this.materialTypeName = materialTypeName;
    }
}
