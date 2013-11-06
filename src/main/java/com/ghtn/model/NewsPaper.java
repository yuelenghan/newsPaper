package com.ghtn.model;//package com.ghtn.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-6
 * Time: 上午9:15
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "t_news_paper")
public class NewsPaper implements Serializable {
    private Long id;
    private String title; //标题
    private String content; //内容
    private String contentShort; //内容简介
    private Date sendTime; //发送时间
    private String status; // 状态
    private Tenant tenant;
    private NewsType newsType;
    private String sendType;

    private Set<FrameTemp> frameTempSet;
    private Set<SubscribeList> subscribeListSet;

    @Id
    @GeneratedValue
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentShort() {
        return contentShort;
    }

    public void setContentShort(String contentShort) {
        this.contentShort = contentShort;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
    @JoinColumn(name = "newsTypeId")
    public NewsType getNewsType() {
        return newsType;
    }

    public void setNewsType(NewsType newsType) {
        this.newsType = newsType;
    }

    public String getSendType() {
        return sendType;
    }

    public void setSendType(String sendType) {
        this.sendType = sendType;
    }

    @OneToMany(mappedBy = "newsPaper", cascade = CascadeType.ALL)
    public Set<FrameTemp> getFrameTempSet() {
        return frameTempSet;
    }

    public void setFrameTempSet(Set<FrameTemp> frameTempSet) {
        this.frameTempSet = frameTempSet;
    }

    @OneToMany(mappedBy = "newsPaper", cascade = CascadeType.ALL)
    public Set<SubscribeList> getSubscribeListSet() {
        return subscribeListSet;
    }

    public void setSubscribeListSet(Set<SubscribeList> subscribeListSet) {
        this.subscribeListSet = subscribeListSet;
    }
}
