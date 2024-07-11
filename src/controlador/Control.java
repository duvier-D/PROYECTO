package controlador;

import modelo.DatosAdmin;
import modelo.DatosTrabajador;
import vista.Vista_Menu;

public class Control {
    Vista_Menu v = new Vista_Menu();
    DatosAdmin da = new DatosAdmin();
    DatosTrabajador dt = new DatosTrabajador();

    public void control(){
        int op = 0;
        boolean control = true;
        while (control){
            op = v.menu();
            switch (op) {

                case 1:
                    String nombre;
                    String contra;
                    String tipo;
                    nombre = v.toma_nombre();
                    contra = v.toma_contra();
                    tipo = v.toma_tipo();
                    da.crearUsu(nombre,contra,tipo);
                    break;
                case 2:

                    String busnom;
                    busnom = v.busca_nombre();
                    String existe = da.veriExis(busnom);

                    if (existe.equals("si")){
                        String modiNom = v.modi_nombre();
                        String modiCon = v.modi_contra();
                        String modiTip = v.modi_tipo();

                        da.modiUsu(busnom, modiNom,modiCon,modiTip);
                    }
                    break;
                case 3:

                    String nom_bus;
                    nom_bus = v.buscar_nombre();
                    da.bus_nom(nom_bus);
                    break;
                case 4:

                    String nom_elim;

                    nom_elim = v.elim_nombre();
                    da.eliminar(nom_elim);
                    break;
                case 5:

                    control = false;

            }
        }
    }
}
