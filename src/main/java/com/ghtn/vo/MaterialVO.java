package com.ghtn.vo;

/**
 * 素材vo
 * User: Administrator
 * Date: 13-11-28
 * Time: 上午10:26
 */
public class MaterialVO {
    private Long id;    //主键
    private String title;   //标题
    private String type;    //素材类型, 文本或图片
    private String text;    //文本素材的文本内容
    private String image;   //图片素材的图片路径
    private Long[] tagIds;  //标签id数组
    private String[] tagNames;  //标签名称数组
    private String tagNameStr;  //标签名称数组的字符串, ","分割
    private Long materialTypeId;    //素材类别id
    private String materialTypeName;    //素材类别名称
    private Long parentId;  //父节点id
    private String parentTitle; //父节点标题
    private Long[] childIds;    //子节点id数组(只有文本素材才有子节点)
    private String[] childTitle;    //子节点标题数组
    private String[] childPath; //子节点的图片路径数组
    private Integer childCount; //子节点的个数

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
