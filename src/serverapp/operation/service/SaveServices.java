/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapp.operation.service;

import commonlib.domain.Appointment;
import commonlib.domain.AppointmentService;
import commonlib.domain.GenericEntity;
import commonlib.domain.Service;
import java.util.List;
import serverapp.operation.GenericOperation;

/**
 *
 * @author Lenovo
 */
public class SaveServices extends GenericOperation {

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Appointment)) {
            throw new Exception("Object is not an instance of commonlib.domain.Appointment");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        Appointment a = (Appointment) param;
        List<Service> services = a.getServices();
        for(Service s: services){
            AppointmentService as = new AppointmentService(a.getAppointmentID(), s.getServiceID());
            repository.add(as);
        }
        
        repository.add((GenericEntity) param);

    }

}
