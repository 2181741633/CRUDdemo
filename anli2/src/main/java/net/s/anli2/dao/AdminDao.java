package net.s.anli2.dao;

import net.s.anli2.common.entity.Admin;

import java.util.List;

public interface AdminDao {
    Admin selectUerByName(String name);
    List<Admin> sllectAllAdmin();

    int insertAdmin(Admin admin);
}
