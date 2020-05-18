package com.sxlg.goblet.store.service.core;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MySqlInstancePool {
    private int initialSize = 0;
    volatile private int nextInstanceOrdinal = 0;

    private ConcurrentMap<Integer, DruidDataSource> instancePool = null;

    public MySqlInstancePool(int size) {
        this.initialSize = size;
        this.instancePool = new ConcurrentHashMap<Integer, DruidDataSource>(initialSize);
    }

    public DruidDataSource getInstance(int id) {
        return instancePool.get(id);
    }

    public int getInstanceSize() {
        return nextInstanceOrdinal;
    }

    /**
     * 构建实例池
     */
    public void build() {
        ApplicationContext app = new ClassPathXmlApplicationContext("druid.xml");
        Map<String, DruidDataSource> beansOfType = app.getBeansOfType(DruidDataSource.class);
        Iterator<Map.Entry<String, DruidDataSource>> it = beansOfType.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, DruidDataSource> next = it.next();
            DruidDataSource dds = next.getValue();
            this.instancePool.put(nextInstanceOrdinal++, dds);
        }
    }

}
