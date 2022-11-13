package tjj.interfaces;

import java.util.ArrayList;
import java.util.function.Predicate;

import tjj.Correo;

public interface predicates {
    Predicate<Correo> Correoucp =  c -> c.getContacto().getCorreo().endsWith("@ucp.edu.com");
    
    
    public static ArrayList<Correo> filtrarCorreos(Predicate<Correo> filtro, ArrayList<Correo> Correos){
        ArrayList<Correo> correosFiltrados = new ArrayList<Correo>();
        for(Correo c: Correos){
            if(filtro.test(c)){
                correosFiltrados.add(c);
            }
        }
        return correosFiltrados;
    }

    public static ArrayList<Correo> filtrarCorreosPorAsunto(String asunto, ArrayList<Correo> Correos){
        Predicate<Correo> Porasunto=  c -> c.getAsunto().contains(asunto);
        return filtrarCorreos(Porasunto, Correos);
    }
    public static ArrayList<Correo> filtrarCorreosPorCorreo(String correo, ArrayList<Correo> Correos){
        Predicate<Correo> Porcontacto=  c -> c.getContacto().getCorreo().contains(correo);
        return filtrarCorreos(Porcontacto, Correos);
    }
    public static ArrayList<Correo> filtrarCorreosPorNombre(String Nombre, ArrayList<Correo> Correos){
        Predicate<Correo> Porcontacto=  c -> c.getContacto().getNombreyApellido().contains(Nombre);
        return filtrarCorreos(Porcontacto, Correos);
    }
    public static ArrayList<Correo> filtrarCorreosDeUcp(ArrayList<Correo> Correos){
        return filtrarCorreos(Correoucp, Correos);
    }
    public static ArrayList<Correo> filtrarCorreosPorTipoemail(String tipoemail, ArrayList<Correo> Correos){
        Predicate<Correo> Correogmail =  c -> c.getContacto().getCorreo().endsWith(tipoemail);
        return filtrarCorreos(Correogmail, Correos);
    }
    
}