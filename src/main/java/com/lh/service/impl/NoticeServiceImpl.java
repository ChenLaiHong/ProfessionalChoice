package com.lh.service.impl;

import com.lh.dao.NoticeMapper;
import com.lh.pojo.Notice;
import com.lh.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by laiHom on 2019/8/21.
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> getAll() {
        return noticeMapper.selectByExampleWithBLOBs(null);
    }
}
