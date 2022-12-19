/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serverapp.repository.db;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import commonlib.domain.User;

/**
 *
 * @author Lenovo
 */
public class RepositoryDatabaseUser
        //implements DatabaseRepository<User, Long> 
{

//    @Override
//    public void add(User param) throws Exception {
//        String query = "INSERT INTO user(id, username, password) VALUES (?,?,?)";
//        Connection connection = DatabaseConnectionFactory.getInstance().getConnection();
//        PreparedStatement ps = connection.prepareStatement(query);
//        ps.setLong(1, param.getId());
//        ps.setString(2, param.getUsername());
//        ps.setString(3, param.getPassword());
//        ps.executeUpdate();
//        ps.close();
//    }
//
//    @Override
//    public void edit(User param) throws Exception {
//        Connection conn = DatabaseConnectionFactory.getInstance().getConnection();
//        String query = "UPDATE user SET username = ?, password = ? WHERE id = " + param.getId();
//        PreparedStatement ps = conn.prepareStatement(query);
//        ps.setString(1, param.getUsername());
//        ps.setString(2, param.getPassword());
//        ps.executeUpdate();
//        ps.close();
//    }
//
//    @Override
//    public void delete(User param) throws Exception {
//        Connection conn = DatabaseConnectionFactory.getInstance().getConnection();
//        String query = "DELETE FROM user WHERE id=" + param.getId();
//        Statement s = conn.createStatement();
//        s.executeUpdate(query);
//        s.close();
//    }
//
//    @Override
//    public List<User> getAll() throws Exception {
//        List<User> users = new ArrayList<>();
//        Connection conn = DatabaseConnectionFactory.getInstance().getConnection();
//
//        String query = "SELECT * FROM user";
//        Statement s = conn.createStatement();
//        ResultSet rs = s.executeQuery(query);
//
//        s.close();
//        while (rs.next()) {
//            Long id = rs.getLong("id");
//            String username = rs.getString("username");
//            String password = rs.getString("password");
//
//            users.add(new User(id, username, password));
//        }
//        return users;
//    }
//
//    @Override
//    public List<User> getAll(User param) throws Exception {
//        List<User> users = new ArrayList<>();
//        Connection conn = DatabaseConnectionFactory.getInstance().getConnection();
//
//        String query = "SELECT * FROM user where id=" + param.getId();
//        Statement s = conn.createStatement();
//        ResultSet rs = s.executeQuery(query);
//
//        s.close();
//        while (rs.next()) {
//            Long id = rs.getLong("id");
//            String username = rs.getString("username");
//            String password = rs.getString("password");
//
//            users.add(new User(id, username, password));
//        }
//        return users;
//    }
//
//    @Override
//    public User getOne(Long id) throws Exception {
//        Connection conn = DatabaseConnectionFactory.getInstance().getConnection();
//
//        String query = "SELECT * FROM user WHERE id=" + id;
//        Statement s = conn.createStatement();
//        ResultSet rs = s.executeQuery(query);
//        User u = null;
//        if (rs.next()) {
//            u = new User();
//            u.setId(rs.getLong("id"));
//            u.setUsername(rs.getString("username"));
//            u.setPassword(rs.getString("password"));
//        }
//        s.close();
//        return u;
//    }

}
