package com.sxlg.goblet.data.hash;

import com.alibaba.fastjson.JSONArray;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HashTest {

    GeneralHashFunctionLibrary library = new GeneralHashFunctionLibrary();
    List<HashStatus> hashStatuses = new ArrayList<HashStatus>();
    static final int COUNT = 999999999;
    static int LENGTH = 10;
    static final int SLOT_QUANTITY = 32;
    @Test
    public void test(){
        Random random = new Random();
        long startTime = 0;
        long endTime = 0;
        double sum = 0;
        int  b = 1;
        HashStatus hashStatus = new HashStatus();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            if (i / b > 10){
                LENGTH += 10;
                b *= 10;
                System.out.println("length is: "+LENGTH);
            }
            hashStatus.getRate()[Calculate.mod(library.APHash(RandomStringUtils.randomAlphabetic(random.nextInt(LENGTH))),SLOT_QUANTITY)]++;
        }
        endTime = System.currentTimeMillis();
        hashStatus.setRunTime(endTime - startTime);
        hashStatus.setHashName("APHash");
        for (int i = 0; i < hashStatus.getRate().length; i++) {
            hashStatus.setHitRate(Calculate.mul(Calculate.div(hashStatus.getRate()[i], COUNT),100));
        }
        hashStatuses.add(hashStatus);


//        hashStatus = new HashStatus();
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < COUNT; i++) {
//            hashStatus.getRate()[Calculate.mod(library.BKDRHash(RandomStringUtils.randomAlphabetic(LENGTH)),SLOT_QUANTITY)]++;
//        }
//        endTime = System.currentTimeMillis();
//        hashStatus.setRunTime(endTime - startTime);
//        hashStatus.setHashName("BKDRHash");
//        for (int i = 0; i < hashStatus.getRate().length; i++) {
//            hashStatus.setHitRate(Calculate.mul(Calculate.div(hashStatus.getRate()[i], COUNT),100));
//        }
//        hashStatuses.add(hashStatus);


//        hashStatus = new HashStatus();
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < COUNT; i++) {
//            hashStatus.getRate()[Calculate.mod(library.BPHash(RandomStringUtils.randomAlphabetic(LENGTH)),SLOT_QUANTITY)]++;
//        }
//        endTime = System.currentTimeMillis();
//        hashStatus.setRunTime(endTime - startTime);
//        hashStatus.setHashName("BPHash");
//        for (int i = 0; i < hashStatus.getRate().length; i++) {
//            hashStatus.setHitRate(Calculate.mul(Calculate.div(hashStatus.getRate()[i], COUNT),100));
//        }
//        hashStatuses.add(hashStatus);
        b = 1;
        LENGTH = 10;
        hashStatus = new HashStatus();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < COUNT; i++) {
            if (i / b > 10){
                LENGTH += 10;
                b *= 10;
                System.out.println("length is: "+LENGTH);
            }
            hashStatus.getRate()[Calculate.mod(library.DEKHash(RandomStringUtils.randomAlphabetic(random.nextInt(LENGTH))),SLOT_QUANTITY)]++;
        }
        endTime = System.currentTimeMillis();
        hashStatus.setRunTime(endTime - startTime);
        hashStatus.setHashName("DEKHash");
        for (int i = 0; i < hashStatus.getRate().length; i++) {
            hashStatus.setHitRate(Calculate.mul(Calculate.div(hashStatus.getRate()[i], COUNT),100));
        }
        hashStatuses.add(hashStatus);


