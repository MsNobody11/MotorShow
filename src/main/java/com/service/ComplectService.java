package com.service;

import com.DAO.ComplectDAO;
import com.Salon.Complect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ComplectService {
    @Autowired
    private ComplectDAO complectDAO;
    public void setComplectDAO(ComplectDAO complectDAO) {
        this.complectDAO = complectDAO;
    }

    @Transactional
    public List<Complect> listComplect() {
        return this.complectDAO.listComplect()
                .stream()
                .sorted(Comparator.comparingInt(Complect::getKodCompl))
                .collect(Collectors.toList());
    }

    @Transactional
    public void addComplect(Complect s) {
        this.complectDAO.addComplect(s);
    }
    @Transactional
    public void deleteComplect(Integer kodcompl) {
        this.complectDAO.deleteComplect(kodcompl);
    }
    @Transactional
    public void updateComplect(Complect s){
        this.complectDAO.updateComplect(s);
    }
    @Transactional
    public Complect getId(Integer kodcompl){
        return this.complectDAO.getId(kodcompl);
    }
}
