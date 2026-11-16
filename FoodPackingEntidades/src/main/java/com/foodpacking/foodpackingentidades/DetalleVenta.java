package com.foodpacking.foodpackingentidades;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_venta")
public class DetalleVenta implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalle;
    
    private Double cantidadKg;
    private Double precioUnitario;
    private Double subtotalLinea;

    // Relación: Muchos detalles pertenecen a una sola venta (factura)
    @ManyToOne
    private Venta venta;

    // Relación: Un detalle apunta a un producto cárnico específico
    @ManyToOne
    private ProductoCarnico productoCarnico;

    public DetalleVenta() {
    }

    public Long getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(Long idDetalle) {
        this.idDetalle = idDetalle;
    }

    public Double getCantidadKg() {
        return cantidadKg;
    }

    public void setCantidadKg(Double cantidadKg) {
        this.cantidadKg = cantidadKg;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getSubtotalLinea() {
        return subtotalLinea;
    }

    public void setSubtotalLinea(Double subtotalLinea) {
        this.subtotalLinea = subtotalLinea;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public ProductoCarnico getProductoCarnico() {
        return productoCarnico;
    }

    public void setProductoCarnico(ProductoCarnico productoCarnico) {
        this.productoCarnico = productoCarnico;
    }
}