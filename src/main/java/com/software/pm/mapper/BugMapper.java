package com.software.pm.mapper;

import com.software.pm.common.domain.dto.SubmitDTO;
import com.software.pm.common.domain.vo.BugVO;
import com.software.pm.common.domain.vo.BugViewVO;
import com.software.pm.domain.Bug;

import java.util.ArrayList;

public interface BugMapper {
    Integer addBug(Bug bug);

    Integer isExist(String taskId);

    ArrayList<BugVO> getBugList(String id);

    BugViewVO getBugInfo(String id);

    ArrayList<BugVO> getDevBugList(String assignedTo);

    Integer countBugByProjectId(String projectId);

    Integer countBugByProductId(String productId);

    Integer resolvedBug(SubmitDTO submitDTO);

    Integer verifyBugFall(String id, String verification);

    Integer verifyBugPass(SubmitDTO submitDTO);
}
