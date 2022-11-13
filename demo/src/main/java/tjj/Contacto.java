package tjj;

public class Contacto {
    private String nombreyApellido;
    private String correo;
    

    public Contacto(String nombreyApellido, String correo) {
        this.nombreyApellido = nombreyApellido;
        this.correo = correo;
        
    }

    public String getNombreyApellido() {
        return nombreyApellido;
    }

    public void setNombreyApellido(String nombreyApellido) {
        this.nombreyApellido = nombreyApellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String toString() {
        return "nombreyApellido=" + nombreyApellido + ", correo=" + correo;
    }
}
