package com.banthatlung.services;

import com.banthatlung.Dao.UserDao;
import com.banthatlung.Dao.db.User;

public class AuthService {
    public User checkLogin(String username, String pass){
        UserDao dao = new UserDao();
        User u = dao.findUser(username);
        if(u != null && pass.equals(u.getPass())){
            u.setPass(null);
            return u;
        }
        return null;
    }
}
