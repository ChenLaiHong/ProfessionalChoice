package com.lh.interceptor;

import com.lh.pojo.Person;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * <p>Description: 用于保存用户请求过程中产生的部分数据</p>
 *
 */
@Data
@Component
public class RequestHolder {

    private static ThreadLocal<Person> personThreadLocal = new ThreadLocal<>();

    public void setPerson(Person person) {
        personThreadLocal.set(person);
    }

    public Person getPerson() {
        return personThreadLocal.get();
    }

    /**
     * 清除线程缓存
     */
    public void clear() {
        personThreadLocal.remove();
    }
}
