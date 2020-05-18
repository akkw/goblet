package com.sxlg.goblet.store.service.route;

import com.sxlg.goblet.store.service.config.Configuration;
import com.sxlg.goblet.store.service.core.GobletMySqlTopology;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;

public class RouterConfig {
    private static final Logger logger = LoggerFactory.getLogger(RouterConfig.class);
    private  int instanceNumber;
    private GobletMySqlTopology topology = null;
    private BlockingQueue<ByteBuffer> dataQueue = null;
    private int slotNumber;
    private String tableKp;
    private String routerKey;
    public int getInstanceNumber() {
        return instanceNumber;
    }

    public String getRouterKey() {
        return routerKey;
    }

    public void setInstanceNumber(int instanceNumber) {
        this.instanceNumber = instanceNumber;
    }

    public String getTableKp() {
        return tableKp;
    }

    public void setTableKp(String tableKp) {
        this.tableKp = tableKp;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public RouterConfig(BlockingQueue<ByteBuffer> queue, Configuration configuration) {
        this.dataQueue = queue;
        this.topology = GobletMySqlTopology.build(configuration);
        this.tableKp = configuration.getTablePk();
        this.slotNumber = Integer.parseInt(configuration.getTableNumber());
        this.instanceNumber = Integer.parseInt(configuration.getInstanceNumber());
        this.routerKey = configuration.getRouterKey();
        logger.info("table name prefix is: {}, table number for: {}, instance number for: {}",
                configuration.getTableName(),
                configuration.getTableNumber(),
                configuration.getInstanceNumber());
    }

    public BlockingQueue<ByteBuffer> getDataQueue() {
        return dataQueue;
    }

    public GobletMySqlTopology getTopology(){
        return topology;
    }
}
