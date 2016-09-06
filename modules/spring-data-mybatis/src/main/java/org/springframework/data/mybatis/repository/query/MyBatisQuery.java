package org.springframework.data.mybatis.repository.query;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.data.mapping.model.MappingException;
import org.springframework.data.repository.query.Parameter;
import org.springframework.data.repository.query.Parameters;
import org.springframework.data.repository.query.QueryMethod;
import org.springframework.data.repository.query.RepositoryQuery;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Binds spring Repository methods with mybatis mapper
 */
public class MyBatisQuery implements RepositoryQuery {

    private final MyBatisQueryMethod queryMethod;
    private final SqlSessionTemplate sessionTemplate;

    public MyBatisQuery(MyBatisQueryMethod queryMethod, SqlSessionTemplate sessionTemplate) {
        Assert.notNull(queryMethod);
        Assert.notNull(sessionTemplate);
        this.queryMethod = queryMethod;
        this.sessionTemplate = sessionTemplate;
    }

    @Override
    public Object execute(Object[] parameters) {
        String mappedStatementId = queryMethod.getMappedStatementId();
        boolean hasStatement = sessionTemplate.getConfiguration().hasStatement(mappedStatementId);
        if (hasStatement) {
            return executeFromMapper(mappedStatementId, parameters);
        }
        throw new MappingException("can not find mapped statement for method : " + queryMethod.getName());
        // TODO  PartTree Auto create mapped statement.
    }

    private Object executeFromMapper(String mappedStatementId, Object[] parameters) {
        Map<String, Object> params = new HashMap<String, Object>();
        Parameters<?, ?> methodParameters = queryMethod.getParameters();
        if (null != methodParameters) {
            Iterator<? extends Parameter> iterator = methodParameters.iterator();
            while (iterator.hasNext()) {
                Parameter parameter = iterator.next();
                params.put(parameter.getName(), parameters[parameter.getIndex()]);
            }
        }
        if (queryMethod.isStreamQuery()) {
        } else if (queryMethod.isSliceQuery()) {
        } else if (queryMethod.isCollectionQuery()) {
            return sessionTemplate.selectList(mappedStatementId, params);
        } else if (queryMethod.isPageQuery()) {
        } else if (queryMethod.isQueryForEntity()) {
            return sessionTemplate.selectOne(mappedStatementId, params);
        }

        return sessionTemplate.selectOne(mappedStatementId, params);

    }


    @Override
    public QueryMethod getQueryMethod() {
        return queryMethod;
    }
}
