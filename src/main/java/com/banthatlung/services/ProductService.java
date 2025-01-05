package com.banthatlung.services;

import com.banthatlung.Dao.ProductDao;
import com.banthatlung.Dao.model.Product;

import java.util.List;

public class ProductService {
    static ProductDao productDao = new ProductDao();

    public static Product getById(int id) {
        return productDao.getbyId(id);
    }

    public List<Product> getAll() {
        return productDao.getAll();
    }

    public Product getDetail(String in) {
        try {
            int id = Integer.parseInt(in);
            return productDao.getbyId(id);
        } catch (NumberFormatException e) {
            return null;
        }

    }
}
