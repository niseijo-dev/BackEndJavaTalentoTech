package service;

import model.Pedido;
import model.LineaPedido;
import model.Producto;
import exception.StockInsuficienteException;
import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    private List<Pedido> listaPedidos;
    private int contadorIds = 1;

    public PedidoService() {
        this.listaPedidos = new ArrayList<>();
    }

    public void crearPedido(List<LineaPedido> lineas) {
        if (lineas == null || lineas.isEmpty()) {
            throw new IllegalArgumentException("El pedido no puede estar vacío.");
        }
        
        for (LineaPedido lineaPed : lineas) {
            Producto prod = lineaPed.getProducto();
            if (prod.getStock() < lineaPed.getCantidad()) {
                throw new StockInsuficienteException("Stock insuficiente para: " + prod.getNombre() + ". \nDisponible: [ " + prod.getStock() + " ]");
            }
        }
        
        for (LineaPedido lineaPed : lineas) {
            Producto prod = lineaPed.getProducto();
            prod.setStock(prod.getStock() - lineaPed.getCantidad());
        }
        
        Pedido nuevoPed = new Pedido(this.contadorIds, lineas);
        this.listaPedidos.add(nuevoPed);
        this.contadorIds++;
    }

    public List<Pedido> leerPedidos() {
        return this.listaPedidos;
    }
}