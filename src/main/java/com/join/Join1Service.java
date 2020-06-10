package com.join;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Join1Service {
    @Autowired
    private Join1DAO join1DAO;
    public void setJoin1DAO(Join1DAO join1DAO) {
        this.join1DAO = join1DAO;
    }

    @Transactional
    public List<Object> zapros1(){return this.join1DAO.zapros1();}

}
