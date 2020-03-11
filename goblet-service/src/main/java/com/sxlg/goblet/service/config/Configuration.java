package com.sxlg.goblet.service.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

public class Configuration {
    private final static Logger logger = LoggerFactory.getLogger(Configuration.class);
    private final String CONFIGURATION_PREFIX = "goblet.";
    private final String INSTANCE_NUMBER_SUFFIX = "instance.number";
    private final String TABLE_NUMBER_SUFFIX = "table.number";
    private final String TABLE_NAME_SUFFIX = "table.name";
    private String instanceNumber ;
    private String tableNumber;
    private String tableName;
    private HashMap<String, Property> propertys = new HashMap<String, Property>();




    public void load() {
        InputStream in = getClass().getClassLoader().getResourceAsStream("goblet.properties");
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            logger.error("The configuration file failed to load", e);
        }
        Iterator<Map.Entry<Object, Object>> it = properties.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Object, Object> property = it.next();
            String key = (String) property.getKey();
            if (key.startsWith(CONFIGURATION_PREFIX)) {
                if (key.endsWith(INSTANCE_NUMBER_SUFFIX)) {
                    instanceNumber = (String)property.getValue();
                } else if (key.endsWith(TABLE_NUMBER_SUFFIX)) {
                    tableNumber = (String)property.getValue();
                } else if (key.endsWith(TABLE_NAME_SUFFIX)) {
                    tableName = (String)property.getValue();
                }
            }
        }

    }

    public String getInstanceNumber() {
        return instanceNumber;
    }

    public void setInstanceNumber(String instanceNumber) {
        this.instanceNumber = instanceNumber;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }
    public String getTableName() {
        return tableName;
    }
}
