package net.s.anli2.dao;

import net.s.anli2.common.entity.Clazz;
import net.s.anli2.common.utils.MyDbUtil;
import net.s.anli2.common.utils.Pager;
import net.s.anli2.common.utils.ValueObj;

import java.util.List;

public class ClzaaDaoImp implements ClazzDao {
    @Override
    public void insertClazz(Clazz clazz) {
        String sql = " insert into class(c_id,c_name,c_num,c_teacher,create_time) values(?,?,?,?,?) ";
        MyDbUtil.executeUpdate(sql, clazz.getId(), clazz.getName(), clazz.getCount(), clazz.getTeacher(), clazz.getCreateTime());
    }

    @Override
    public List<Clazz> selectAllClazz() {
        String sql = " select c_id 'id',c_name 'name',c_num 'count',c_teacher 'teacher',create_time 'createTime' from class ";

        List<Clazz> clazzes = MyDbUtil.executeQuery(Clazz.class, sql);
        return clazzes;
    }

    @Override
    public Pager<Clazz> selectByPage(int pageNum, int pageSiz) {
        String sql = " select c_id 'id',c_name 'name',c_num 'count',c_teacher 'teacher',create_time 'createTime' from class " +
                " limit ?,? ";
        List<Clazz> clazzes = MyDbUtil.executeQuery(Clazz.class, sql, (pageNum - 1) * pageSiz, pageSiz);


        String sql1 = " select count(*) 'value' from class "; //查询总数
        List<ValueObj> valueObjs = MyDbUtil.executeQuery(ValueObj.class, sql1);
        int count = (int) (valueObjs.get(0).getValue().longValue());
        Pager<Clazz> clazzPager = new Pager<Clazz>(count, pageNum, pageSiz, clazzes);
        return clazzPager;
    }

    @Override
    public void delClazz(String[] ids) {
        String sql = " delete from class where c_id in ( ";
        for (int i = 0; i < ids.length; i++) {
            if (i == ids.length - 1) {
                sql = sql + " ?";
            } else {
                sql = sql + " ?,";
            }
        }
        sql = sql + " ) ";
        MyDbUtil.executeUpdate(sql,ids);
    }
}
