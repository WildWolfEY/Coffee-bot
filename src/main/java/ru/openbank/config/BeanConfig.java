package ru.openbank.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ����� on 07.11.2019.
 */
@Configuration
public class BeanConfig {
    @Bean(value = "storagePathIgnite")
    public String storagePathIgnite() {
        return "D:/�������/Ignite";
    }

    @Bean(value = "walPathIgnite")
    public String walPathIgnite() {
        return "D:/�������/Ignite/wal";
    }


    @Bean( value = "archivePathIgnite")
    public String archivePathIgnite()
    {
        return"D:/�������/Ignite/arch";
    }

    @Bean(value = "cacheName")
    public String cacheName(){
        return "persons";
    }
}
