package com.software.pm.service;

import com.software.pm.common.domain.dto.PageDTO;
import com.software.pm.common.domain.dto.SubmitDTO;
import com.software.pm.common.domain.vo.BugViewVO;
import com.software.pm.domain.Bug;

import java.util.Map;

public interface BugService {
    Integer addBug(Bug bug);

    Map getBugList(PageDTO pageDTO);

    BugViewVO getBugInfo(String id);

    Integer resolvedBug(SubmitDTO submitDTO);

    Integer verifyBugFall(String id);

    Integer verifyBugPass(SubmitDTO submitDTO);
}
