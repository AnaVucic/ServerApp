/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapp.operation.person;

import commonlib.domain.GenericEntity;
import commonlib.domain.Person;
import java.util.List;
import serverapp.operation.GenericOperation;

/**
 *
 * @author Lenovo
 */
public class GetAllPersons extends GenericOperation {

    private List<GenericEntity> list;

    @Override
    protected void preconditions(Object param) throws Exception {
        if (!(param instanceof Person)) {
            throw new Exception("Object is not an instance of commonlib.domain.Person");
        }
    }

    @Override
    protected void executeOperation(Object param) throws Exception {
        list = repository.getAll((GenericEntity) new Person());

        for (GenericEntity entity : list) {
            Person p = (Person) entity;
        }
    }

    public List<GenericEntity> getList() {
        return list;
    }
}
