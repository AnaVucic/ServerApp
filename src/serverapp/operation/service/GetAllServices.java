/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapp.operation.service;

import commonlib.domain.GenericEntity;
import commonlib.domain.Service;
import java.util.List;
import serverapp.operation.GenericOperation;

/**
 *
 * @author Lenovo
 */
public class GetAllServices extends GenericOperation {

    private List<GenericEntity> list;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Service)) {
            throw new Exception("Invalid object");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        list = repository.getAll((GenericEntity) new Service());
        for (GenericEntity serviceEntity : list) {
            Service service = (Service) serviceEntity;
        }
    }

    public List<GenericEntity> getList(){
        return list;
    }
}
