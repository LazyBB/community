package com.bbdemo.service;

import com.bbdemo.dto.NoticeDTO;
import com.bbdemo.dto.PaginationDTO;
import com.bbdemo.enums.NoticeEnum;
import com.bbdemo.enums.NoticeStatusEnum;
import com.bbdemo.mapper.NoticeMapper;
import com.bbdemo.model.Notice;
import com.bbdemo.model.NoticeExample;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NoticeService {
    @Autowired
    NoticeMapper noticeMapper;
    public PaginationDTO List(Long userId, Integer page, Integer size) {

        PaginationDTO<NoticeDTO> paginationDTO = new PaginationDTO<>();

        Integer totalPage;

        NoticeExample noticeExample = new NoticeExample();
        noticeExample.createCriteria()
                .andReceiverEqualTo(userId);
        Integer totalCount = (int) noticeMapper.countByExample(noticeExample);

        if (totalCount % size == 0) {
            totalPage = totalCount / size;
        } else {
            totalPage = totalCount / size + 1;
        }

        if (page < 1) {
            page = 1;
        }
        if (page > totalPage) {
            page = totalPage;
        }

        paginationDTO.setpagination(totalPage, page);

        //size*(page-1)
        Integer offset = size * (page - 1);
        NoticeExample example = new NoticeExample();
        example.createCriteria()
                .andReceiverEqualTo(userId);
        example.setOrderByClause("gmt_create desc");

        List<Notice> notifications = noticeMapper.selectByExampleWithRowbounds(example, new RowBounds(offset, size));

        if (notifications.size() == 0) {
            return paginationDTO;
        }

        List<NoticeDTO> notificationDTOS = new ArrayList<>();

        for (Notice notice : notifications) {
            NoticeDTO noticeDTO = new NoticeDTO();
            BeanUtils.copyProperties(notice, noticeDTO);
            noticeDTO.setTypeName(NoticeEnum.nameOfType(notice.getType()));
            notificationDTOS.add(noticeDTO);
        }
        paginationDTO.setData(notificationDTOS);
        return paginationDTO;
    }

    public Long unreadCount(Long userId) {
        NoticeExample example = new NoticeExample();
        example.createCriteria()
                .andReceiverEqualTo(userId)
                .andStatusEqualTo(NoticeStatusEnum.UNREAD.getStatus());
        return noticeMapper.countByExample(example);
    }

    public NoticeDTO read(long id) {
        Notice notice = noticeMapper.selectByPrimaryKey(id);
        notice.setStatus(NoticeStatusEnum.READ.getStatus());
        noticeMapper.updateByPrimaryKey(notice);
        NoticeDTO noticeDTO = new NoticeDTO();
        BeanUtils.copyProperties(notice, noticeDTO);
        noticeDTO.setTypeName(NoticeEnum.nameOfType(notice.getType()));
        return noticeDTO;

    }
}
