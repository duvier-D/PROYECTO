package vista;
import controlador.supercontrol;
import javax.swing.*;

public class supervista {


    public  void run(){
        supercontrol control= new supercontrol();
        control.iniciar();
    }

    public String supermenu(){
        return  JOptionPane.showInputDialog(null,"1/gestion pesos\n 2/gestion de EPIS\n 3/gestion de usuarios\n 4/salir","Super menu",JOptionPane.QUESTION_MESSAGE );

    }

    public void imprimir() {
        JOptionPane.showMessageDialog(null,"opcion no valida");
    }

    public void mensaje(){
        JOptionPane.showMessageDialog(null,"programa finalizado");
    }
}
