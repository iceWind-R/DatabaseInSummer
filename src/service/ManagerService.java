package service;

import dao.ManagerDao;

public class ManagerService {
    private ManagerDao dao = new ManagerDao();
    public boolean findBynameAndPwd(String username, String password) {
       return dao.findBynameAndPwd(username,password);

    }
}
