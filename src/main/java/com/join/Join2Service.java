package com.join;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Join2Service
{
    @Autowired
    private Join2DAO join2DAO;
    public void setJoin2DAO(Join2DAO join2DAO) {
        this.join2DAO = join2DAO;
    }

    @Transactional
    public List<Object> zapros2(){return this.join2DAO.zapros2();}
}
