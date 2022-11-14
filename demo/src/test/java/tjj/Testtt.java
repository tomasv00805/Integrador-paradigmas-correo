package tjj;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.function.Predicate;

import org.junit.Test;

import tjj.interfaces.predicates;

public class Testtt {
    
    @Test
    public void crearCorreo() {
        Usuario usuario1 = new Usuario(new Contacto("tomas","tomas@gmail.com"));
        Usuario usuario2 = new Usuario(new Contacto("juli","juli@yaghoo.com"));
        Usuario usuario3 = new Usuario(new Contacto("joaqui","joaqui@hotmail.com"));
        ArrayList<Usuario> para = new ArrayList<Usuario>();
        para.add(usuario2);
        para.add(usuario3);
        usuario1.crearCorreo("hola", "Que tal", para);
        assertEquals("asunto=hola, contenido=Que tal, contacto=nombreyApellido=tomas, correo=tomas@gmail.com, para=nombreyApellido=juli, correo=juli@yaghoo.com, nombreyApellido=joaqui, correo=joaqui@hotmail.com, ",usuario1.crearCorreo("hola", "Que tal", para));
    }

    @Test
    public void enviarCorreo() {
        Usuario usuario1 = new Usuario(new Contacto("tomas","tomas@gmail.com"));
        Usuario usuario2 = new Usuario(new Contacto("juli","juli@yaghoo.com"));
        Usuario usuario3 = new Usuario(new Contacto("joaqui","joaqui@hotmail.com"));
        ArrayList<Usuario> para = new ArrayList<Usuario>();
        para.add(usuario2);
        para.add(usuario3);
        usuario1.enviarCorreo(usuario1.crearCorreo("hola", "Que tal", para));
        assertEquals(1,usuario2.BandejaEntrada.size());
        assertEquals(1,usuario3.BandejaEntrada.size());
        assertEquals(1,usuario1.BandejaEnviados.size());
    }

    @Test
    public void enviarVariosCorreos(){
        Usuario usuario1 = new Usuario(new Contacto("tomas","tomas@gmail.com"));
        Usuario usuario2 = new Usuario(new Contacto("juli","juli@yaghoo.com"));
        Usuario usuario3 = new Usuario(new Contacto("joaqui","joaqui@hotmail.com"));
        Usuario usuario4 = new Usuario(new Contacto("pedro","pedro@ucp.ucp.edu.com"));
        
        ArrayList<Usuario> para = new ArrayList<Usuario>();
        para.add(usuario2);
        para.add(usuario3);
        usuario1.enviarCorreo(usuario1.crearCorreo("hola", "Que tal", para));
        usuario1.enviarCorreo(usuario1.crearCorreo("buendia", "che", para));
        usuario1.enviarCorreo(usuario1.crearCorreo("buendia", "che", usuario2));
        assertEquals(3,usuario2.BandejaEntrada.size());
        assertEquals(2,usuario3.BandejaEntrada.size());
        assertEquals(3,usuario1.BandejaEnviados.size());
        assertEquals(0,usuario4.BandejaEntrada.size());
        usuario1.enviarCorreo(usuario1.crearCorreo("a", "cheeee", usuario4));
        assertEquals(1,usuario4.BandejaEntrada.size());
        assertEquals(4,usuario1.BandejaEnviados.size());
    }
    @Test
    public void filtrarPorTipoemail(){
        Usuario usuario1 = new Usuario(new Contacto("tomas","tomas@gmail.com"));
        Usuario usuario2 = new Usuario(new Contacto("juli","juli@yaghoo.com"));
        Usuario usuario3 = new Usuario(new Contacto("joaqui","joaqui@hotmail.com"));
        for (int i = 0; i < 50; i++) {
            usuario2.enviarCorreo(usuario2.crearCorreo("hola"+i, "Que tal", usuario1));
        } 
        for (int i = 50; i < 75; i++) {
            usuario3.enviarCorreo(usuario3.crearCorreo("hola"+i, "Que tal", usuario1));
        }
        

        assertEquals(50,predicates.filtrarCorreosPorTipoemail("@yaghoo.com",usuario1.BandejaEntrada).size());
        assertEquals(25,predicates.filtrarCorreosPorTipoemail("@hotmail.com",usuario1.BandejaEntrada).size());
    }

}
