/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapp.operation.appointment_service;

import commonlib.domain.AppointmentService;
import serverapp.operation.GenericOperation;

/**
 *
 * @author ANA
 */
public class DeleteAppointmentService extends GenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
        if(!(param instanceof AppointmentService)){
            throw new Exception("Object is not an instance of commonlib.domain.AppointmentService");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        repository.delete(param);
    }
   
}
