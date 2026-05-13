package service;

import exception.ProductoNoEncontradoException;
import model.Producto;
import util.Validador;

import java.util.ArrayList;
import java.util.List;

public class ProductoService {
    /// Atributos
    private List<Producto> listaProductos;
    private int contadorIds = 1;

    /// Constructores
    public ProductoService(){
        this.listaProductos = new ArrayList<>();
    }

    /// Metodos
    public void agregarProducto(String nombre, double precio, int stock){
        Validador.validarProducto(nombre, precio, stock);

        Producto nuevoProd = new Producto(this.contadorIds, nombre, precio, stock);
        this.listaProductos.add(nuevoProd);
        this.contadorIds+=1;
    }

    public List<Producto> leerProductos(){return this.listaProductos;}
    public Producto buscarProducto(int idBuscado){
        for (Producto prod : listaProductos){
            // Busca el producto por ID, si lo encuentra lo retorna
            if (prod.getID() == idBuscado){return prod;}
        }
        // Si no encuentra el producto, tira excepción
        throw new ProductoNoEncontradoException("Producto no encontrado en la Lista de Productos");
    }
    public void modificarProducto(int idBuscado, String newNombre, double newPrecio, int newStock){
        Producto prodModif = buscarProducto(idBuscado);
        Validador.validarProducto(newNombre, newPrecio, newStock);

        prodModif.setNombre(newNombre);
        prodModif.setPrecio(newPrecio);
        prodModif.setStock(newStock);

    }
    public Producto eliminarProducto(int idBuscado){
        Producto prodElim = buscarProducto(idBuscado);
        listaProductos.remove(prodElim);

        return prodElim;
    }
}
