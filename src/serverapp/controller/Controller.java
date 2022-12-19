package serverapp.controller;

import commonlib.domain.GenericEntity;
import java.util.List;
import serverapp.repository.Repository;
import serverapp.repository.db.DatabaseRepository;
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
    // UNSUPPORTED
    public GenericEntity login(GenericEntity entity) throws Exception {
//        AbstractGenericOperation genericOperation = new Login();
//        genericOperation.execute(entity);
//        return ((Login) genericOperation).getObject();
        return null;
    }
}
