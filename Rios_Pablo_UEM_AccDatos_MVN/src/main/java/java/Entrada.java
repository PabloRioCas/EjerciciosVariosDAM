package java;

import dao.TrabajadorDAO;


public class Entrada {

    public static void main(String[] args) {

        //Pedir datos al usuario y guardar el usuario en BD, pero si hay algún fallo,
        // volver a intentarlo con otros datos

        TrabajadorDAO trabajadorDAO = new TrabajadorDAO();
        /*Scanner scanner = new Scanner(System.in);
        String correo;
        boolean fallo = false;
        do {
            try{
                System.out.println("Introduce el correo");
                correo=scanner.next();
                trabajadorDAO.insertarTrabajador(new Trabajador("Pablo","Rios",correo,123345));
                fallo =false;
            } catch (ConstraintViolationException e){
                System.out.println("Correo duplicado, por favor, intentalo de nuevo");
                fallo = true;
            }
        }while ( fallo);

        System.out.println("agregado correctamente");*/

   //     trabajadorDAO.actualizarTrabajador(1);

    //    trabajadorDAO.borrarTrabajador(1);

    //    trabajadorDAO.insertarTrabajador(new Trabajador("pablo3","rios3","correo3@ue.es",1234,
    //           new Direccion("Teruel", "Teruel");

      //  trabajadorDAO.obtenerTodosTrabajadores();

     //   trabajadorDAO.obtenerTodosTrabajadoresNamed();

        trabajadorDAO.obtenerTrabajadoresLocalidad("Teruel");

    }
}
