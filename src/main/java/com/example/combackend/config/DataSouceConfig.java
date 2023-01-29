package com.example.combackend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@ComponentScan
public class DataSouceConfig {

    @Bean
    @Primary
    public DataSource dataSource(@Value("${spring.datasource.url}") String host,@Value("${spring.datasource.username}")
                                 String username,@Value("${spring.datasource.password}") String password){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl(host);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;

    }


}
