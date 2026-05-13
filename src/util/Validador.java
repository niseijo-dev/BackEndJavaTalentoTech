package util;

public class Validador {
    public static void validarPrecio(double precio){
        if (precio < 0){
            throw new IllegalArgumentException("El precio del producto debe ser mayor a 0");
        }
    }
    public static void validarStock(int stock){
        if (stock < 0){
            throw new IllegalArgumentException("El stock del producto debe ser mayor a 0");
        }
    }
    public static void validarNombre(String nombre){
        if (nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }

    public static void validarProducto(String nombre, double precio, int stock){
        validarNombre(nombre);
        validarPrecio(precio);
        validarStock(stock);
    }
}
