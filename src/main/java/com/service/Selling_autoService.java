package com.service;


import com.DAO.Selling_autoDAO;
import com.Salon.Selling_auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class Selling_autoService {
    @Autowired
    private Selling_autoDAO selling_autoDAO;
    public void setSelling_autoDAO(Selling_autoDAO selling_autoDAO) {
        this.selling_autoDAO = selling_autoDAO;
    }

    @Transactional
    public List<Selling_auto> listSelling_auto() {
        return this.selling_autoDAO.listSelling_auto()
                .stream()
                .sorted(Comparator.comparingInt(Selling_auto::getId))
                .collect(Collectors.toList());
    }

    @Transactional
    public void addSelling_auto(Selling_auto s) {
        this.selling_autoDAO.addSelling_auto(s);
    }
    @Transactional
    public void deleteSelling_auto(Integer id) {
        this.selling_autoDAO.deleteSelling_auto(id);
    }
    @Transactional
    public void updateSelling_auto(Selling_auto s){
        this.selling_autoDAO.updateSelling_auto(s);
    }
    @Transactional
    public Selling_auto getId(Integer id){
        return this.selling_autoDAO.getId(id);
    }
}
