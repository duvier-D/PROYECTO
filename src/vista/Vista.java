package vista;
import controlador.Controlador;
import modelo.Elemento;
import javax.swing.JOptionPane;
public class Vista {

    public String mostrarMenu() {
        return JOptionPane.showInputDialog(null,
                "Menú:\n1. Añadir elemento\n2. Mostrar elemento\n3. Actualizar elemento\n4. Eliminar elemento\n5. Mostrar todos los elementos\n6. Salir",
                "Menú Principal",
                JOptionPane.QUESTION_MESSAGE);
    }

    public Elemento crearElemento() {
        String codigo = JOptionPane.showInputDialog("Introduce el código:");
        String nombre = JOptionPane.showInputDialog("Introduce el nombre:");
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad:"));
        double precio = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio:"));
        return new Elemento(codigo, nombre, cantidad, precio);
    }

    public String pedirCodigo() {
        return JOptionPane.showInputDialog("Introduce el código:");
    }

    public void mostrarElemento(Elemento elemento) {
        if (elemento != null) {
            JOptionPane.showMessageDialog(null, elemento.toString());
        } else {
            JOptionPane.showMessageDialog(null, "Elemento no encontrado");
        }
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }


    public void run(){
        Controlador controlador = new Controlador();
        controlador.iniciar();
    }

    public String pedirusuario(){
        String usuario = JOptionPane.showInputDialog("introduce tu nombre de usuario");
        return usuario;

    }
    public String pedirtipousuario(){
        String tipo = JOptionPane.showInputDialog("introduce tu nombre de usuario");
        return tipo;

    }
    public String pedircontraseña(){
        String contraseña = JOptionPane.showInputDialog("introduce tu nombre de usuario");
        return contraseña;

    }
}
