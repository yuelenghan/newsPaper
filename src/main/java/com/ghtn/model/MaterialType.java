package com.ghtn.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Administrator
 * Date: 13-11-6
 * Time: 上午10:29
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "t_material_type")
public class MaterialType implements Serializable {
    private Long id;
    private String name;
    private Tenant tenant;

    private Set<Material> materialSet;

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
    public Set<Material> getMaterialSet() {
        return materialSet;
    }

    public void setMaterialSet(Set<Material> materialSet) {
        this.materialSet = materialSet;
    }
}
