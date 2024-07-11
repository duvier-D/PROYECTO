package controlador;



import vista.*;

import javax.swing.*;

public class supercontrol {




        private supervista vista =  new supervista();
        private VistaP vistapesos =  new VistaP();

        private Controlador controlEPIS = new Controlador();
        private ControladorP controlPESOS = new ControladorP();
        private Control controlusuarios = new Control();



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
                        controlusuarios.control();
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

