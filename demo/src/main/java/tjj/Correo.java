package tjj;

import java.util.ArrayList;
public class Correo {
    public String asunto;
    public String contenido;
    public Contacto contacto;
    public ArrayList<Usuario> para;
    public Usuario para1;

    public Correo(String asunto, String contenido, Contacto contacto, ArrayList<Usuario> para) {
        setAsunto(asunto);
        setContenido(contenido);
        setContacto(contacto);
        setPara(para);
    }
    public Correo(String asunto, String contenido, Contacto contacto, Usuario para1) {
        setAsunto(asunto);
        setContenido(contenido);
        setContacto(contacto);
        setPara1(para1);
    }

    public String getAsunto() {
        return asunto;
    }
    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public Contacto getContacto() {
        return contacto;
    }
    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public ArrayList<Usuario> getPara() {
        return para;
    }

    public void setPara(ArrayList<Usuario> para) {
        this.para = para;
    }
    public Usuario getPara1() {
        return para1;
    }
    public void setPara1(Usuario para1) {
        this.para1 = para1;
    }
    public String toString() {
        String para = "";
        for(Usuario c: this.para){
            para += c.toString() + ", ";
        }
        return "asunto=" + asunto + ", contenido=" + contenido + ", contacto=" + contacto + ", para=" + para;
    }
    
}
