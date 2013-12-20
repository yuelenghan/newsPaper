package com.ghtn.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 素材类别实体类
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-6
 * Time: 上午10:29
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "t_material_type")
public class MaterialType implements Serializable {
    private Long id;    //主键
    private String name;    //类别名称
    private Tenant tenant;  //租户

    //关系映射
    private List<Material> materialList; //素材集合

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

    @OneToMany(mappedBy = "materialType", cascade = CascadeType.ALL)
    public List<Material> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<Material> materialList) {
        this.materialList = materialList;
    }
}
