package com.join;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Join3Service
{
    @Autowired
    private Join3DAO join3DAO;
    public void setJoin3DAO(Join3DAO join3DAO) {
        this.join3DAO = join3DAO;
    }

    @Transactional
    public List<Object> zapros3(){return this.join3DAO.zapros3();}
}
