package com.ghtn.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-6
 * Time: 上午10:27
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "t_frame_temp")
public class FrameTemp implements Serializable {
    private Long id;
    private NewsPaper newsPaper;
    private Template template;
    private Frame frame;
    private Date tempTime;
    private String text;
    private String image;
    private String format;
    private Integer tempIndex;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "newsPaperId")
    public NewsPaper getNewsPaper() {
        return newsPaper;
    }

    public void setNewsPaper(NewsPaper newsPaper) {
        this.newsPaper = newsPaper;
    }

    @ManyToOne
    @JoinColumn(name = "templateId")
    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    @ManyToOne
    @JoinColumn(name = "frameId")
    public Frame getFrame() {
        return frame;
    }

    public void setFrame(Frame frame) {
        this.frame = frame;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getTempTime() {
        return tempTime;
    }

    public void setTempTime(Date tempTime) {
        this.tempTime = tempTime;
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

    public Integer getTempIndex() {
        return tempIndex;
    }

    public void setTempIndex(Integer tempIndex) {
        this.tempIndex = tempIndex;
    }
}
