package com.ghtn.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-6
 * Time: 上午10:55
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "t_subscribe_list")
public class SubscribeList implements Serializable {
    private Long id;
    private Tenant tenant;
    private NewsType newsType;
    private NewsPaper newsPaper;
    private Date subscribeTime;
    private boolean unsubscribe;
    private Date unsubscribeTime;

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

    @ManyToOne
    @JoinColumn(name = "newsTypeId")
    public NewsType getNewsType() {
        return newsType;
    }

    public void setNewsType(NewsType newsType) {
        this.newsType = newsType;
    }

    @ManyToOne
    @JoinColumn(name = "newsPaperId")
    public NewsPaper getNewsPaper() {
        return newsPaper;
    }

    public void setNewsPaper(NewsPaper newsPaper) {
        this.newsPaper = newsPaper;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Date subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    @Type(type = "yes_no")
    public boolean isUnsubscribe() {
        return unsubscribe;
    }

    public void setUnsubscribe(boolean unsubscribe) {
        this.unsubscribe = unsubscribe;
    }

    @Temporal(TemporalType.TIMESTAMP)
    public Date getUnsubscribeTime() {
        return unsubscribeTime;
    }

    public void setUnsubscribeTime(Date unsubscribeTime) {
        this.unsubscribeTime = unsubscribeTime;
    }
}
