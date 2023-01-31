package serverapp.controller;

import commonlib.domain.Dog;
import commonlib.domain.GenericEntity;
import java.util.List;
import serverapp.operation.GenericOperation;
import serverapp.operation.dog.FindDogs;
import serverapp.operation.dog.GetAllDogs;
import serverapp.operation.dog.SaveDog;
import serverapp.operation.user.Login;
import serverapp.repository.Repository;
import serverapp.repository.db.impl.DatabaseRepositoryGeneric;
import serverapp.server.Server;

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
    
    // EDIT DOG?
    
    // GET ALL APPOINTMENTS
    
    // SAVE APPOINTMENT
    
    // FIND APPOINTMENTS
    
    // EDIT APPOINTMENTS
}
