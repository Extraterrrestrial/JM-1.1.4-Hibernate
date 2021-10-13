//package jm.task.core.jdbc.service;
//
//import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
//import jm.task.core.jdbc.model.User;
//
//import java.util.List;
//
//public class UserServiceImpl implements UserService {
//    UserDaoHibernateImpl userDaoHibernate = new UserDaoHibernateImpl();
//
//    public void createUsersTable() {
//        userDaoHibernate.createUsersTable();
//    }
//
//    public void dropUsersTable() {
//        userDaoHibernate.createUsersTable();
//    }
//
//    public void saveUser(String name, String lastName, byte age) {
//        userDaoHibernate.saveUser(name, lastName, age);
//    }
//
//    public void removeUserById(long id) {
//        userDaoHibernate.removeUserById(id);
//    }
//
//    public List<User> getAllUsers() {
//        return userDaoHibernate.getAllUsers();
//    }
//
//    public void cleanUsersTable() {
//        userDaoHibernate.cleanUsersTable();
//    }
//}


package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao us = new UserDaoHibernateImpl();



    public void createUsersTable() {
        us.createUsersTable();
    }

    public void dropUsersTable() {
        us.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        us.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {

        us.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return us.getAllUsers();
    }

    public void cleanUsersTable() {
        us.cleanUsersTable();
    }
}

