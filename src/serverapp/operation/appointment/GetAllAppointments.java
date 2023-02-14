package serverapp.operation.appointment;

import commonlib.domain.Appointment;
import commonlib.domain.AppointmentService;
import commonlib.domain.Dog;
import commonlib.domain.GenericEntity;
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
public class GetAllAppointments extends GenericOperation {
    
    private List<GenericEntity> list;

    @Override
    protected void preconditions(Object param) throws Exception {
        if(!(param instanceof Appointment)){
            throw new Exception("Object is not an instance of commonlib.domain.Appointment");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        
        list = repository.getAll((GenericEntity) new Appointment());
        
        for(GenericEntity entity : list) {
            Appointment a = (Appointment) entity;
            
            GenericEntity entityDog = (GenericEntity) repository.getOne( a.getDog());
            
            a.setDog((Dog) entityDog);
            
            GenericEntity entitySalon = (GenericEntity) repository.getOne(a.getSalon());
            a.setSalon((Salon) entitySalon);
            
            List<GenericEntity> entityServices = repository.getByCondition(new AppointmentService(a.getAppointmentID(), null));
            List<Service> services = new ArrayList<>();
            for (GenericEntity entityService : entityServices) {
                services.add(new Service(((AppointmentService) entityService).getService(), null, BigDecimal.ONE, 0));
            }
            a.setServices(services);   
        }
    }
    
    public List<GenericEntity> getList() {
        return list;
    }
    
}
