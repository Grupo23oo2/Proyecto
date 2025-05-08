package test;

import negocio.ContactoABM;
import datos.Contacto;

public class TestContacto {
    public static void main(String[] args) {
        ContactoABM abm = new ContactoABM();

        // Agregar
        Contacto nuevo = new Contacto();
        nuevo.setEmail("francoo@mail.com");
        nuevo.setTelefono("03211");
        abm.agregarContacto(nuevo);

        // Traer
      //  Contacto c = abm.traerContacto(nuevo.getIdContacto());
       // System.out.println("Contacto pedido: " + c.getEmail());

        // Modificar
   //     c.setEmail("otro@mail.com");
   //     abm.modificarContacto(c);

        // Eliminar
        abm.eliminarContacto(nuevo.getIdContacto());
    }
}