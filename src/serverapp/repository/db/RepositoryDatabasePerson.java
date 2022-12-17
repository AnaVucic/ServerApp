/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapp.repository.db;

import commonlib.domain.Person;
import commonlib.domain.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class RepositoryDatabasePerson implements DatabaseRepository<Person, Long>  {

    @Override
    public void add(Person param) throws Exception {
        String query = "INSERT INTO person(firstname, lastname, contact_number, appointment_number) VALUES (?,?,?,)";
        Connection connection = DatabaseConnectionFacotry.getInstance().getConnection();
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, param.getFirstname());
        ps.setString(2, param.getLastname());
        ps.setString(3, param.getContactNumber());
        ps.setInt(4, param.getAppointment_number());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void edit(Person param) throws Exception {
        Connection conn = DatabaseConnectionFacotry.getInstance().getConnection();
        String query = "UPDATE person SET firstname = ?, lastname = ?, contact_number = ?, appointment_number = ? WHERE id = " + param.getPersonID();
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, param.getFirstname());
        ps.setString(2, param.getLastname());
        ps.setString(3, param.getContactNumber());
        ps.setInt(4, param.getAppointment_number());
        ps.executeUpdate();
        ps.close();
    }

    @Override
    public void delete(Person param) throws Exception {
        Connection conn = DatabaseConnectionFacotry.getInstance().getConnection();
        String query = "DELETE FROM person WHERE id=" + param.getPersonID();
        Statement s = conn.createStatement();
        s.executeUpdate(query);
        s.close();
    }

    @Override
    public List<Person> getAll() throws Exception {
        List<Person> persons = new ArrayList<>();
        Connection conn = DatabaseConnectionFacotry.getInstance().getConnection();

        String query = "SELECT * FROM person";
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(query);

        s.close();
        while (rs.next()) {
            Long id = rs.getLong("id");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String contactNumber = rs.getString("contact_number");
            int appointmentNumber = rs.getInt("appointment_number");

            persons.add(new Person(id, firstname, lastname, contactNumber, appointmentNumber));
        }
        return persons;
    }

    @Override
    public List<Person> getAll(Person param) throws Exception {
        List<Person> persons = new ArrayList<>();
        Connection conn = DatabaseConnectionFacotry.getInstance().getConnection();

        String query = "SELECT * FROM person where id=" + param.getPersonID();
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(query);

        s.close();
        while (rs.next()) {
            Long id = rs.getLong("id");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String contactNumber = rs.getString("contact_number");
            int appointmentNumber = rs.getInt("appointment_number");

            persons.add(new Person(id, firstname, lastname, contactNumber, appointmentNumber));
        }
        return persons;
    }

    @Override
    public Person getOne(Long id) throws Exception {
        Connection conn = DatabaseConnectionFacotry.getInstance().getConnection();

        String query = "SELECT * FROM person WHERE id=" + id;
        Statement s = conn.createStatement();
        ResultSet rs = s.executeQuery(query);
        Person p = null;
        if (rs.next()) {
            p = new Person();
            p.setPersonID(rs.getLong("id"));
            p.setFisrtname(rs.getString("firstname"));
            p.setLastname(rs.getString("lastname"));
            p.setContactNumber(rs.getString("contact_number"));
            p.setAppointment_number(rs.getInt("appointment_number"));
        }
        s.close();
        return p;
    }
    
}
