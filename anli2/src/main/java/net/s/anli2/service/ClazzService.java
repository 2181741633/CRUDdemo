package net.s.anli2.service;


import net.s.anli2.common.entity.Clazz;
import net.s.anli2.common.utils.Pager;

import java.util.List;

public interface ClazzService {
    void addClazz(Clazz clazz);
    List<Clazz> findAllClazz();

    Pager<Clazz> findByPage(int pageNum, int pageSiz);

    void removeClazz(String... ids);
}
