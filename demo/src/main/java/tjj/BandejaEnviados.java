package tjj;

import java.util.ArrayList;

import tjj.interfaces.predicates;

public class BandejaEnviados implements predicates{
    private ArrayList<Correo> Correos;

    public void agregarCorreo(Correo correo){
        Correos.add(correo);
    }

}
