package vista;

import controlador.Control;

import javax.swing.*;
import java.util.Scanner;

public class Vista_Menu {

    Scanner x = new Scanner(System.in);

    public int menu(){
        return Integer.parseInt(JOptionPane.showInputDialog("1. Crear Cuenta\n2. Actualizar Cuenta\n3. Buscar Trabajador\n4. Eliminar Usuario\n5. Salir"));
    }
    public String toma_nombre(){
        return JOptionPane.showInputDialog("Digite el nombre del usuario a crear");
    }

    public String toma_contra(){
        return JOptionPane.showInputDialog("Digite la contraseña del usuario");
    }
    public String toma_tipo(){
        return JOptionPane.showInputDialog("Digite el tipo del usuario");
    }
    public String busca_nombre(){
        return JOptionPane.showInputDialog("Digite el nombre del ususario para modificar");
    }

    public String modi_nombre(){ return JOptionPane.showInputDialog("Digite el nombre para modificar");}
    public String modi_contra(){
        return JOptionPane.showInputDialog("Digite la contraseña para modificar");
    }
    public String modi_tipo(){
        return JOptionPane.showInputDialog("Digite el tipo para modificar");
    }

    public String elim_nombre(){ return JOptionPane.showInputDialog("Digite el nombre del trabajador a eliminar");}

    public String buscar_nombre(){ return JOptionPane.showInputDialog("Digite el nombre para buscar el usuario");}

}
