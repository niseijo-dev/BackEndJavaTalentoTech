package model;

public class Producto {
    /// Atributos
    private final int id;
    private String nombre;
    private double precio;
    private int stock;

    /// Constructores
    public Producto(int id, String nombre, double precio, int stock){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    /// Métodos
    // Getters
    public int getID(){return this.id;}
    public String getNombre(){return this.nombre;}
    public double getPrecio(){return this.precio;}
    public int getStock(){return this.stock;}

    // Setters
    public void setNombre(String nombre){this.nombre = nombre;}
    public void setPrecio(double precio){this.precio = stock;}
    public void setStock(int stock){this.stock = stock;}

    @Override
    public String toString(){
        return "PRODUCTO: " + id + "\nNOMBRE: " + nombre + "\nPRECIO: " + precio + "\nSTOCK: " + stock;
    }

}
