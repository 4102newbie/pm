package com.software.pm.service;

import com.software.pm.common.domain.vo.ProductViewVO;
import com.software.pm.common.domain.vo.SelectOptionVO;
import com.software.pm.domain.Product;

import java.util.ArrayList;
import java.util.Map;

public interface ProductService {

    Integer addProduct(Product product);

    ProductViewVO getProductInfo(String id);

    Map getProductList(Integer startPage);

    ArrayList<SelectOptionVO> getSelectOption();

    String getProjectDesc(String id);

    Integer updateProductDesc(String id, String desc);

    Integer deleteProduct(String id);
}
