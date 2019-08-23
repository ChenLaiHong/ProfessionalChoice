package com.lh.service.impl;

import com.lh.dao.NoticeMapper;
import com.lh.pojo.MajorExample;
import com.lh.pojo.Notice;
import com.lh.pojo.NoticeExample;
import com.lh.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import static com.lh.utils.CommentUtils.StringIds;

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

    @Override
    public List<Objects> list(Map<String, Object> map) {
        return noticeMapper.list(map);
    }

    @Override
    public Long getTotal(Map<String, Object> map) {
        return noticeMapper.getTotal(map);
    }

    @Override
    public int addNotice(Notice notice) {
        return noticeMapper.insertSelective(notice);
    }

    @Override
    public int updateNotice(Notice notice) {

        return noticeMapper.updateByPrimaryKeyWithBLOBs(notice);
    }

    @Override
    public int delete(String[] idsStr) {
        NoticeExample example = new NoticeExample();
        NoticeExample.Criteria criteria = example.createCriteria();
        criteria.andNoticeIdIn(StringIds(idsStr));
        return noticeMapper.deleteByExample(example);
    }
}
