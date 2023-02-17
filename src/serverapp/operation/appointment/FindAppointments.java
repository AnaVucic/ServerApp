/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapp.operation.appointment;

import commonlib.domain.Appointment;
import commonlib.domain.AppointmentService;
import commonlib.domain.City;
import commonlib.domain.Dog;
import commonlib.domain.GenericEntity;
import commonlib.domain.Person;
import commonlib.domain.Salon;
import commonlib.domain.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import serverapp.operation.GenericOperation;

/**
 *
 * @author Lenovo
 */
public class FindAppointments extends GenericOperation{

    private List<GenericEntity> list;
    
    @Override
    protected void preconditions(Object param) throws Exception {
        if(!(param instanceof Appointment)){
            throw new Exception("Object is not an instance of commonlib.domain.Appointment");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        list = repository.getByCondition((GenericEntity) param);
        
        for(GenericEntity entity : list) {
            Appointment a = (Appointment) entity;
            
            GenericEntity entityDog = (GenericEntity) repository.getOne( a.getDog());
            a.setDog((Dog) entityDog);
            
            GenericEntity entityPerson = (GenericEntity) repository.getOne(a.getDog().getPerson());
            a.getDog().setPerson((Person)entityPerson);
            
            GenericEntity entitySalon = (GenericEntity) repository.getOne(a.getSalon());
            a.setSalon((Salon) entitySalon);
            
            GenericEntity entityCity = (GenericEntity) repository.getOne(a.getSalon().getCity());
            a.getSalon().setCity((City) entityCity);
            
            List<GenericEntity> entityServices = repository.getByCondition(new AppointmentService(a.getAppointmentID(), null));
            List<Service> services = new ArrayList<>();
            for (GenericEntity entityService : entityServices) {
                Service s = new Service(((AppointmentService) entityService).getService(), null, BigDecimal.ONE, 0);
                Service s1 = ((List<Service>) repository.getByCondition(s)).get(0);
                s.setDuration(s1.getDuration());
                s.setName(s1.getName());
                s.setFee(s1.getFee());
                services.add(s);
            }
            a.setServices(services);
            
            int totalDuration = 0;
            BigDecimal totalFee = new BigDecimal("0");
            for(Service s : services){
                totalDuration += s.getDuration();
                totalFee = totalFee.add(s.getFee());
            }
            a.setTotalDuration(totalDuration);
            a.setTotalFee(totalFee);
        }
    }
    
    public List<GenericEntity> getList(){
        return list;
    }
    
}
