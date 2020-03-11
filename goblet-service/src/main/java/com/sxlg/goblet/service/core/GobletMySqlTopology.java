package com.sxlg.goblet.service.core;

import com.sxlg.goblet.service.config.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class GobletMySqlTopology {
    private static final Logger logger = LoggerFactory.getLogger(GobletMySqlTopology.class);
    private ConcurrentMap<Integer, String> tableMap = new ConcurrentHashMap<Integer, String>();
    private MySqlInstancePool instancePool = null;

    private GobletMySqlTopology(Configuration configuration){
        int slotSize = Integer.parseInt(configuration.getTableNumber());
        if (slotSize <= 0) {
            logger.warn("the number of tables is less than {}", slotSize);
        }
        for (int i = 0; i < slotSize; i++) {
            tableMap.put(i, configuration.getTableName() + "_" + i);
        }
        instancePool = new MySqlInstancePool(Integer.parseInt(configuration.getInstanceNumber()));
        instancePool.build();
    }

    public static GobletMySqlTopology build(Configuration configuration) {

        return new GobletMySqlTopology(configuration);
    }

    public MySqlInstancePool getInstancePool() {
        return instancePool;
    }
}
