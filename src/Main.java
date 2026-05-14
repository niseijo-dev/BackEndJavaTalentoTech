import service.PedidoService;
import service.ProductoService;
import ui.MenuProducto;

public class Main {
    public static void main(String[] args) {
        ProductoService prodServ = new ProductoService();
        PedidoService pedServ = new PedidoService();
        MenuProducto menu = new MenuProducto(prodServ, pedServ);

        menu.iniciar();
    }
}