package com.software.pm.service;

import com.software.pm.common.domain.dto.PageDTO;
import com.software.pm.common.domain.vo.ProjectViewVO;
import com.software.pm.common.domain.vo.SelectOptionVO;
import com.software.pm.domain.Project;

import java.util.ArrayList;
import java.util.Map;

public interface ProjectService {

    Integer addProject(Project project);

    Map getProjectList(PageDTO pageDTO);

    String getProjectDesc(String id);

    Integer updateProjectDesc(String id, String desc);

    Integer deleteProject(String id);

    ArrayList<SelectOptionVO> getSelectOption();

    ProjectViewVO getProjectInfo(String id);
}
