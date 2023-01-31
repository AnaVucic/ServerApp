/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapp.operation.dog;

import commonlib.domain.Dog;
import commonlib.domain.GenericEntity;
import java.util.List;
import serverapp.operation.GenericOperation;

/**
 *
 * @author Lenovo
 */
public class FindDogs extends GenericOperation {

    private List<GenericEntity> list;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Dog)) {
            throw new Exception("Invalid object!");
        }

    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        list = repository.getAll((GenericEntity) param);

    }

    public List<GenericEntity> getList() {
        return list;
    }
}