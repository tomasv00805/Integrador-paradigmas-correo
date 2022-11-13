package tjj;

import java.util.ArrayList;

import tjj.interfaces.emailManager;

public class Usuario implements emailManager {
    Contacto contacto;
    BandejaEnviados BandejaEnviados;
    BandejaEntrada BandejaEntrada;

    public Usuario(Contacto contacto) {
        this.contacto = contacto;
    }

    public BandejaEnviados getBandejaEnviados() {
        return BandejaEnviados;
    }

    public void setBandejaEnviados(BandejaEnviados bandejaEnviados) {
        BandejaEnviados = bandejaEnviados;
    }

    public BandejaEntrada getBandejaEntrada() {
        return BandejaEntrada;
    }

    public void setBandejaEntrada(BandejaEntrada bandejaEntrada) {
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
        for(Usuario c: correo.para){
            c.BandejaEntrada.agregarCorreo(correo);
        }
        this.BandejaEnviados.agregarCorreo(correo);
    }

    @Override
    public Correo crearCorreo(String asunto, String cuerpo, ArrayList<Usuario> para) {
        Correo correo = new Correo(asunto, cuerpo, this.contacto, para);
        return correo;
    }

    public String toString() {
        return contacto.toString();
    }

}
