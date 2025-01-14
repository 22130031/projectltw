package com.banthatlung.services;

import com.banthatlung.Dao.ProductDao;
import com.banthatlung.Dao.model.Product;

import java.util.List;

public class ProductService {
    static ProductDao productDao = new ProductDao();

    public static Product getById(int id) {
        return productDao.getById(id);
    }


    public List<Product> getAll() {
        return productDao.getAll();
    }

    public List<Product> getAll(int page, int pageSize) {
        return productDao.getAll( page, pageSize);
    }

    public Product getDetail(String in) {
        try {
            int id = Integer.parseInt(in);
            return productDao.getById(id);
        } catch (NumberFormatException e) {
            return null;
        }

    }

    public List<Product> search(String in) {
        return productDao.search(in);
    }

    public int getTotalProductCount() {
        return productDao.getTotalProductCount();
    }
}
