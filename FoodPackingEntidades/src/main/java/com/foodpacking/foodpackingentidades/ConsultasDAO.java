package com.foodpacking.foodpackingentidades;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

public class ConsultasDAO {

    // Necesitamos un EntityManager para interactuar con la base de datos
    private EntityManager em;

    public ConsultasDAO(EntityManager em) {
        this.em = em;
    }

    // ==========================================
    // CONSULTA 1: Productos por Categoría 
    // (Filtro por nombre de categoría, ordenado por precio ascendente, con paginación)
    // ==========================================
    public List<ProductoCarnico> obtenerProductosPorCategoria(String nombreCategoria, int inicio, int maximo) {
        String jpql = "SELECT p FROM ProductoCarnico p WHERE p.categoria.nombre = :nombreCat ORDER BY p.precioPorKg ASC";
        
        TypedQuery<ProductoCarnico> query = em.createQuery(jpql, ProductoCarnico.class);
        query.setParameter("nombreCat", nombreCategoria); // Filtro
        
        // Paginación
        query.setFirstResult(inicio); // Desde qué registro empieza (ej. 0)
        query.setMaxResults(maximo);  // Cuántos registros trae por página (ej. 5)
        
        return query.getResultList();
    }

    // ==========================================
    // CONSULTA 2: Historial de Ventas de un Cliente
    // (Filtro por cédula/RUC del cliente, ordenado por fecha descendente, con paginación)
    // ==========================================
    public List<Venta> obtenerVentasPorCliente(String cedulaCliente, int inicio, int maximo) {
        String jpql = "SELECT v FROM Venta v WHERE v.cliente.identificacion = :cedula ORDER BY v.fechaVenta DESC";
        
        TypedQuery<Venta> query = em.createQuery(jpql, Venta.class);
        query.setParameter("cedula", cedulaCliente); // Filtro
        
        // Paginación
        query.setFirstResult(inicio);
        query.setMaxResults(maximo);
        
        return query.getResultList();
    }

    // ==========================================
    // CONSULTA 3: Alerta de Stock Bajo
    // (Filtro por stock menor al límite, ordenado alfabéticamente por nombre, con paginación)
    // ==========================================
    public List<ProductoCarnico> obtenerProductosStockCritico(Double stockMinimo, int inicio, int maximo) {
        String jpql = "SELECT p FROM ProductoCarnico p WHERE p.stockKg < :minStock ORDER BY p.nombre ASC";
        
        TypedQuery<ProductoCarnico> query = em.createQuery(jpql, ProductoCarnico.class);
        query.setParameter("minStock", stockMinimo); // Filtro
        
        // Paginación
        query.setFirstResult(inicio);
        query.setMaxResults(maximo);
        
        return query.getResultList();
    }
}