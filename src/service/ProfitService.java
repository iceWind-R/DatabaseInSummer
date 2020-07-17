package service;

import dao.ProfitsDao;
import domain.Profits;

import java.util.List;

public class ProfitService {
    private ProfitsDao dao = new ProfitsDao();


    public List<Profits> findAll() {

        return dao.findAll();
    }
}
