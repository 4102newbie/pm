package com.software.pm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.software.pm.common.config.Constants;
import com.software.pm.common.domain.vo.ProductVO;
import com.software.pm.common.domain.vo.ProductViewVO;
import com.software.pm.common.domain.vo.SelectOptionVO;
import com.software.pm.domain.Product;
import com.software.pm.mapper.BugMapper;
import com.software.pm.mapper.ProductMapper;
import com.software.pm.mapper.TaskMapper;
import com.software.pm.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ProductServiceImpl
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-21 下午 04:13
 **/
@Service
@Transactional
public class ProductServiceImpl implements ProductService {
    @Resource
    ProductMapper productMapper;
    @Resource
    TaskMapper taskMapper;
    @Resource
    BugMapper bugMapper;

    @Override
    public Integer addProduct(Product product) {
        return productMapper.addProduct(product);
    }

    @Override
    public ProductViewVO getProductInfo(String id) {
        ProductViewVO productViewVO = productMapper.getProductInfo(id);
        Integer countTask = taskMapper.countTaskByProductId(id);
        Integer countBug = bugMapper.countBugByProductId(id);
        productViewVO.setTaskNum(countTask);
        productViewVO.setBugNum(countBug);
        return productViewVO;
    }

    @Override
    public Map getProductList(Integer startPage) {
        Map res = new HashMap();
        PageHelper.startPage(startPage, Constants.PAGESIZE);
        ArrayList<ProductVO> productList = productMapper.getProductList();
        for (ProductVO productVO : productList) {
            productVO.setTaskNum(taskMapper.countTaskByProjectId(productVO.getProjectId()));
            productVO.setBugNum(bugMapper.countBugByProjectId(productVO.getProjectId()));
        }
        PageInfo<ProductVO> productPageInfo = new PageInfo<>(productList);
        res.put("queryList", productPageInfo);
        return res;
    }

    @Override
    public ArrayList<SelectOptionVO> getSelectOption() {
        return productMapper.getSelectOption();
    }

    @Override
    public String getProjectDesc(String id) {
        return productMapper.getProjectDesc(id);
    }

    @Override
    public Integer updateProductDesc(String id, String desc) {
        return productMapper.updateProductDesc(id, desc);
    }

    @Override
    public Integer deleteProduct(String id) {
        return productMapper.deleteProduct(id);
    }
}
