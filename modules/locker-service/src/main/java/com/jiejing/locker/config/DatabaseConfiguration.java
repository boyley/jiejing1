package com.jiejing.locker.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Bogle on 2016/8/29.
 */
@Configuration
@EnableJpaRepositories("com.jiejing.locker.repository")
@EnableTransactionManagement
public class DatabaseConfiguration {
}
