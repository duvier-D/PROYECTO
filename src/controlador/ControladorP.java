package controlador;

import modelo.BD_Peso;
import modelo.ModeloP;
import vista.VistaP;

import java.util.Date;

public class ControladorP {
    BD_Peso bd = new BD_Peso();
    VistaP vista = new VistaP();

    public void ejecutar() {
        boolean ejecutando = true;

        while (ejecutando) {
            int opcion = vista.iniciarMenu();
            switch (opcion) {
                case 1:
                    float peso = vista.capturarPeso();
                    if (peso < 150 && peso > 20) {
                        bd.agregarRegistro(new ModeloP(peso, new Date()));
                        vista.imprimir("Peso agregado exitosamente\n");
                    } else {
                        vista.imprimir("El peso está fuera del rango 20/150 (Kg)\n");
                    }
                    break;
                case 2:
                    vista.imprimir(bd.mostrarRegistros());
                    break;
                case 3:
                    int idModificar = vista.capturarIndice();
                    float nuevoPeso = vista.capturarPeso();
                    if (bd.modificarRegistro(idModificar, nuevoPeso)) {
                        vista.imprimir("Registro modificado exitosamente\n");
                    } else {
                        vista.imprimir("El peso está fuera del rango 20/150 (Kg) o el registro no existe\n");
                    }
                    break;
                case 4:
                    int idEliminar = vista.capturarIndice();
                    bd.eliminarRegistro(idEliminar);
                    vista.imprimir("Registro eliminado exitosamente\n");
                    break;
                case 5:
                    ejecutando = false;
                    vista.imprimir("Programa terminado");
                    break;
                default:
                    vista.imprimir("Opción no válida");
                    break;
            }
        }
    }
}
