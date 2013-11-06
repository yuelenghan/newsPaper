package com.ghtn.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-6
 * Time: 上午10:49
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "t_news_type")
public class NewsType implements Serializable {
    private Long id;
    private String name;
    private Tenant tenant;
    private String ext1;
    private String ext2;
    private String ext3;

    private Set<NewsPaper> newsPaperSet;
    private Set<SubscribeList> subscribeListSet;
    private Set<Template> templateSet;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "tenantId")
    public Tenant getTenant() {
        return tenant;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public String getExt1() {
        return ext1;
    }

    public void setExt1(String ext1) {
        this.ext1 = ext1;
    }

    public String getExt2() {
        return ext2;
    }

    public void setExt2(String ext2) {
        this.ext2 = ext2;
    }

    public String getExt3() {
        return ext3;
    }

    public void setExt3(String ext3) {
        this.ext3 = ext3;
    }

    @OneToMany(mappedBy = "newsType", cascade = CascadeType.ALL)
    public Set<NewsPaper> getNewsPaperSet() {
        return newsPaperSet;
    }

    public void setNewsPaperSet(Set<NewsPaper> newsPaperSet) {
        this.newsPaperSet = newsPaperSet;
    }

    @OneToMany(mappedBy = "newsType", cascade = CascadeType.ALL)
    public Set<SubscribeList> getSubscribeListSet() {
        return subscribeListSet;
    }

    public void setSubscribeListSet(Set<SubscribeList> subscribeListSet) {
        this.subscribeListSet = subscribeListSet;
    }

    @OneToMany(mappedBy = "newsType", cascade = CascadeType.ALL)
    public Set<Template> getTemplateSet() {
        return templateSet;
    }

    public void setTemplateSet(Set<Template> templateSet) {
        this.templateSet = templateSet;
    }
}
