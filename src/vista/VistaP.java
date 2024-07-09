package vista;
import controlador.ControladorP;
import javax.swing.*;

public class VistaP {
    public int iniciarMenu() {
        String menu = "---Menú---\n" +
                "1. Agregar registro\n" +
                "2. Mostrar registros\n" +
                "3. Modificar registro\n" +
                "4. Eliminar registro\n" +
                "5. Salir\n" +
                "Ingrese su opción: ";
        String opcionStr = JOptionPane.showInputDialog(menu);
        return Integer.parseInt(opcionStr);
    }

    public float capturarPeso() {
        String pesoStr = JOptionPane.showInputDialog("Ingrese el peso:");
        return Float.parseFloat(pesoStr);
    }

    public int capturarIndice() {
        String indiceStr = JOptionPane.showInputDialog("Ingrese el índice del registro:");
        return Integer.parseInt(indiceStr);
    }

    public void imprimir(String texto) {
        JOptionPane.showMessageDialog(null, texto);
    }

    public void Ejecutar() {
        ControladorP controlador = new ControladorP();
        controlador.ejecutar();
    }
}
