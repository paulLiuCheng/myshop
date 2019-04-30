package com.jacklin.myshop.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jacklin.myshop.common.ServerLayResult;
import com.jacklin.myshop.entity.GoodsType;
import com.jacklin.myshop.service.GoodsTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 商品类型控制器
 */
@Api("商品类型API接口")
@RestController
public class GoodsTypeController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private GoodsTypeService goodsTypeService;

    /**
     * 下拉动态加载
     *
     * @return
     */
    @ApiOperation(value = "商品类型接口",notes = "用于动态更新加载商品类型")
    @PostMapping("/admin/goodstype/list")
    public List<GoodsType> list() {
        List<GoodsType> goodsTypes = goodsTypeService.selectAll();
        return goodsTypes;
    }


    /**
     * 列表查询
     *
     * @param page
     * @param limit
     * @return
     */
    @ApiOperation(value = "商品类型列表接口",notes = "商品类型结果集")
    @RequestMapping("/admin/goodstype/tableList")
    public ServerLayResult goodsTypeList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                         @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        int count = goodsTypeService.count();
        //分页
        PageHelper.startPage(page, limit);
        List<GoodsType> goodsTypes = goodsTypeService.selectAll();
        PageInfo info = new PageInfo(goodsTypes);
        //组装数据
        ServerLayResult result = new ServerLayResult(0, "", count, info.getList());
        return result;
    }

    /**
     * 商品添加
     *
     * @param goodsType
     * @return
     */
    @ApiOperation(value = "商品类型保存接口",notes = "根据前台传入的json数据对象进行保存商品类型")
    @PostMapping("/admin/goodsType/save")
    public String addGoodsType(@RequestBody GoodsType goodsType) {
        logger.info("goodsType===" + goodsType);
        int insert = goodsTypeService.insert(goodsType);
        if (insert > 0) {
            return "success";
        }
        return "error";
    }

    /**
     * 根据id删除商品类型
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "商品类型删除接口",notes = "根据商品ID删除商品类型")
    @GetMapping("/admin/goodsType/del")
    public String delGoodsType(@RequestParam(value = "id") Integer id) {
        logger.info("删除的商品类型ID=" + id);
        int del = goodsTypeService.deleteByPrimaryKey(id);
        if (del > 0) {
            return "success";
        }
        return "error";
    }

    /**
     * 根据商品类型删除
     *
     * @param goodsType
     * @return
     */
    @ApiOperation(value = "商品类型接口",notes = "根据json数据更新商品类型")
    @PostMapping("/admin/goodsType/update")
    public String updateGoodsType(@RequestBody GoodsType goodsType) {
        logger.info("更新商品类型数据=" + goodsType);
        int update = goodsTypeService.updateByPrimaryKey(goodsType);
        if (update > 0) {
            return "success";
        }
        return "error";
    }


}
