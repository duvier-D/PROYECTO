package controlador;



import vista.*;

import javax.swing.*;

public class supercontrol {




        private supervista vista =  new supervista();
        private VistaP vistapesos =  new VistaP();

        private Controlador controlEPIS = new Controlador();
        private ControladorP controlPESOS = new ControladorP();


        public void iniciar() {

            boolean continuar = true;
            while (continuar) {
                String opcion = vista.supermenu();
                switch (opcion) {
                    case "1":
                       controlPESOS.ejecutar();
                        break;
                    case "2":
                        controlEPIS.iniciar();
                        break;
                    case "3":
                        JOptionPane.showMessageDialog(null,"falta agregar modulo usuarios");
                        break;

                    case "4":
                        continuar = false;
                        vista.mensaje();
                        break;
                    default:
                        vista.imprimir();
                }
            }
        }
    }

