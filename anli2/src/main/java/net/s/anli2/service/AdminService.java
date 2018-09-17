package net.s.anli2.service;

import net.s.anli2.common.entity.Admin;



public interface AdminService {
    Admin findAdminNyName(String name);
    int addAdmin(Admin admin);
}
