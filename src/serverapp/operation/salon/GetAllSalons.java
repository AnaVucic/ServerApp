package serverapp.operation.salon;

import commonlib.domain.City;
import commonlib.domain.GenericEntity;
import commonlib.domain.Salon;
import java.util.List;
import serverapp.operation.GenericOperation;


public class GetAllSalons extends GenericOperation{

    List<GenericEntity> list;
    @Override
    protected void preconditions(Object param) throws Exception {
        if(!(param instanceof Salon))
            throw new Exception("Invalid object");
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        list = repository.getAll((GenericEntity)new Salon());
        for(GenericEntity salonEntity : list){
            Salon salon = (Salon) salonEntity;
            
            GenericEntity entityCity = ((List<GenericEntity>) repository.getByCondition(salon.getCity())).get(0);
            salon.setCity((City) entityCity);
        }
    }
    
    public List<GenericEntity> getList(){
        return list;
    }
    
}
