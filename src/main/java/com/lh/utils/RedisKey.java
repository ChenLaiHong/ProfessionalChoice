package com.lh.utils;

/**
 * <p>Description: 保存项目redis的key前缀</p>
 *
 */
public class RedisKey {

    /**
     * 缓存选课任务哈希集合的Key
     */
    public static final String CHOICE_TASK = "choiceTask";

    /**
     * 缓存用户信息的哈希集合Key
     */
    public static final String USER = "user";

    /**
     * 缓存用户的选择方向信息的哈希集合Key
     */
    public static final String USER_CHOICE = "userChoice";

    /**
     * 方向限制人数前缀
     */
    public static final String DIRECTION_LIMIT = "directionLimit_";

    /**
     * 方向已选人数前缀
     */
    public static final String DIRECTION_SELECTED = "directionSelected_";
}
