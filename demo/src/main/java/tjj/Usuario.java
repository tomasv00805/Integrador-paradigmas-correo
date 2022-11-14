package tjj;

import java.lang.ProcessBuilder.Redirect.Type;
import java.util.ArrayList;

import tjj.interfaces.emailManager;
import tjj.interfaces.predicates;

public class Usuario implements emailManager, predicates {
    Contacto contacto;
    ArrayList<Correo> BandejaEnviados= new ArrayList<Correo>();
    ArrayList<Correo> BandejaEntrada= new ArrayList<Correo>();
    

    public Usuario(Contacto contacto) {
        this.contacto = contacto;
    }

    public ArrayList<Correo> getBandejaEnviados() {
        return BandejaEnviados;
    }

    public void setBandejaEnviados(ArrayList<Correo> bandejaEnviados) {
        BandejaEnviados = bandejaEnviados;
    }

    public ArrayList<Correo> getBandejaEntrada() {
        return BandejaEntrada;
    }

    public void setBandejaEntrada(ArrayList<Correo> bandejaEntrada) {
        BandejaEntrada = bandejaEntrada;
    }
    
    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }
    @Override
    public void enviarCorreo(Correo correo) {
        if(correo.para==null) {
            correo.para1.BandejaEntrada.add(correo);
        }else {
            for(Usuario c: correo.para){
                c.BandejaEntrada.add(correo);
            }
        }
        this.BandejaEnviados.add(correo);
    }

    @Override
    public Correo crearCorreo(String asunto, String cuerpo, ArrayList<Usuario> para) {
        Correo correo = new Correo(asunto, cuerpo, this.contacto, para);
        return correo;
    }
    public Correo crearCorreo(String asunto, String cuerpo, Usuario para) {
        Correo correo = new Correo(asunto, cuerpo, this.contacto, para);
        return correo;
    }

    public String toString() {
        return contacto.toString();
    }

    

}
