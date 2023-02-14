/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapp.repository;

import commonlib.domain.GenericEntity;
import java.util.List;

/**
 *
 * @author Lenovo
 * @param <T>
 * @param <K>
 */
public interface Repository<T, K> {

    Long add(T param) throws Exception;

    void edit(T param) throws Exception;

    void delete(T param) throws Exception;

    List<T> getAll() throws Exception;

    List<T> getAll(T param) throws Exception;

    T getOne(T param) throws Exception;
    
    List<T> getByCondition (T param) throws Exception;
    

}
