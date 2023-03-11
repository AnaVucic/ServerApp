/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapp.operation.dog;

import commonlib.domain.Dog;
import serverapp.operation.GenericOperation;

/**
 *
 * @author ANA
 */
public class DeleteDog extends GenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Dog)) {
            throw new Exception("Invalid object!");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.delete(param);

    }
    
}
