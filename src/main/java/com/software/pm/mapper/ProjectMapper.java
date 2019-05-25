package com.software.pm.mapper;

import com.software.pm.common.domain.vo.ProjectVO;
import com.software.pm.common.domain.vo.ProjectViewVO;
import com.software.pm.common.domain.vo.SelectOptionVO;
import com.software.pm.domain.Project;

import java.util.ArrayList;

public interface ProjectMapper {

    Integer addProject(Project project);

    ArrayList<ProjectVO> getProjectList(String createdBy);

    String getProjectDesc(String id);

    Integer updateProjectDesc(String id, String desc);

    Integer deleteProject(String id);

    ArrayList<SelectOptionVO> getSelectOption();

    ProjectViewVO getProjectInfo(String id);
}
