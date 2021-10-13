package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    private static final UserService userService = new UserServiceImpl();
    private static final User user1 = new User("Alexey", "Korepanoff", (byte) 25);
    private static final User user2 = new User("Ivan", "Ivanov", (byte) 38);
    private static final User user3 = new User("Petr", "Petrov", (byte) 43);
    private static final User user4 = new User("Alex", "Alexandroff", (byte) 55);

    public static void main(String[] args) {
        userService.createUsersTable();
        userService.saveUser(user1.getName(), user1.getLastName(), user1.getAge());
        userService.saveUser(user2.getName(), user2.getLastName(), user2.getAge());
        userService.saveUser(user3.getName(), user3.getLastName(), user3.getAge());
        userService.saveUser(user4.getName(), user4.getLastName(), user4.getAge());
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
