package com.lh.service.impl;

import com.lh.dao.NoticeMapper;
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

        return noticeMapper.updateByPrimaryKeySelective(notice);
    }

    @Override
    public int delete(String[] idsStr) {
        NoticeExample example = new NoticeExample();
        NoticeExample.Criteria criteria = example.createCriteria();
        criteria.andNoticeIdIn(StringIds(idsStr));
        return noticeMapper.deleteByExample(example);
    }

    @Override
    public List<Objects> searchList(Map<String, Object> listFirst) {
        return noticeMapper.searchList(listFirst);
    }

    @Override
    public Long getSearchTotal(Map<String, Object> listFirst) {
        return noticeMapper.getSearchTotal(listFirst);
    }

    @Override
    public List<Notice> listF(Map<String, Object> map) {
        return noticeMapper.listF(map);
    }

    @Override
    public Integer getTotalF(Map<String, Object> map) {
        return noticeMapper.getTotalF(map);
    }

    @Override
    public Notice findById(int i) {
        return noticeMapper.selectByPrimaryKey(i);
    }




}
