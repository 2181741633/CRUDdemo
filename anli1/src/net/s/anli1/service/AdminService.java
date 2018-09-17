package net.s.anli1.service;

import net.s.anli1.common.entity.Admin;

public interface AdminService {
    Admin findByname(String name);

    int insertAdmin(Admin admin);
}
