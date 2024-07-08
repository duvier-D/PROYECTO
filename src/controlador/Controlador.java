package controlador;
import vista.Vista;
import modelo.*;
public class Controlador {
    private HashMapManager manager = new HashMapManager();
    private Vista vista =  new Vista();


    public void iniciar() {

        boolean continuar = true;
        while (continuar) {
            String opcion = vista.mostrarMenu();
            switch (opcion) {
                case "1":
                    Elemento elemento = vista.crearElemento();
                    manager.crear(elemento);
                    break;
                case "2":
                    String codigo = vista.pedirCodigo();
                    elemento = manager.buscar(codigo);
                    vista.mostrarElemento(elemento);
                    break;
                case "3":
                    elemento = vista.crearElemento();
                    manager.modificar(elemento);
                    break;
                case "4":
                    codigo = vista.pedirCodigo();
                    manager.eliminar(codigo);
                    break;
                case "5":
                    manager.mostrartodo();
                    break;
                case "6":
                    continuar = false;
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida");
            }
        }
    }
}
