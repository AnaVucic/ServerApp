package serverapp.operation.user;

import commonlib.domain.GenericEntity;
import commonlib.domain.User;
import serverapp.operation.GenericOperation;

/**
 *
 * @author Lenovo
 */
public class Login extends GenericOperation {

    GenericEntity object = null;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof User)) {
            throw new Exception("Invalid object!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        object = (GenericEntity) repository.getOne(param);
    }

    public GenericEntity getObject() {
        return object;
    }

}
