package java.dao;

import model.Habitacion;
import org.hibernate.Session;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.util.List;

public class HabitacionDAO {

    private Session session;

    public Habitacion getHabitacionCapacidad (int capacidad){
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Habitacion> query = session.createQuery("FROM Habitacion h WHERE h.capacidad  = :capacidad",Habitacion.class);
        query.setParameter("capacidad",capacidad);
        List<Habitacion> listaFiltradaHabitaciones = query.list();
        session.getTransaction().commit();
        session.close();
        if (!listaFiltradaHabitaciones.isEmpty()){
            return listaFiltradaHabitaciones.getFirst();
        }
        return null;

    }
}
