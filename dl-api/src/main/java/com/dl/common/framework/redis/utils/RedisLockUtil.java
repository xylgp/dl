package com.dl.common.framework.redis.utils;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class RedisLockUtil {
	
	
   /**
    * @Title: lock
    * @param jedis
    * @param key
    * @param lockTimeOut 锁的有效时间
    * @param perSleep 线程休眠时间
    * @return long 有效时间戳
    * @throws InterruptedException
    */
    public static long lock(Jedis jedis,String key, long lockTimeOut,long perSleep ) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        long sleep = (perSleep == 0 ? lockTimeOut / 10 : perSleep);
        long expireTime = 0;
        for(;;){
            expireTime = System.currentTimeMillis() + lockTimeOut + 1 ;
            if (jedis.setnx(key,String.valueOf(expireTime)) ==  1){
                return expireTime;
            } else {
                // 存在锁
                String curLockStr = jedis.get(key);
                //判断是否过期
                if (StringUtils.isBlank(curLockStr) || System.currentTimeMillis() > Long.valueOf(curLockStr)){
                    expireTime = System.currentTimeMillis() + lockTimeOut + 1 ;
                    curLockStr = jedis.getSet(key,String.valueOf(expireTime));
                    // 还是过期
                    if (StringUtils.isBlank(curLockStr) || System.currentTimeMillis() > Long.valueOf(curLockStr)) {
                        return expireTime;
                    } else {
                        Thread.sleep(sleep);
                    }
                } else {
                   Thread.sleep(sleep);
                }
            }
            // 如果锁的时间超时了
            if (lockTimeOut > 0 && System.currentTimeMillis() - startTime >= lockTimeOut){
                expireTime = 0 ;
                return expireTime;
            }
        }
    }
	
    /**
	 * @Title: tryLock
	 * @Description: 得不到锁立即返回，得到锁返回设置超时时间
	 * @param jedis
	 * @param key : 锁的Key
	 * @param lockTimeOut : 锁的有效时间
	 * @return
	 */
    public static long tryLock(Jedis jedis,String key,Long lockTimeOut){
        long expireTime = System.currentTimeMillis() + lockTimeOut + 1 ;
        // SETNX key val 当且仅当key不存在时，set一个key为val的字符串，返回1；若key存在，则什么都不做，返回0。
        if (jedis.setnx(key,String.valueOf(expireTime)) ==  1){
            //得到锁返回
            return expireTime;
        } else {
            // 存在锁
            String curLockStr = jedis.get(key);
            //判断是否过期
            if (StringUtils.isBlank(curLockStr) || System.currentTimeMillis() > Long.valueOf(curLockStr)){
                expireTime = System.currentTimeMillis() + lockTimeOut + 1 ;
                curLockStr = jedis.getSet(key,String.valueOf(expireTime));
                // 还是过期
                if (StringUtils.isBlank(curLockStr) || System.currentTimeMillis() > Long.valueOf(curLockStr)) {
                    return expireTime;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        }
    }
    
	/**
     * 
     * @Title: unlock
     * @Description: 先判断自己是否超过了锁的设置时间，是则不用解锁
     * @param jedis
     * @param key
     * @param expireTime 有效时间
     */
    public static void unlock(Jedis jedis,String key,long expireTime){
        if (System.currentTimeMillis() - expireTime > 0){
            return ;
        }
        String curLockStr = jedis.get(key);
        if (StringUtils.isNotBlank(curLockStr) || Long.valueOf(curLockStr) > System.currentTimeMillis()){
            jedis.del(key);
        }
        System.out.println(Thread.currentThread().getName()+"释放锁");
    }
	
	/**
     * @Title: releaseLock
     * @Description: 释放锁
     * @param jedis
     * @param key 锁的key
     * @param lockVersion 锁的版本
     * @return
     */
    public static boolean releaseLock(Jedis jedis,String key,String lockVersion){
        boolean flag = false;
        while (true){
            jedis.watch(key);
            // 如果存在key 则删除
            if (lockVersion.equals(jedis.get(key))) {
                Transaction transaction = jedis.multi();
                transaction.del(key);
                List<Object> exec = transaction.exec();
                if (exec == null){
                    continue;
                }
                flag = true;
            }
            // 解除watch
            jedis.unwatch();
            break;
        }
        return flag;
    }
}
