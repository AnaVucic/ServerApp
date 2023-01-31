package serverapp.operation;

import serverapp.repository.Repository;
import serverapp.repository.db.DatabaseRepository;
import serverapp.repository.db.impl.DatabaseRepositoryGeneric;

/**
 *
 * @author Lenovo
 */
public abstract class GenericOperation {
    
    protected final Repository repository;
    
    public GenericOperation() {
        this.repository = new DatabaseRepositoryGeneric();
    }
    
    public final void execute(Object param) throws Exception {
        try {
            startTransaction();
            preconditions(param);
            executeOperation(param);
            commitTransaction();
        } catch (Exception ex) {
            ex.printStackTrace();
            rollbackTransaction();
            throw ex;
        } finally {
            disconnect();
        }
    }
    
    private void startTransaction() throws Exception {
        ((DatabaseRepository) repository).connect();
    }

    private void commitTransaction() throws Exception {
        ((DatabaseRepository) repository).commit();
    }

    private void rollbackTransaction() throws Exception {
        ((DatabaseRepository) repository).rollback();
    }

    private void disconnect() throws Exception {
        ((DatabaseRepository) repository).disconnect();
    }

    // Operation-specific method
    protected abstract void preconditions(Object param) throws Exception;

    // Operation-specific method
    protected abstract void executeOperation(Object param) throws Exception;
}
