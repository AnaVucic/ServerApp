/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapp.repository.db;

import serverapp.repository.Repository;

/**
 *
 * @author Lenovo
 * @param <T>
 * @param <K>
 */
public interface DatabaseRepository<T, K> extends Repository<T, K>{
    
    default void connect() throws Exception {
        DatabaseConnectionFactory.getInstance().getConnection();
    }

    default void disconnect() throws Exception {
        DatabaseConnectionFactory.getInstance().getConnection().close();
    }

    default void commit() throws Exception {
        DatabaseConnectionFactory.getInstance().getConnection().commit();
    }

    default void rollback() throws Exception {
        DatabaseConnectionFactory.getInstance().getConnection().rollback();
    }

    
}
