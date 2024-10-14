package com.example.stars.IDao;

import java.util.List;

public interface IDao <T>{
   boolean creat(T o);
   boolean update(T o);
   boolean delete(T o);
   T findById(int id);
   List<T> findAll();


}
