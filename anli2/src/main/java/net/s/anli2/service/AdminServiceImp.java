package net.s.anli2.service;

import net.s.anli2.common.entity.Admin;
import net.s.anli2.dao.AdminDao;
import net.s.anli2.dao.AdminDaoImp;

public class AdminServiceImp implements AdminService {
    private AdminDao adminDao;
    public AdminServiceImp(){
        this.adminDao=new AdminDaoImp();
    }
    @Override
    public Admin findAdminNyName(String name) {
        return adminDao.selectUerByName(name);
    }

    @Override
    public int addAdmin(Admin admin) {
        return adminDao.insertAdmin(admin);
    }
}
