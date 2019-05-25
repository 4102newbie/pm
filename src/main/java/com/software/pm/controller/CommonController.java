package com.software.pm.controller;

import com.software.pm.common.domain.vo.SelectOptionVO;
import com.software.pm.domain.Project;
import com.software.pm.service.ProductService;
import com.software.pm.service.ProjectService;
import com.software.pm.service.TaskService;
import com.software.pm.service.UserService;
import com.software.pm.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName CommonController
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-22 下午 03:08
 **/
@Slf4j
@RestController
@RequestMapping("/common")
public class CommonController {
    @Autowired
    ProductService productService;
    @Autowired
    ProjectService projectService;
    @Autowired
    UserService userService;
    @Autowired
    TaskService taskService;

    @GetMapping("/getSelectOption")
    R getSelectOption(String type) {
        Map res = new HashMap();
        ArrayList<SelectOptionVO> selectOption;
        switch (type) {
            case "po":
                // 关联产品
                selectOption = productService.getSelectOption();
                break;
            case "pm":
                // 关联项目
                selectOption = projectService.getSelectOption();
                break;
            case "dev":
                // 关联研发人员
                selectOption = userService.getSelectOption();
                break;
            default:
                return R.error();
        }
        res.put("selectOption", selectOption);
        return R.ok(res);
    }
}
