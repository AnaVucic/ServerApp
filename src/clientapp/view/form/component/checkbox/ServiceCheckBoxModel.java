/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clientapp.view.form.component.checkbox;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author Lenovo
 */
public class ServiceCheckBoxModel {
    
    private Long id;
    private String name;
    private BigDecimal fee;
    private int duration;

    public ServiceCheckBoxModel() {
    }

    public ServiceCheckBoxModel(Long id, String name, BigDecimal fee, int duration) {
        this.id = id;
        this.name = name;
        this.fee = fee;
        this.duration = duration;
    }

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

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.name);
        hash = 79 * hash + Objects.hashCode(this.fee);
        hash = 79 * hash + this.duration;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ServiceCheckBoxModel other = (ServiceCheckBoxModel) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "ServiceCheckBoxModel{" + "id=" + id + ", name=" + name + ", fee=" + fee + ", duration=" + duration + '}';
    }
    
    
    
}
