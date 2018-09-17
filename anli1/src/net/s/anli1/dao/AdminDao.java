package net.s.anli1.dao;

import net.s.anli1.common.entity.Admin;

import java.util.List;

public interface AdminDao {
    Admin selectByname(String name);

    List<Admin> selectAll();

    int addadmin(Admin admin);
}
