package dao;

import model.Trabajador;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;
import utils.HibernateUtils;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

public class TrabajadorDAO {

    private Session session;

    public void insertarTrabajador(Trabajador trabajador)  throws ConstraintViolationException{

        //creo la sesión

        //1- comprobar en la lista (SELECT) si el correo ya está en la lista
            //Si esta -> error
            //Si no está -> añado
        //2.- Trata la excepcion
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        Transaction transaction =session.beginTransaction(); //no sería necesario igualarla a transacción
        session.persist(trabajador);
        transaction.commit();
        session.close();
    }

//    public void obtenerTrabajador(int id){
//        //prepareSt -> executeQuery -> resultSet -> While ->  rs.getString ("nombre) -> Objeto
//
//        session = new HibernateUtils().getSessionFactory().getCurrentSession();
//        session.beginTransaction();
//        Trabajador trabajador = session.get(Trabajador.class,id);
//        if(trabajador!=null){
//            System.out.println(trabajador);
//        }else System.out.println("El trabajador no se encuentra en plantilla");
//        session.getTransaction().commit();
//        session.close();
//    }

    public Trabajador obtenerTrabajador(int id){
        //prepareSt -> executeQuery -> resultSet -> While ->  rs.getString ("nombre) -> Objeto

        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Trabajador trabajador = session.get(Trabajador.class,id);
        session.getTransaction().commit();
        session.close();
        if(trabajador!=null){
            return trabajador;
        }return null;
    }

    public void actualizarTrabajador (int id){
        //UPDATE usuarios SET correo = nuevo@ue.com And apellido = apellido WHERE id= iD
        //1.Buscar el usuario
        session= new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Trabajador trabajador = session.get(Trabajador.class, id);
        //Trabajador trabajador = new Trabajador(1,"nombremano","apellidomano","correomano",123434);
        //si le dieramos todos los parametros, también actualizaría, pero exige que le dieramos todos porque si falta alguno,
        //como no pueden ser null los campos, daría error

        //2.Cambiar con los setters las propiedades
        if(trabajador!=null){
            trabajador.setNombre("Pablo");
            trabajador.setApellido("Rios");
            trabajador.setCorreo("Pablo@ue.es");
            session.merge(trabajador);
        }
        session.getTransaction().commit();
        session.close();

    }

    public void borrarTrabajador(int id){
        //DELETE FROM trabajadores WHERE id=6

        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        //1.- busco el trabajador
        Trabajador trabajador = session.get(Trabajador.class,id);
            if(trabajador != null){
                //2.- Borro el trabajador
                session.delete(trabajador);
            }
        session.getTransaction().commit();
        session.close();
    }

    public void obtenerTodosTrabajadores( ){
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();
            //prepareST -> resultSet -> While -> rs.getString -> creoObject ->List
        //Esto resume toda la query, Es recomendable tiparla con la clase que tiene que traer
        //pero no obligatoria.
        //En la query, el SELECT FROM... no se tiene que poner el SELECT, se sobreentiende
            Query<Trabajador> query = session.createQuery("FROM Trabajador", Trabajador.class);
        List<Trabajador> lista =query.list(); //Así obtengo la lista de todos los trabajadores
            for(Trabajador trabajador: lista){
                System.out.println(trabajador);
            }
        session.getTransaction().commit();
        session.close();

    }

    public void obtenerTodosTrabajadoresNamed(){
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        Query<Trabajador> query = session.createNamedQuery("Trabajador.findAll",Trabajador.class);
         List<Trabajador> lista =query.list(); //Así obtengo la lista de todos los trabajadores
            for(Trabajador trabajador: lista){
                System.out.println(trabajador);
            }
        session.getTransaction().commit();
        session.close();
    }

    public void obtenerTrabajadoresLocalidad(String localidad){
        session = new HibernateUtils().getSessionFactory().getCurrentSession();
        session.beginTransaction();
        //String queryString = "FROM Trabajador t WHERE t.direccion.localidad=:localidad";
        //Query<Trabajador> query = session.createQuery(queryString, Trabajador.class);
        //query.setParameter("localidad",localidad);
        Query<Trabajador> query= session.createNamedQuery("Trabajador.findByLocalidad",Trabajador.class);
        query.setParameter("localidad",localidad);
            List<Trabajador> lista =query.list(); //Así obtengo la lista de todos los trabajadores
                for(Trabajador trabajador: lista){
                    System.out.println(trabajador);
                }
        session.getTransaction().commit();
        session.close();
    }

}
