package net.s.anli1.dao;

import net.s.anli1.common.entity.Admin;
import net.s.anli1.common.util.IdGenerator;
import net.s.anli1.common.util.Md5utils;
import net.s.anli1.common.util.MyDbUtil;

import java.util.List;

public class AdminDaoImp implements AdminDao {
    @Override
    public Admin selectByname(String name) {

        String sql = "select id,aname 'username',ano 'password'  from admin where aname = ? ";
        List<Admin> admins = MyDbUtil.executeQuery(Admin.class, sql, name);
        if (admins.size() > 0) {
            return admins.get(0);
        }
        return null;
    }

    @Override
    public List<Admin> selectAll() {
        return MyDbUtil.executeQuery(Admin.class, "select id,aname,ano  from admin");
    }

    @Override
    public int addadmin(Admin admin) {
        String sql="insert into admin(id,aname,ano) values(?,?,?)";
        int i = MyDbUtil.executeUpdate(sql,IdGenerator.getId(),admin.getUsername(), Md5utils.md5(admin.getPassword()));
        if (i>0){
            return 1;
        }
        return 0;
    }
    /*public static void main(String[] args) {
        AdminDaoImp adminDaoImp = new AdminDaoImp();
        Admin admin = adminDaoImp.selectByname("wasd");
        System.out.println(admin);
    }*/
}
