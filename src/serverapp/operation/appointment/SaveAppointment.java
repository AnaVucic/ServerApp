/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapp.operation.appointment;

import commonlib.domain.Appointment;
import commonlib.domain.GenericEntity;
import serverapp.operation.GenericOperation;

/**
 *
 * @author Lenovo
 */
public class SaveAppointment extends GenericOperation {
    
    private Long id;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if(!(param instanceof Appointment)){
            throw new Exception("Object is not an instance of commonlib.domain.Appointment");
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
