package com.example.stars.service;

import com.example.stars.IDao.IDao;
import com.example.stars.beans.Star;

import java.util.ArrayList;
import java.util.List;

public class StarService implements IDao <Star> {
    private List<Star> stars;
    private  static  StarService instance;
    public StarService() {
        this.stars = new ArrayList<>();
    }

    public static synchronized StarService getInstance() {
        if (instance==null){
            instance =new StarService();
        }
        return instance;
    }
    @Override
    public boolean creat(Star o) {
        return stars.add(o);
    }

    @Override
    public boolean update(Star o) {
        for(Star s : stars){
            if (s.getId()==o.getId()){
                s.setName(o.getName());
                s.setImg(o.getImg());
                s.setStar(o.getStar());
                return  true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(Star o) {
        return stars.remove(o);
    }

    @Override
    public Star findById(int id) {
        for ( Star s : stars){
            if (s.getId()==id){
                return  s;
            }
        }
        return  null;
    }

    @Override
    public List<Star> findAll() {
        return new ArrayList<>(stars);
    }
}
