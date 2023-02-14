package serverapp.repository.db.impl;

import commonlib.domain.GenericEntity;
import java.util.List;
import serverapp.repository.db.DatabaseRepository;
import serverapp.repository.db.DatabaseConnectionFactory;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author Lenovo
 */
public class DatabaseRepositoryGeneric implements DatabaseRepository<GenericEntity, Long> {

    @Override
    public Long add(GenericEntity param) throws Exception {
        try {
            String sql;
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();
            sql = "INSERT INTO " + param.getTableName() + "(" + param.getColumnNamesForInsert() + ")"
                    + " VALUES (" + param.getInsertValues() + ")";
            System.out.println(sql);
            PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            statement.setEscapeProcessing(false);
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) {
                return rs.getLong(1);
            } else {
                return 0L;
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void edit(GenericEntity param) throws Exception {
        try {
            String query;
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();
            query = "UPDATE " + param.getTableName() + " SET " + param.setAttributes() + " WHERE " + param.getUpdateCondition();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.commit();
            statement.close();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public void delete(GenericEntity param) throws Exception {
        try {
            String query;
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();
            query = "DELETE FROM " + param.getTableName() + " WHERE " + param.getDeleteCondition();
            System.out.println(query);
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
            connection.commit();
            statement.close();
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public List<GenericEntity> getAll() throws Exception {
        return null;
    }

    @Override
    public List<GenericEntity> getAll(GenericEntity param) throws Exception {
        List<GenericEntity> list = null;

        try {
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();
            String query = "SELECT * FROM " + param.getTableName();

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            list = param.getList(resultSet);
            resultSet.close();
            statement.close();
            System.out.println(query);

            return list;
        } catch (SQLException ex) {
            throw ex;
        }
    }

    @Override
    public GenericEntity getOne(GenericEntity param) throws Exception {
        List<GenericEntity> list = null;
        try {
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();
            String query = "SELECT * FROM " + param.getTableName() + " WHERE " + param.getSelectCondition();
            System.out.println(query);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            list = param.getList(resultSet);

            statement.close();
            return list.get(0);
        } catch (Exception ex) {
            throw new Exception("Doesn't exist!");
        }
    }

    @Override
    public List<GenericEntity> getByCondition(GenericEntity param) throws Exception {
        List<GenericEntity> list = null;
        try {
            Connection connection = DatabaseConnectionFactory.getInstance().getConnection();
            String query = "SELECT * FROM " + param.getTableName() + " WHERE " + param.getSelectCondition();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            list = param.getList(resultSet);
            resultSet.close();
            statement.close();
            return list;
        } catch (Exception ex) {
            throw ex;
        }

    }

}
