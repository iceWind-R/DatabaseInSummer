package service;

import dao.EntertainmentDao;
import domain.Entertainment;

import java.util.List;

public class EntertainmentService {

    private EntertainmentDao dao = new EntertainmentDao();

    public List<Entertainment> findAll() {
        return dao.findAll();
    }

    public List<Entertainment> findByUser(String name, String type) {
        return dao.findByUser(name, type);
    }
}
