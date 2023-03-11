/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapp.operation.breed;

import commonlib.domain.Breed;
import commonlib.domain.GenericEntity;
import java.util.List;
import serverapp.operation.GenericOperation;

/**
 *
 * @author ANA
 */
public class GetAllBreeds extends GenericOperation {

    private List<GenericEntity> list;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Breed)) {
            throw new Exception("Object is not an instance of commonlib.domain.Breed");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        list = repository.getAll((GenericEntity) new Breed());

        for (GenericEntity entity : list) {
            Breed b = (Breed) entity;
        }
    }

    public List<GenericEntity> getList() {
        return list;
    }
}