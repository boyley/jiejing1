package org.springframework.data.mybatis.repository.query;

import org.springframework.data.projection.SpelAwareProxyProjectionFactory;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.data.repository.query.QueryMethod;
import org.springframework.util.Assert;

import java.lang.reflect.Method;

public class MyBatisQueryMethod extends QueryMethod {

    private final Class<?> mapperInterface;
    private final Method method;

    public MyBatisQueryMethod(Method method, RepositoryMetadata metadata) {
        super(method, metadata, new SpelAwareProxyProjectionFactory());
        Assert.notNull(method, "Method must not be null!");
        Assert.notNull(metadata, "RepositoryMetadata must not be null!");
        this.method = method;
        mapperInterface = metadata.getRepositoryInterface();
    }

    public String getMappedStatementId() {
        return mapperInterface.getName() + "." + method.getName();
    }

    public Class<?> getRepositoryInterface() {
        return mapperInterface;
    }

    public Method getMethod() {
        return method;
    }

    public String getNamedQueryName() {
        return null;
    }
}
