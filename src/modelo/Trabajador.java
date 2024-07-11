package modelo;
public class Trabajador {

    private String nombreT;
    private int numeroT;
    private String area;


    public Trabajador(){

    }

    public Trabajador(String nombreT, int numeroT, String area) {
        this.nombreT = nombreT;
        this.numeroT = numeroT;
        this.area = area;
    }

    public String getNombreT() {
        return nombreT;
    }

    public void setNombreT(String nombreT) {
        this.nombreT = nombreT;
    }

    public int getNumeroT() {
        return numeroT;
    }

    public void setNumeroT(int numeroT) {
        this.numeroT = numeroT;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }


    @Override
    public String toString() {
        return "Trabajador{" +
                "nombreT='" + nombreT + '\'' +
                ", numeroT=" + numeroT +
                ", area='" + area + '\'' +
                '}';
    }
}
