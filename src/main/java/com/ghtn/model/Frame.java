package com.ghtn.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-6
 * Time: 上午10:25
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "t_frame")
public class Frame implements Serializable {
    private Long id;
    private Tenant tenant;
    private String text;
    private String image;
    private String format;

    private Set<Tag> tagSet;
    private Set<FrameTemp> frameTempSet;
    private Set<TemplateFrame> templateFrameSet;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "tenantId")
    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
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

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinTable(name = "t_tag_frame",
            joinColumns = {@JoinColumn(name = "frameId")},
            inverseJoinColumns = {@JoinColumn(name = "tagId")})
    public Set<Tag> getTagSet() {
        return tagSet;
    }

    public void setTagSet(Set<Tag> tagSet) {
        this.tagSet = tagSet;
    }

    @OneToMany(mappedBy = "frame", cascade = CascadeType.ALL)
    public Set<FrameTemp> getFrameTempSet() {
        return frameTempSet;
    }

    public void setFrameTempSet(Set<FrameTemp> frameTempSet) {
        this.frameTempSet = frameTempSet;
    }

    @OneToMany(mappedBy = "frame", cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
    public Set<TemplateFrame> getTemplateFrameSet() {
        return templateFrameSet;
    }

    public void setTemplateFrameSet(Set<TemplateFrame> templateFrameSet) {
        this.templateFrameSet = templateFrameSet;
    }
}
