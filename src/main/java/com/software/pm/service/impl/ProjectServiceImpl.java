package com.software.pm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.software.pm.common.config.Constants;
import com.software.pm.common.domain.dto.PageDTO;
import com.software.pm.common.domain.vo.ProjectVO;
import com.software.pm.common.domain.vo.ProjectViewVO;
import com.software.pm.common.domain.vo.SelectOptionVO;
import com.software.pm.domain.Project;
import com.software.pm.mapper.BugMapper;
import com.software.pm.mapper.ProjectMapper;
import com.software.pm.mapper.TaskMapper;
import com.software.pm.service.ProjectService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ProjectServiceImpl
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-22 下午 07:44
 **/
@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    @Resource
    ProjectMapper projectMapper;
    @Resource
    TaskMapper taskMapper;
    @Resource
    BugMapper bugMapper;

    @Override
    public Integer addProject(Project project) {
        return projectMapper.addProject(project);
    }

    @Override
    public Map getProjectList(PageDTO pageDTO) {
        Map res = new HashMap();
        PageHelper.startPage(pageDTO.getStartPage(), Constants.PAGESIZE);
        ArrayList<ProjectVO> projectList = projectMapper.getProjectList(pageDTO.getCreatedBy());
        PageInfo<ProjectVO> projectPageInfo = new PageInfo<>(projectList);
        res.put("queryList", projectPageInfo);
        return res;
    }

    @Override
    public String getProjectDesc(String id) {
        return projectMapper.getProjectDesc(id);
    }

    @Override
    public Integer updateProjectDesc(String id, String desc) {
        return projectMapper.updateProjectDesc(id, desc);
    }

    @Override
    public Integer deleteProject(String id) {
        return projectMapper.deleteProject(id);
    }

    @Override
    public ArrayList<SelectOptionVO> getSelectOption() {
        return projectMapper.getSelectOption();
    }

    @Override
    public ProjectViewVO getProjectInfo(String id) {
        ProjectViewVO projectViewVO = projectMapper.getProjectInfo(id);
        Integer countTask = taskMapper.countTaskByProjectId(id);
        Integer countBug = bugMapper.countBugByProjectId(id);
        projectViewVO.setTaskNum(countTask);
        projectViewVO.setBugNum(countBug);
        return projectViewVO;
    }
}
