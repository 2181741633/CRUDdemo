package net.s.anli2.dao;

import net.s.anli2.common.entity.Clazz;
import net.s.anli2.common.utils.Pager;

import java.util.List;

public interface ClazzDao {
    void insertClazz(Clazz clazz);

    List<Clazz> selectAllClazz();

    Pager<Clazz> selectByPage(int pageNum, int pageSiz);

    void delClazz(String[] ids);
}
