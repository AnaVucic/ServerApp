/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapp.operation.appointment;

import commonlib.domain.Appointment;
import commonlib.domain.AppointmentService;
import commonlib.domain.Service;
import serverapp.operation.GenericOperation;

/**
 *
 * @author ANA
 */
public class DeleteAppointment extends GenericOperation{

    @Override
    protected void preconditions(Object param) throws Exception {
        if(!(param instanceof Appointment)){
            throw new Exception("Object is not an instance of commonlib.domain.Appointment");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Appointment a = (Appointment) param;
        for(Service s: a.getServices()){
            AppointmentService as = new AppointmentService(a.getAppointmentID(), s.getServiceID());
            repository.delete(as);
        }
        repository.delete(param);
    }
   
}
