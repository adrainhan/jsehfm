package org.hf.jsem.orm;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactory;
import org.hf.jsem.entity.IdField;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by adramer on 2016/10/25.
 */
public abstract class BaseDao<E, PK extends Serializable> extends SqlSessionDaoSupport implements EntityDao<E, PK> {
    protected final Log log = LogFactory.getLog(getClass());

    public abstract String getNamespace();

    @Override
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    protected void checkDaoConfig() {
        super.checkDaoConfig();
        Assert.notNull(getNamespace(), "Property 'namespace' are required");
    }

    @SuppressWarnings("unchecked")
    public E getById(PK primaryKey) {
        return (E) getSqlSession().selectOne(getFindByPrimaryKeyStatement(),
                primaryKey);
    }

    @SuppressWarnings("unused")
    public int deleteById(PK id) {
        return getSqlSession().delete(getDeleteStatement(), id);
    }

    @SuppressWarnings("unchecked")
    public int deleteByExample(Object exampleParam) {
        return getSqlSession().delete(getDeleteByExampleStatement(),
                exampleParam);
    }

    @SuppressWarnings("unused")
    public int save(E entity) {
        prepareObjectForSaveOrUpdate(entity);
        return getSqlSession().insert(getInsertStatement(), entity);
    }

    @SuppressWarnings("unused")
    public int saveSelective(E entity) {
        prepareObjectForSaveOrUpdate(entity);
        return getSqlSession().insert(getInsertStatement() + "Selective",
                entity);
    }

    @SuppressWarnings("unused")
    public int update(E entity) {
        prepareObjectForSaveOrUpdate(entity);
        return getSqlSession().update(getUpdateStatement(), entity);
    }

    @SuppressWarnings("unused")
    public int updateSelective(E entity) {
        prepareObjectForSaveOrUpdate(entity);
        return getSqlSession().update(getUpdateStatement() + "Selective",
                entity);
    }

    /**
     * 用于子类覆盖,在insert,update之前调用
     *
     * @param o
     */
    protected void prepareObjectForSaveOrUpdate(E o) {
    }

    public int saveOrUpdate(E entity) {
        int result = -1;
        Field[] fs = entity.getClass().getDeclaredFields();
        try {
            for (Field field : fs) {
                if (field.isAnnotationPresent(IdField.class)) {
                    field.setAccessible(true);
                    if (field.get(entity) == null)
                        result = save(entity);
                    else
                        result = update(entity);
                    field.setAccessible(false);
                }
            }
        } catch (Exception e) {
            throw new InvalidDataAccessApiUsageException(e.getMessage(),
                    e.getCause());
        }

        return result;
    }

    @SuppressWarnings("unchecked")
    public List<E> getAll() {
        return getSqlSession().selectList(getSelectByExampleStatement());
    }

    @SuppressWarnings("unchecked")
    public List<E> findAll(Object exampleParam) {
        return getSqlSession().selectList(getSelectByExampleStatement(),
                exampleParam);
    }

    @SuppressWarnings("unchecked")
    public List<E> findAll(String statement, Object param) {
        return getSqlSession().selectList(statement, param);
    }

    @SuppressWarnings("unchecked")
    public PageList<E> findPage(PageQuery pq, Object exampleParam) {
        return (PageList<E>) MybatisPageQueryUtils.pageQueryExample(
                getSqlSession(), getNamespace(), exampleParam, pq);
    }

    public PageList<E> findPage(String statement, PageQuery pq, Object param) {
        return findPage(statement, statement + ".count", pq, param);
    }

    @SuppressWarnings("unchecked")
    public PageList<E> findPage(String statement, String countStatement,
                                PageQuery pq, Object param) {
        return (PageList<E>) MybatisPageQueryUtils.pageQuery(getSqlSession(),
                statement, countStatement, param, pq);
    }

    @SuppressWarnings("unchecked")
    public E findOne(Object exampleParam) {
        return (E) getSqlSession().selectOne(getSelectByExampleStatement(),
                exampleParam);
    }

    public String getMybatisMapperNamesapce() {
        return this.getNamespace();
    }

    public String getFindByPrimaryKeyStatement() {
        return getMybatisMapperNamesapce() + ".selectByPrimaryKey";
    }

    public String getInsertStatement() {
        return getMybatisMapperNamesapce() + ".insert";
    }

    public String getUpdateStatement() {
        return getMybatisMapperNamesapce() + ".updateByPrimaryKey";
    }

    public String getDeleteStatement() {
        return getMybatisMapperNamesapce() + ".deleteByPrimaryKey";
    }

    public String getSelectByExampleStatement() {
        return getMybatisMapperNamesapce() + ".selectByExample";
    }

    public String getCountQueryStatement() {
        return getMybatisMapperNamesapce() + ".countByExample";
    }
    public String getWarningQueuesByUserId() {
        return getMybatisMapperNamesapce() + ".getWarningQueuesByUserId";
    }

    public String getDeleteByExampleStatement() {
        return getMybatisMapperNamesapce() + ".deleteByExample";
    }

    public boolean isUnique(E entity, String uniquePropertyNames) {
        throw new UnsupportedOperationException();
    }

    public void flush() {
        // ignore
    }
}
