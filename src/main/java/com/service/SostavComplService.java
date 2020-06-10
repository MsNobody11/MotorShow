package com.service;


import com.DAO.SostavComplDAO;
import com.Salon.Selling;
import com.Salon.SostavCompl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class SostavComplService {
    @Autowired
    private SostavComplDAO sostavcomplDAO;
    public void setSostavcomplDAO(SostavComplDAO sostavcomplDAO) {
        this.sostavcomplDAO = sostavcomplDAO;
    }

    @Transactional
    public List<SostavCompl> listSostavCompl() {
        return this.sostavcomplDAO.listSostavCompl()
                .stream()
                .sorted(Comparator.comparingInt(SostavCompl::getKod))
                .collect(Collectors.toList());
    }
    @Transactional
    public void addSostavCompl(SostavCompl s) {
        this.sostavcomplDAO.addSostavCompl(s);
    }
    @Transactional
    public void deleteSostavCompl(Integer kodelement) {
        this.sostavcomplDAO.deleteSostavCompl(kodelement);
    }
    @Transactional
    public void updateSostavCompl(SostavCompl s){
        this.sostavcomplDAO.updateSostavCompl(s);
    }
    @Transactional
    public SostavCompl getId(Integer kodelement){
        return this.sostavcomplDAO.getId(kodelement);
    }
}
