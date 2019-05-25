package com.software.pm.mapper;

import com.software.pm.common.domain.vo.ProductVO;
import com.software.pm.common.domain.vo.ProductViewVO;
import com.software.pm.common.domain.vo.SelectOptionVO;
import com.software.pm.domain.Product;

import java.util.ArrayList;

public interface ProductMapper {

    Integer addProduct(Product product);

    ProductViewVO getProductInfo(String id);

    ArrayList<ProductVO> getProductList();

    ArrayList<SelectOptionVO> getSelectOption();

    String getProjectDesc(String id);

    Integer updateProductDesc(String id, String desc);

    Integer deleteProduct(String id);
}
