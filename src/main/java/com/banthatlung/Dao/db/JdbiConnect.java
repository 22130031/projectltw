package com.banthatlung.Dao.db;

import com.banthatlung.Dao.model.Product;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.jdbi.v3.core.Jdbi;

import java.sql.SQLException;
import java.util.List;

public class JdbiConnect {
    static String url = "jdbc:mysql://"+DBProperties.host()+":"+DBProperties.port()+"/"+DBProperties.dbName()+"?"+DBProperties.option();
    static Jdbi jdbi;

    public static Jdbi get() {
        if (jdbi == null) makeConnect();
        return jdbi;
    }
    private static void makeConnect() {
        MysqlDataSource src = new MysqlDataSource();
        src.setURL(url);
        src.setUser(DBProperties.username());
        src.setPassword(DBProperties.password());

        try {
            src.setUseCompression(true);
            src.setAutoReconnect(true);
        } catch (SQLException e) {
        }
        jdbi = Jdbi.create(src);
    }

    public static void main(String[] args) {
        Jdbi j = get();
        List<Product> products = j.withHandle(handle -> {
            return handle.createQuery("select * from san_pham").mapToBean(Product.class).list();
        });
    System.out.println(products);
    }
}
