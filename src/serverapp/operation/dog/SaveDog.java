/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapp.operation.dog;

import commonlib.domain.Dog;
import commonlib.domain.GenericEntity;
import serverapp.operation.GenericOperation;

/**
 *
 * @author Lenovo
 */
public class SaveDog extends GenericOperation {

    Long id = -999l;
    
    public Long getId(){
        return id;
    }
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if(!(param instanceof Dog))
            throw new Exception ("Object is invalid!");
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Dog dog = (Dog) param;
        id = repository.add((GenericEntity) dog);
        dog.setDogID(id);
        
        
    }
    
}
