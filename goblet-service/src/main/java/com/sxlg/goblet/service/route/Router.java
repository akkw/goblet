package com.sxlg.goblet.service.route;

import com.sxlg.goblet.route.Route;
import com.sxlg.goblet.service.config.Configuration;
import com.sxlg.goblet.service.core.GobletMySqlTopology;
import com.sxlg.goblet.service.core.MySqlInstancePool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;

public class Router {
    private static final Logger logger = LoggerFactory.getLogger(Router.class);
    private GobletMySqlTopology topology = null;
    private MySqlInstancePool instancePool = null;
    private BlockingQueue<ByteBuffer> dataQueue = null;
    public Router(BlockingQueue<ByteBuffer> queue, Configuration configuration) {
        this.dataQueue = queue;
        topology = GobletMySqlTopology.build(configuration);
        instancePool = topology.getInstancePool();
        logger.info("instance pool size is: {},table name prefix is: {}, table number for: {}",
                instancePool.getInstanceSize(), configuration.getTableName(),
                configuration.getTableNumber());
    }

}
