package org.hf.jsem.orm;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by adramer on 2016/10/25.
 */
public class MybatisPageQueryUtils {
    public static PageList<?> pageQueryExample(SqlSession sqlSession, String namespace, Object exampleParam,
                                               PageQuery pq) {
        return pageQuery(sqlSession, namespace + ".selectByExample", namespace + ".countByExample", exampleParam,
                pq.getPage(), pq.getRows());
    }

    public static PageList<?> pageQueryExample(SqlSession sqlSession, String namespace, Object exampleParam,
                                               int page, int rows) {
        return pageQuery(sqlSession, namespace + ".selectByExample", namespace + ".countByExample", exampleParam,
                page, rows);
    }

    public static PageList<?> pageQuery(SqlSession sqlSession, String statement, String countStatement,
                                        Object parameter, PageQuery pq) {
        return pageQuery(sqlSession, statement, countStatement, parameter, pq.getPage(), pq.getRows());
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static PageList<?> pageQuery(SqlSession sqlSession, String statement, String countStatement,
                                        Object parameter, int page, int rows) {
        Assert.isTrue(rows > 0, "pageSize > 0 must be true");
        Number totalItems = (Number) sqlSession.selectOne(countStatement, parameter);

        if (totalItems != null && totalItems.intValue() > 0) {
            Paginator paginator = new Paginator(page, rows, totalItems.intValue());
            List list = sqlSession.selectList(statement, parameter,
                    new RowBounds(paginator.getOffset(), paginator.getLimit()));
            return new PageList(list, paginator);
        }

        return new PageList(0, rows, 0);//no totalItems have
    }

    @SuppressWarnings({ "rawtypes", "unchecked", "unused" })
    private static Map attachPageQueryVariable(Object parameter, Paginator p) {
        Map map = toParameterMap(parameter);
        map.put("startRow", p.getStartRow());
        map.put("endRow", p.getEndRow());
        map.put("offset", p.getOffset());
        map.put("limit", p.getLimit());
        return map;
    }

    @SuppressWarnings({ "rawtypes" })
    private static Map toParameterMap(Object parameter) {
        if (parameter instanceof Map) {
            return (Map) parameter;
        } else {
            try {
                return PropertyUtils.describe(parameter);
            } catch (Exception e) {
                ReflectionUtils.handleReflectionException(e);
                return null;
            }
        }
    }
}
