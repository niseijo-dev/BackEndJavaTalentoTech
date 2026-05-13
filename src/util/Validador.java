package util;

public class Validador {
    static void validarPrecio(double precio){
        if (precio < 0){
            throw new IllegalArgumentException("El precio del producto debe ser mayor a 0");
        }
    }
    static void validarStock(int stock){
        if (stock < 0){
            throw new IllegalArgumentException("El stock del producto debe ser mayor a 0");
        }
    }
    static void validarNombre(String nombre){
        if (nombre == null || nombre.isBlank()){
            throw new IllegalArgumentException("El nombre no puede estar vacío");
        }
    }
}
