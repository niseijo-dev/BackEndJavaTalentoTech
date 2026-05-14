package model;

import java.util.List;

public class Pedido {
    private int id;
    private List<LineaPedido> lineas;
    private double total;

    public Pedido(int id, List<LineaPedido> lineas) {
        this.id = id;
        this.lineas = lineas;
        this.total = calcularTotal(lineas);
    }

    private double calcularTotal(List<LineaPedido> lineas) {
        double suma = 0;
        for (LineaPedido lineaPed : lineas) {
            suma += lineaPed.getSubtotal();
        }
        return suma;
    }

    public int getId() { return id; }
    public List<LineaPedido> getLineas() { return lineas; }
    public double getTotal() { return total; }

    @Override
    public String toString() {
        return "PEDIDO: " + id + "\nTotal: $" + total + "\nArtículos: " + lineas.size();
    }
}