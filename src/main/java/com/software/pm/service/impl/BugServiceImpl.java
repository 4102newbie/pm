package com.software.pm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.software.pm.common.config.Constants;
import com.software.pm.common.domain.dto.PageDTO;
import com.software.pm.common.domain.dto.SubmitDTO;
import com.software.pm.common.domain.vo.BugVO;
import com.software.pm.common.domain.vo.BugViewVO;
import com.software.pm.domain.Bug;
import com.software.pm.mapper.BugMapper;
import com.software.pm.mapper.TaskMapper;
import com.software.pm.service.BugService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.security.cert.Extension;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName BugServiceImpl
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-25 下午 04:13
 **/
@Service
@Transactional
public class BugServiceImpl implements BugService {
    @Resource
    BugMapper bugMapper;
    @Resource
    TaskMapper taskMapper;

    @Override
    public Integer addBug(Bug bug) {
        // 验证当前 bug 是否被其他测试人员操作过
        Integer existInt = bugMapper.isExist(bug.getTaskId());
        Integer exist = taskMapper.isExist(bug.getTaskId());
        if (null == existInt && 1 == exist) {
//            System.out.println(existInt+"  "+exist);
//            return 1;
            return bugMapper.addBug(bug);
        } else {
            return -1;
        }
    }

    @Override
    public Map getBugList(PageDTO pageDTO) {
        Map res = new HashMap();
        PageHelper.startPage(pageDTO.getStartPage(), Constants.PAGESIZE);
        ArrayList<BugVO> bugList = bugMapper.getBugList(pageDTO.getCreatedBy());
        PageInfo<BugVO> bugVOPageInfo = new PageInfo<>(bugList);
        res.put("queryList",bugVOPageInfo);
        return res;
    }

    @Override
    public BugViewVO getBugInfo(String id) {
        return bugMapper.getBugInfo(id);
    }

    @Override
    public Integer resolvedBug(SubmitDTO submitDTO) {
        return bugMapper.resolvedBug(submitDTO);
    }

    @Override
    public Integer verifyBugFall(String id) {
        return bugMapper.verifyBugFall(id, Constants.Verification.FALL.getValue());
    }

    @Override
    public Integer verifyBugPass(SubmitDTO submitDTO) {
        bugMapper.verifyBugPass(submitDTO);
        submitDTO.setId(submitDTO.getSec_id());
        return taskMapper.closeTask(submitDTO);
    }
}
