package service;

import dao.ManagerDao;
import domain.Manager_3;

import java.util.List;

public class ManagerService {
    private ManagerDao dao = new ManagerDao();
    public boolean findBynameAndPwd(String username, String password) {
       return dao.findBynameAndPwd(username,password);

    }

    public List<Manager_3> manager_3() { // 管理员的第三个功能

        return dao.manager_3();
    }
}
