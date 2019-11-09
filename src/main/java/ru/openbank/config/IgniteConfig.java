package ru.openbank.config;

import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.DataStorageConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.net.UnknownHostException;

/**
 * Created by Елена on 07.11.2019.
 */
@Component
public class IgniteConfig {
    @Autowired
    @Qualifier("storagePathIgnite")
    String storagePathIgnite;


    @Autowired
    @Qualifier("walPathIgnite")
    String walPathIgnite;


    @Autowired
    @Qualifier("archivePathIgnite")
    String archivePathIgnite;


    public IgniteConfiguration getConfig() throws UnknownHostException {
        IgniteConfiguration config = new IgniteConfiguration();
        DataStorageConfiguration dsConfig = new DataStorageConfiguration();

        dsConfig.setStoragePath(storagePathIgnite);
        dsConfig.setWalPath(walPathIgnite);
        dsConfig.setWalArchivePath(archivePathIgnite);
        dsConfig.getDefaultDataRegionConfiguration().setPersistenceEnabled(true);
        config.setDataStorageConfiguration(dsConfig);

        Ignition.setClientMode(false);
        config.setConsistentId(java.net.InetAddress.getLocalHost().getHostName());
        return config;
    }
}
