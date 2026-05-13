package model;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock){
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public int getID(){return this.id;}
    public String getNombre(){return this.nombre;}
    public double getPrecio(){return this.precio;}
    public int getStock(){return this.stock;}

}
