package service;

import dao.Crud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/10/23 0023.
 */
@Component
public class Service {
    @Autowired
    Crud crud;
    public String get(){
        return crud.getName();
    }
}
