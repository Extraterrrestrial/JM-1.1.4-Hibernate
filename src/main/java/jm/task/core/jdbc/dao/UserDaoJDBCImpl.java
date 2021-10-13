package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Connection connection = Util.getConnection();

    private final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS `test`.`users` " +
            "(`id` BIGINT NOT NULL AUTO_INCREMENT," +
            " `name` VARCHAR(45) NOT NULL," +
            " `lastName` VARCHAR(45) NOT NULL," +
            " `age` TINYINT NOT NULL," +
            " PRIMARY KEY (`id`))";

    private final String DELETE_TABLE = "DROP TABLE IF EXISTS test.users";
    private final String SAVE_NEW_USER = "INSERT INTO test.users (name, lastName, age) VALUES (?, ?, ?)";
    private final String GET_ALL_USERS = "SELECT * FROM test.users";
    private final String CLEAR_TABLE = "DELETE FROM test.users";
    private final String DELETE_USER_BY_ID = "DELETE FROM test.users WHERE id";

    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(CREATE_TABLE);
            System.out.println("Таблица создана");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Не удалось создать таблицу SQL запросом: " + CREATE_TABLE);
        }
    }

    public void dropUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(DELETE_TABLE);
            System.out.println("Таблица удалена");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(SAVE_NEW_USER)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Не удалось добавить в базу Юзера с именем – " + name);
        }
    }

    public void removeUserById(long id) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(DELETE_USER_BY_ID);
            System.out.println("User id:" + id + " удален");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Не удалось удалить юзера id:" + id);
        }
    }

    public List<User> getAllUsers() {
        List<User> allUser = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(GET_ALL_USERS);
            System.out.println("Все пользователи получены");
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                allUser.add(user);
//                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Не удалось получить всех юзеров");

        }
        return allUser;
    }

    public void cleanUsersTable() {
//        String sql = "DELETE FROM test.users";
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate(CLEAR_TABLE);
            System.out.println("Таблица очищена");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Не удалось очистить таблицу");
        }

    }
}
