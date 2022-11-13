package tjj;

import java.util.ArrayList;
import java.util.function.Predicate;

import tjj.interfaces.predicates;


public class BandejaEntrada implements predicates{
    private ArrayList<Correo> Correos;

    public void agregarCorreo(Correo correo){
        Correos.add(correo);
    }
    
    public ArrayList<Correo> filtrarCorreos(Predicate<Correo> filtro){
        ArrayList<Correo> correosFiltrados = new ArrayList<Correo>();
        for(Correo c: Correos){
            if(filtro.test(c)){
                correosFiltrados.add(c);
            }
        }
        return correosFiltrados;
    }
}