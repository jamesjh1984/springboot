package com.jin.springboot.service;

import com.jin.springboot.entity.Website;

import java.util.List;

public interface WebsiteService {

    public List<Website> getAll();

    public void add(Website website);

    public void updateById(Website website);

    public void deleteById(Integer id);

    public Website getById(Integer id);

    public Website getByName(String name);

}