//        hashStatus = new HashStatus();
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < COUNT; i++) {
//            hashStatus.getRate()[Calculate.mod(library.DJBHash(RandomStringUtils.randomAlphabetic(LENGTH)),SLOT_QUANTITY)]++;
//        }
//        endTime = System.currentTimeMillis();
//        hashStatus.setRunTime(endTime - startTime);
//        hashStatus.setHashName("DJBHash");
//        for (int i = 0; i < hashStatus.getRate().length; i++) {
//            hashStatus.setHitRate(Calculate.mul(Calculate.div(hashStatus.getRate()[i], COUNT),100));
//        }
//        hashStatuses.add(hashStatus);
//
//        hashStatus = new HashStatus();
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < COUNT; i++) {
//            hashStatus.getRate()[Calculate.mod(library.ELFHash(RandomStringUtils.randomAlphabetic(LENGTH)),SLOT_QUANTITY)]++;
//        }
//        endTime = System.currentTimeMillis();
//        hashStatus.setRunTime(endTime - startTime);
//        hashStatus.setHashName("ELFHash");
//        for (int i = 0; i < hashStatus.getRate().length; i++) {
//            hashStatus.setHitRate(Calculate.mul(Calculate.div(hashStatus.getRate()[i], COUNT),100));
//        }
//        hashStatuses.add(hashStatus);
//
//        hashStatus = new HashStatus();
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < COUNT; i++) {
//            hashStatus.getRate()[Calculate.mod(library.FNVHash(RandomStringUtils.randomAlphabetic(LENGTH)),SLOT_QUANTITY)]++;
//        }
//        endTime = System.currentTimeMillis();
//        hashStatus.setRunTime(endTime - startTime);
//        hashStatus.setHashName("FNVHash");
//        for (int i = 0; i < hashStatus.getRate().length; i++) {
//            hashStatus.setHitRate(Calculate.mul(Calculate.div(hashStatus.getRate()[i], COUNT),100));
//        }
//        hashStatuses.add(hashStatus);
//
//
//        hashStatus = new HashStatus();
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < COUNT; i++) {
//            hashStatus.getRate()[Calculate.mod(library.FNVHashPro(RandomStringUtils.randomAlphabetic(LENGTH)),SLOT_QUANTITY)]++;
//        }
//        endTime = System.currentTimeMillis();
//        hashStatus.setRunTime(endTime - startTime);
//        hashStatus.setHashName("FNVHashPro");
//        for (int i = 0; i < hashStatus.getRate().length; i++) {
//            hashStatus.setHitRate(Calculate.mul(Calculate.div(hashStatus.getRate()[i], COUNT),100));
//        }
//        hashStatuses.add(hashStatus);
//
//
//        hashStatus = new HashStatus();
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < COUNT; i++) {
//            hashStatus.getRate()[Calculate.mod(library.JSHash(RandomStringUtils.randomAlphabetic(LENGTH)),SLOT_QUANTITY)]++;
//        }
//        endTime = System.currentTimeMillis();
//        hashStatus.setRunTime(endTime - startTime);
//        hashStatus.setHashName("JSHash");
//        for (int i = 0; i < hashStatus.getRate().length; i++) {
//            hashStatus.setHitRate(Calculate.mul(Calculate.div(hashStatus.getRate()[i], COUNT),100));
//        }
//        hashStatuses.add(hashStatus);
//
//        hashStatus = new HashStatus();
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < COUNT; i++) {
//            hashStatus.getRate()[Calculate.mod(library.PJWHash(RandomStringUtils.randomAlphabetic(LENGTH)),SLOT_QUANTITY)]++;
//        }
//        endTime = System.currentTimeMillis();
//        hashStatus.setRunTime(endTime - startTime);
//        hashStatus.setHashName("PJWHash");
//        for (int i = 0; i < hashStatus.getRate().length; i++) {
//            hashStatus.setHitRate(Calculate.mul(Calculate.div(hashStatus.getRate()[i], COUNT),100));
//        }
//        hashStatuses.add(hashStatus);
//
//        hashStatus = new HashStatus();
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < COUNT; i++) {
//            hashStatus.getRate()[Calculate.mod(library.RSHash(RandomStringUtils.randomAlphabetic(LENGTH)),SLOT_QUANTITY)]++;
//        }
//        endTime = System.currentTimeMillis();
//        hashStatus.setRunTime(endTime - startTime);
//        hashStatus.setHashName("RSHash");
//        for (int i = 0; i < hashStatus.getRate().length; i++) {
//            hashStatus.setHitRate(Calculate.mul(Calculate.div(hashStatus.getRate()[i], COUNT),100));
//        }
//        hashStatuses.add(hashStatus);
//
//        hashStatus = new HashStatus();
//        startTime = System.currentTimeMillis();
//        for (int i = 0; i < COUNT; i++) {
//            hashStatus.getRate()[Calculate.mod(library.SDBMHash(RandomStringUtils.randomAlphabetic(LENGTH)),SLOT_QUANTITY)]++;
//        }
//        endTime = System.currentTimeMillis();
//        hashStatus.setRunTime(endTime - startTime);
//        hashStatus.setHashName("SDBMHash");
//        for (int i = 0; i < hashStatus.getRate().length; i++) {
//            hashStatus.setHitRate(Calculate.mul(Calculate.div(hashStatus.getRate()[i], COUNT),100));
//        }
//        hashStatuses.add(hashStatus);


        Object o = JSONArray.toJSON(hashStatuses);
        String string = o.toString();
        System.out.println(string);
    }
}
