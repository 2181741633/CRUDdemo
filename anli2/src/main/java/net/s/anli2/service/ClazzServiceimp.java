package net.s.anli2.service;

import net.s.anli2.common.entity.Clazz;
import net.s.anli2.common.utils.Pager;
import net.s.anli2.dao.ClazzDao;
import net.s.anli2.dao.ClzaaDaoImp;

import java.util.List;

public class ClazzServiceimp implements ClazzService{
    public ClazzDao clazzDao;
    public ClazzServiceimp(){
        this.clazzDao = new ClzaaDaoImp();
    }

    @Override
    public void addClazz(Clazz clazz) {
        clazzDao.insertClazz(clazz);
    }

    @Override
    public List<Clazz> findAllClazz() {
        return clazzDao.selectAllClazz();
    }

    @Override
    public Pager<Clazz> findByPage(int pageNum, int pageSiz) {
        return clazzDao.selectByPage(pageNum,pageSiz);
    }

    @Override
    public void removeClazz(String... ids) {
        clazzDao.delClazz(ids);
    }
}
