package com.lll.student.service;

import com.lll.student.dao.SelectCourseRecordDao;
import com.lll.student.domain.pojo.SelectCourseRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luo
 */
@Service
public class SelectCourseRecordService {

    @Autowired
    private SelectCourseRecordDao selectCourseRecordDao;

    public void insert(SelectCourseRecord selectCourseRecord){
        selectCourseRecordDao.insert(selectCourseRecord);
    }
}
