package tjj.interfaces;

import java.util.ArrayList;

import tjj.Correo;
import tjj.Usuario;

public interface emailManager {

    public void enviarCorreo(Correo correo);
    
    public Correo crearCorreo(String asunto, String cuerpo, ArrayList<Usuario> para);

    
    
    
}
