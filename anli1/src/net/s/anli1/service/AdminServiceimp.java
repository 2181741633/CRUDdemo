package net.s.anli1.service;

import net.s.anli1.common.entity.Admin;
import net.s.anli1.dao.AdminDao;
import net.s.anli1.dao.AdminDaoImp;

public class AdminServiceimp implements AdminService {

    private AdminDao adminDao;

    public AdminServiceimp(){
        this.adminDao=new AdminDaoImp();
    }

    @Override
    public Admin findByname(String name) {
        return adminDao.selectByname(name);
    }
    public int insertAdmin(Admin admin){
        return adminDao.addadmin(admin);
    }
}
