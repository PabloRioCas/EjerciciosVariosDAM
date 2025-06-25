package java.controller;

import dao.HabitacionDAO;
import dao.TrabajadorDAO;
import model.Habitacion;
import model.Trabajador;

public class HotelController {

    //Logica del negocio
    private HabitacionDAO habitacionDAO;
    private TrabajadorDAO trabajadorDAO;

    public HotelController(){
        habitacionDAO = new HabitacionDAO();
        trabajadorDAO = new TrabajadorDAO();
    }

    public void asignarTrabajadorHabitacion(int idTrabajador, int capacidadHabitacion){
        //saco la habitacion -> habitación
        Habitacion habitacion = habitacionDAO.getHabitacionCapacidad(capacidadHabitacion);
        if(habitacion != null){
            System.out.println("Perfecto, procedemos a la asignación");
            //saco el trabajador -> trabajador
            Trabajador trabajador = trabajadorDAO.obtenerTrabajador(idTrabajador);
            if (trabajador!=null){
                System.out.println("Perfecto, trenemos trabajador. Vamos a asignar");
            } else {
                System.out.println("No se ha encontrado ningún trabajador con ese id");
            }
        }else {
            System.out.println("No hay habitación con esa capacidad");
        }


        //modifico el trabajador con la habitación -> trabajador
    }
}
