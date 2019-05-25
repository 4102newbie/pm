package com.software.pm.controller;

import com.software.pm.common.domain.dto.SubmitDTO;
import com.software.pm.common.domain.vo.ProductViewVO;
import com.software.pm.domain.Product;
import com.software.pm.domain.User;
import com.software.pm.service.ProductService;
import com.software.pm.service.UserService;
import com.software.pm.utils.MD5Utils;
import com.software.pm.utils.R;
import com.software.pm.utils.UUIDUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ProductController
 * @Description TODO
 * @Author liziguang
 * @Date 2019-04-21 下午 04:12
 **/
@Slf4j
@RestController
@RequestMapping("/po")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    UserService userService;

    @GetMapping("/productList")
    R getProductList(Integer startPage) {
        Map list = productService.getProductList(startPage);
        return R.ok(list);
    }

    @PostMapping("/addProduct")
    R addProduct(Product product) {
        // 构建 product 对象
        product.setId(UUIDUtils.generateShortUUID());
        product.setCreatedDate(new Date());
        Integer count = productService.addProduct(product);
        if (1 == count) {
            return R.ok();
        } else {
            return R.error("添加失败！");
        }
    }

    @GetMapping("/productInfo")
    R getProductInfo(String id) {
        Map res = new HashMap();
        ProductViewVO productViewVO = productService.getProductInfo(id);
        res.put("productInfo", productViewVO);
        return R.ok(res);
    }

    @PostMapping("/editProductInfo")
    R editProductInfo() {
        return R.ok();
    }

    @GetMapping("/getProductDesc")
    R getProjectDesc(String id) {
        Map res = new HashMap();
        String projectDesc = productService.getProjectDesc(id);
        res.put("desc", projectDesc);
        return R.ok(res);
    }

    @PostMapping("/updateProductDesc")
    R updateProductDesc(String id, String desc) {
        Integer count = productService.updateProductDesc(id, desc);
        if (1 == count) {
            return R.ok();
        } else {
            return R.error("更新失败！");
        }
    }

    @PostMapping("/deleteProduct")
    R deleteProject(SubmitDTO submitDTO) {
        User user = userService.getUserById(submitDTO.getUserId());
        if (null == user || !MD5Utils.toEquals(submitDTO.getPassword(), user.getPassword())) {
            return R.error("密码错误！");
        } else {
            Integer count = productService.deleteProduct(submitDTO.getId());
            if (1 == count) {
                return R.ok();
            } else {
                return R.error("删除失败！");
            }
        }
    }
}
