package ui;

import model.LineaPedido;
import model.Pedido;
import model.Producto;
import service.PedidoService;
import service.ProductoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuProducto {
    private Scanner scanner;
    private ProductoService prodServ;
    private PedidoService pedServ;

    public MenuProducto(ProductoService prodServ, PedidoService pedServ){
        this.prodServ = prodServ;
        this.pedServ = pedServ;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar(){
        int opcion = -1;
        do{
            try{
                System.out.println("--- MENÚ PRODUCTOS ---");
                System.out.println("[1]: Agregar Producto");
                System.out.println("[2]: Listar Productos");
                System.out.println("[3]: Actualizar Producto");
                System.out.println("[4]: Eliminar Producto");
                System.out.println("[5]: Crear Pedido");
                System.out.println("[6]: Listar Pedidos");
                System.out.println("[0]: Salir");
                System.out.println("Ingrese la opción deseada:");
                opcion = Integer.parseInt(scanner.nextLine());
                procesarOpcion(opcion);
            } catch (NumberFormatException e) {System.out.println("Error: Por favor, ingrese un número válido.");}
            catch (Exception e) {System.out.println("Error: " + e.getMessage());}
        } while (opcion != 0);
    }

    public void procesarOpcion(int opcion){
        switch (opcion) {
            case 1: procesarAgregarProd();
                break;
            case 2: listarProds();
                break;
            case 3: procesarActualizarProd();
                break;
            case 4: procesarEliminarProd();
                break;
            case 5: procesarCrearPed();
                break;
            case 6: listarPeds();
            case 0: System.out.println("-- Gracias por usar el gestor de Pedidos y Productos --");
        }
    }

    public void procesarAgregarProd(){
        System.out.println("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese precio: ");
        double precio = Double.parseDouble(scanner.nextLine());
        System.out.println("Ingrese stock: ");
        int stock = Integer.parseInt(scanner.nextLine());

        prodServ.agregarProducto(nombre, precio, stock);
        System.out.println("Producto ingresado correctamente");
    }

    public void listarProds(){
        for (Producto prod : prodServ.leerProductos()){
            System.out.println(prod);
        }
    }

    public void procesarActualizarProd(){
        System.out.println("Ingrese ID del producto a modificar: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Ingrese el nuevo nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el nuevo precio del producto: ");
        double precio = Double.parseDouble(scanner.nextLine());
        System.out.println("Ingrese el nuevo stock del producto: ");
        int stock = Integer.parseInt(scanner.nextLine());

        prodServ.modificarProducto(id, nombre, precio, stock);
    }

    public void procesarEliminarProd(){
        System.out.println("Ingrese el ID del producto a eliminar: ");
        int id = Integer.parseInt(scanner.nextLine());
        prodServ.eliminarProducto(id);
    }

    public void procesarCrearPed(){
        List<LineaPedido> lineasPed = new ArrayList<>();
        int opcion = 1;

        while(opcion != 0){
            System.out.println("Ingrese el ID del producto a agregar al pedido: ");
            Producto prod = prodServ.buscarProducto(Integer.parseInt(scanner.nextLine()));
            System.out.println("Ingrese la cantidad a pedir: ");
            LineaPedido lineaPed = new LineaPedido(prod, Integer.parseInt(scanner.nextLine()));
            lineasPed.add(lineaPed);

            System.out.println("Ingrese 1 para agregar más productos, o 0 para finalizar: ");
            opcion = Integer.parseInt(scanner.nextLine());
        }

        pedServ.crearPedido(lineasPed);
    }
    public void listarPeds(){
        for (Pedido ped : pedServ.leerPedidos()){
            System.out.println("PEDIDO: " + ped.getId());
            System.out.println("DETALLE:");
            for (LineaPedido lineaPed : ped.getLineas()){
                System.out.println("- " + lineaPed);
            }
            System.out.println("TOTAL: $" + ped.getTotal());
        }
    }

}
