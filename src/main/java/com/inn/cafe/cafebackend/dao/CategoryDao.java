package com.inn.cafe.cafebackend.dao;

import com.inn.cafe.cafebackend.POJO.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryDao  extends JpaRepository<Category,Integer> {

    List<Category> getAllCategory();
}
