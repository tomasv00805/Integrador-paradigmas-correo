package tjj;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class Testtt {
    
    @Test
    public void crearCorreo() {
        Usuario usuario1 = new Usuario(new Contacto("tomas","tomas@gmail.com"));
        Usuario usuario2 = new Usuario(new Contacto("juan","juan@gmail.com"));
        Usuario usuario3 = new Usuario(new Contacto("pedro","pedro@ucp.ucp.edu.com"));
        ArrayList<Usuario> para = new ArrayList<Usuario>();
        para.add(usuario2);
        para.add(usuario3);
        usuario1.crearCorreo("hola", "Que tal", para);
        assertEquals("asunto=hola, contenido=Que tal, contacto=nombreyApellido=tomas, correo=tomas@gmail.com, para=nombreyApellido=juan, correo=juan@gmail.com, nombreyApellido=pedro, correo=pedro@ucp.ucp.edu.com, ",usuario1.crearCorreo("hola", "Que tal", para));
    }
    
}
