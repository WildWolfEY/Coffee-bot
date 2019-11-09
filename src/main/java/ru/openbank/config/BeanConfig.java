package ru.openbank.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Елена on 07.11.2019.
 */
@Configuration
public class BeanConfig {
    @Bean(value = "storagePathIgnite")
    public String storagePathIgnite() {
        return "D:/Удалить/Ignite";
    }

    @Bean(value = "walPathIgnite")
    public String walPathIgnite() {
        return "D:/Удалить/Ignite/wal";
    }


    @Bean( value = "archivePathIgnite")
    public String archivePathIgnite()
    {
        return"D:/Удалить/Ignite/arch";
    }

    @Bean(value = "cacheName")
    public String cacheName(){
        return "persons";
    }
}
