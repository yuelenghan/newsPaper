package com.ghtn.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-6
 * Time: 上午11:13
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "t_template_frame")
public class TemplateFrame implements Serializable {
    private Long id;
    private Frame frame;
    private Template template;
    private Integer frameIndex;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "frameId")
    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    @ManyToOne
    @JoinColumn(name = "templateId")
    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public Integer getFrameIndex() {
        return frameIndex;
    }

    public void setFrameIndex(Integer frameIndex) {
        this.frameIndex = frameIndex;
    }
}
