package modelo;

public class Admin {
    private String Usuario;
    private String Contrasena;
    private String Tipo;

    public Admin(String usuario, String contrasena, String tipo) {
        this.Usuario = usuario;
        this.Contrasena = contrasena;
        this.Tipo = tipo;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getContrasena() {
        return Contrasena;
    }

    public void setContrasena(String contrasena) {
        Contrasena = contrasena;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "Usuario='" + Usuario + '\'' +
                ", Contrasena='" + Contrasena + '\'' +
                ", Tipo='" + Tipo + '\'' +
                '}';
    }
}
