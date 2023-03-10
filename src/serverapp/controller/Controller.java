package serverapp.controller;

import commonlib.domain.Appointment;
import commonlib.domain.Breed;
import commonlib.domain.Dog;
import commonlib.domain.GenericEntity;
import commonlib.domain.Person;
import commonlib.domain.Salon;
import commonlib.domain.Service;
import java.io.IOException;
import java.util.List;
import serverapp.constant.Constant;
import serverapp.operation.GenericOperation;
import serverapp.operation.appointment.DeleteAppointment;
import serverapp.operation.appointment.EditAppointment;
import serverapp.operation.appointment.FindAppointments;
import serverapp.operation.appointment.GetAllAppointments;
import serverapp.operation.appointment.SaveAppointment;
import serverapp.operation.appointment_service.DeleteAppointmentService;
import serverapp.operation.appointment_service.SaveAppointmentService;
import serverapp.operation.breed.GetAllBreeds;
import serverapp.operation.dog.DeleteDog;
import serverapp.operation.dog.FindDogs;
import serverapp.operation.dog.GetAllDogs;
import serverapp.operation.dog.SaveDog;
import serverapp.operation.person.GetAllPersons;
import serverapp.operation.salon.GetAllSalons;
import serverapp.operation.service.GetAllServices;
import serverapp.operation.service.SaveServices;
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
    public Long saveDog(GenericEntity entity) throws Exception {
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
    public Long saveAppointment(GenericEntity param) throws Exception {
        GenericOperation genericOperation = new SaveAppointment();
        genericOperation.execute(param);
        return ((SaveAppointment) genericOperation).getId();
    }

    // SAVE SERVICES
    public void saveServices(GenericEntity param) throws Exception {
        GenericOperation genericOperation = new SaveServices();
        genericOperation.execute(param);
    }

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

    // GET ALL SERVICES
    public List<GenericEntity> getAllServices() throws Exception {
        GenericOperation genericOperation = new GetAllServices();
        genericOperation.execute(new Service());
        return ((GetAllServices) genericOperation).getList();
    }

    // FIND APPOINTMENTS
    public List<GenericEntity> findAppointments(GenericEntity param) throws Exception {
        GenericOperation genericOperation = new FindAppointments();
        genericOperation.execute(param);
        return ((FindAppointments) genericOperation).getList();
    }

    // GET ALL PERSONS
    public List<GenericEntity> getAllPersons() throws Exception {
        GenericOperation genericOperation = new GetAllPersons();
        genericOperation.execute(new Person());
        return ((GetAllPersons) genericOperation).getList();
    }

    // EDIT APPOINTMENT
    public void editAppointment(GenericEntity param) throws Exception {
        GenericOperation genericOperation = new EditAppointment();
        genericOperation.execute(param);
    }
    
    // SAVE APPOINTMENT-SERVICE
    public void saveAppointmentService(GenericEntity param) throws Exception {
        GenericOperation genericOperation = new SaveAppointmentService();
        genericOperation.execute(param);
    }

    // DELETE APPOINTMENT-SERVICE
    public void deleteAppointmentService(GenericEntity param) throws Exception {
        GenericOperation genericOperation = new DeleteAppointmentService();
        genericOperation.execute(param);
    }
    
    // DELETE APPOINTMENT
    public void deleteAppointment(GenericEntity param) throws Exception {
        GenericOperation genericOperation = new DeleteAppointment();
        genericOperation.execute(param);
    }

    // DELETE DOG
    public void deleteDog(GenericEntity param) throws Exception {
        GenericOperation genericOperation = new DeleteDog();
        genericOperation.execute(param);
    }

    // GET ALL BREEDS
    public List<GenericEntity> getAllBreeds() throws Exception {
        GenericOperation genericOperation = new GetAllBreeds();
        genericOperation.execute(new Breed());
        return ((GetAllBreeds) genericOperation).getList();
    }
}
