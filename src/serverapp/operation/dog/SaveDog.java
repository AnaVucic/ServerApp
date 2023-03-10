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
    
    private Long id;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if(!(param instanceof Dog)){
            throw new Exception("Object is not an instance of commonlib.domain.Dog");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        id = repository.add((GenericEntity)param);
    }
    
    public Long getId(){
        return id;
    }
    
}
