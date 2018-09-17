package net.s.anli2.dao;

import net.s.anli2.common.entity.Admin;
import net.s.anli2.common.utils.MyDbUtil;

import java.util.List;

public class AdminDaoImp implements AdminDao {
    @Override
    public Admin selectUerByName(String name) {
        String sql = " select id,aname 'name',ano 'password' from admin where aname=? ";
        List<Admin> admins = MyDbUtil.executeQuery(Admin.class, sql, name);
        if (admins.size() > 0) {
            return admins.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Admin> sllectAllAdmin() {
        String sql = " select id,aname 'name',ano 'password' from admin ";
        List<Admin> admins = MyDbUtil.executeQuery(Admin.class, sql);
        return admins;
    }

    @Override
    public int insertAdmin(Admin admin) {
        String sql = " insert into admin(id,aname,ano) values(?,?,?) ";
        int i = MyDbUtil.executeUpdate(sql,admin.getId(),admin.getName(),admin.getPassword());
        if (i > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
