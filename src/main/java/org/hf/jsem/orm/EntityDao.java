package org.hf.jsem.orm;

import java.io.Serializable;
import java.util.List;

/**
 * Created by adramer on 2016/10/25.
 */
public interface EntityDao<E, PK extends Serializable> {

    Object getById(PK id);

    int deleteById(PK id);

    int deleteByExample(Object exampleParam);

    int save(E entity);

    int saveSelective(E entity);


    int update(E entity);

    int updateSelective(E entity);

    int saveOrUpdate(E entity);

    List<E> getAll();

    List<E> findAll(Object exampleParam);

    List<E> findAll(String statement, Object param);

    E findOne(Object exampleParam);

    PageList<E> findPage(PageQuery pq, Object exampleParam);

    PageList<E> findPage(String statement, String countStatement, PageQuery pq, Object param);

}
