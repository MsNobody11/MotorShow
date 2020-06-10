package com.service;

import com.DAO.AutoDAO;
import com.Salon.Auto;
import com.Salon.Selling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service //Слой бизнес-логики (также известен как уровень предметной области)
public class AutoService {

    @Autowired // пытается выполнить автоматическое подключение по типу, //
    //оно должно инициировать это свойство, используя метод setter//
    private AutoDAO autoDAO;

    public void setAutoDAO(AutoDAO autoDAO) {
        this.autoDAO = autoDAO;
    }

    @Transactional //Транзакция
    public List<Auto> listAuto() {
        return this.autoDAO.listAuto()
                .stream()
                .sorted(Comparator.comparingInt(Auto::getId))
                .collect(Collectors.toList());
    }

    @Transactional
    public void addAuto(Auto s) {
        this.autoDAO.addAuto(s);
    }
    @Transactional
    public void deleteAuto(Integer id_auto) {
        this.autoDAO.deleteAuto(id_auto);
    }
    @Transactional
    public void updateAuto(Auto s){
        this.autoDAO.updateAuto(s);
    }
    @Transactional
    public Auto getIdC(Integer id_auto){
        return this.autoDAO.getIdC(id_auto);
    }
}
