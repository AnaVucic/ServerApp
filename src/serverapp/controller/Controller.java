package serverapp.controller;

import commonlib.domain.Appointment;
import commonlib.domain.Dog;
import commonlib.domain.GenericEntity;
import commonlib.domain.Salon;
import java.io.IOException;
import java.util.List;
import serverapp.constant.Constant;
import serverapp.operation.GenericOperation;
import serverapp.operation.appointment.GetAllAppointments;
import serverapp.operation.dog.FindDogs;
import serverapp.operation.dog.GetAllDogs;
import serverapp.operation.dog.SaveDog;
import serverapp.operation.salon.GetAllSalons;
import serverapp.operation.user.Login;
import serverapp.repository.Repository;
import serverapp.repository.db.impl.DatabaseRepositoryGeneric;
import serverapp.server.Server;
import serverapp.session.Session;
import serverapp.util.PropertiesLoader;

/**
 *
 * @author Lenovo
 */
public class Controller {

    private static Controller controller;
    private Server server;
    private Repository repository;

    private Controller() {
        repository = new DatabaseRepositoryGeneric();
    }

    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
        }
        return controller;
    }

    // LOGIN
    public GenericEntity login(GenericEntity entity) throws Exception {
        GenericOperation genericOperation = new Login();
        genericOperation.execute(entity);
        return ((Login) genericOperation).getObject();
    }
    
    // LOGOUT
    
    // SAVE DOG
    public Long saveDog (GenericEntity entity) throws Exception {
        GenericOperation genericOperation = new SaveDog();
        genericOperation.execute(entity);
        return ((SaveDog) genericOperation).getId();
    }
    
    // GET ALL DOGS
    public List<GenericEntity> getAllDogs() throws Exception {
        GenericOperation genericOperation = new GetAllDogs();
        genericOperation.execute(new Dog());
        return ((GetAllDogs) genericOperation).getList();
    }
    
    // FIND DOGS
    public List<GenericEntity> findDogs(GenericEntity entity) throws Exception {
        GenericOperation genericOperation = new FindDogs();
        genericOperation.execute(entity);
        return ((FindDogs) genericOperation).getList();
    }
    
    // GET ONE DOG
    //public GenericEntity getEntity
    
    // EDIT DOG?
    
    // GET ALL APPOINTMENTS
    public List<GenericEntity> getAllAppointments() throws Exception {
        GenericOperation genericOperation = new GetAllAppointments();
        genericOperation.execute(new Appointment());
        return ((GetAllAppointments) genericOperation).getList();
    }
    
    // SAVE APPOINTMENT
    
    // FIND APPOINTMENTS
    
    // EDIT APPOINTMENTS
    
    // GET ALL SALONS
    public List<GenericEntity> getAllSalons() throws Exception {
        GenericOperation genericOperation = new GetAllSalons();
        genericOperation.execute(new Salon());
        return ((GetAllSalons) genericOperation).getList();
    }
    
    //...
    
    
    public void startServer() throws IOException {
        server = new Server(Integer.parseInt(PropertiesLoader.getInstance().getProperty(Constant.SERVER_PORT)));
        server.start();
    }

    public void stopServer() throws IOException {
        server.stopServer();
        Session.getInstance().logoutAllUsers();
    }
}
