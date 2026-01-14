package com.inn.cafe.cafebackend.serviceImpl;

import com.inn.cafe.cafebackend.dao.BillDao;
import com.inn.cafe.cafebackend.dao.CategoryDao;
import com.inn.cafe.cafebackend.dao.ProductDao;
import com.inn.cafe.cafebackend.service.DashboardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DashboardServiceImpl implements DashboardService {

    CategoryDao categoryDao;
    ProductDao productDao;
    BillDao billDao;

    DashboardServiceImpl(CategoryDao categoryDao, ProductDao productDao, BillDao billDao) {
        this.categoryDao = categoryDao;
        this.productDao = productDao;
        this.billDao = billDao;
    }

    @Override
    public ResponseEntity<Map<String, Object>> getCount() {
        Map<String, Object> map = new HashMap<>();
        map.put("category", categoryDao.count());
        map.put("product", productDao.count());
        map.put("bill", billDao.count());
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
