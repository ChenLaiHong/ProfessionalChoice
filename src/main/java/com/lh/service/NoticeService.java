package com.lh.service;

import com.lh.pojo.Notice;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Created by laiHom on 2019/8/21.
 */
public interface NoticeService {
    List<Notice> getAll();

    List<Objects> list(Map<String, Object> map);

    Long getTotal(Map<String, Object> map);

    int addNotice(Notice notice);

    int updateNotice(Notice notice);

    int delete(String[] idsStr);
}
