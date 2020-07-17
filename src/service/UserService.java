package service;

import dao.UserDao;
import domain.User;

import java.util.List;

public class UserService {
    private UserDao dao = new UserDao();

    public List<User> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }

    public User findUserByname(String username) {

        return dao.findUserByname(username);
    }

    public boolean insertUser(User user) {
        return dao.insertUser(user);
    }

    public User findUserByNo(int id) {
        return dao.findUserByNo(id);
    }

    public void updateUser(User user) {
        dao.updateUser(user);
    }

    public void delUserById(int id) {
        dao.delUser(id);
    }

    public boolean findUserBynameAndPwd(String username, String password) {
        return dao.findUserBynameAndPwd(username, password);
    }
}
