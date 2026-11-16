package com.foodpacking.foodpackingentidades;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empaque")
public class Empaque implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpaque;
    
    private String tipoMaterial;
    private Double capacidadKg;
    private String temperaturaConservacion;

    public Empaque() {
    }

    public Empaque(String tipoMaterial, Double capacidadKg, String temperaturaConservacion) {
        this.tipoMaterial = tipoMaterial;
        this.capacidadKg = capacidadKg;
        this.temperaturaConservacion = temperaturaConservacion;
    }

    public Long getIdEmpaque() {
        return idEmpaque;
    }

    public void setIdEmpaque(Long idEmpaque) {
        this.idEmpaque = idEmpaque;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public Double getCapacidadKg() {
        return capacidadKg;
    }

    public void setCapacidadKg(Double capacidadKg) {
        this.capacidadKg = capacidadKg;
    }

    public String getTemperaturaConservacion() {
        return temperaturaConservacion;
    }

    public void setTemperaturaConservacion(String temperaturaConservacion) {
        this.temperaturaConservacion = temperaturaConservacion;
    }
}