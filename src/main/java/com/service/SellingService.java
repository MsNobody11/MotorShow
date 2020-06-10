package com.service;

import com.DAO.SellingDAO;
import com.Salon.Selling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellingService {
    @Autowired
    private SellingDAO sellingDAO;
    public void setSellingDAO(SellingDAO sellingDAO) {
        this.sellingDAO = sellingDAO;
    }

    @Transactional
    public List<Selling> listSelling() {
        return this.sellingDAO.listSelling()
                .stream()
                .sorted(Comparator.comparingInt(Selling::getId))
                .collect(Collectors.toList());
    }

    @Transactional
    public void addSelling(Selling s) {
        this.sellingDAO.addSelling(s);
    }
    @Transactional
    public void deleteSelling(Integer id) {
        this.sellingDAO.deleteSelling(id);
    }
    @Transactional
    public void updateSelling(Selling s){
        this.sellingDAO.updateSelling(s);
    }
    @Transactional
    public Selling getIdCl(Integer id){
        return this.sellingDAO.getIdCl(id);
    }
}

