package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ModeloP {
    private float peso;
    private Date fechaHora;

    public ModeloP() {
    }

    public ModeloP(float peso, Date fechaHora) {
        this.peso = peso;
        this.fechaHora = fechaHora;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Date getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    @Override
    public String toString() {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        return "Peso: " + peso + ", Fecha y Hora: " + formatoFecha.format(fechaHora) + "\n";
    }
}
