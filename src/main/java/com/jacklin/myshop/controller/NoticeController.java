package com.jacklin.myshop.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jacklin.myshop.common.ServerLayResult;
import com.jacklin.myshop.entity.Notice;
import com.jacklin.myshop.service.NoticeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 公告控制器
 */
@Api(value = "公告模块AIP接口")
@RestController
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    /**
     * 查询结果列表
     *
     * @param page
     * @param limit
     * @return
     */
    @SuppressWarnings("rawtypes")
	@ApiOperation(value = "公告模块接口",notes = "公告结果列表")
    @GetMapping("/admin/notice/list")
    public ServerLayResult<Notice> list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                        @RequestParam(value = "limit", defaultValue = "10") Integer limit) {
        @SuppressWarnings("unchecked")
		ServerLayResult<Notice> result = new ServerLayResult(0, "", noticeService.count(), noticeService.selectAll(page, limit));
        return result;
    }

    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "公告删除接口",notes = "根据公告id删除公告")
    @GetMapping("/admin/notice/del")
    public String delete(Integer id) {
        System.out.println("id = " + id);
        int row = noticeService.deleteByPrimaryKey(id);
        if (row > 0) {
            return "success";
        }
        return "error";
    }


    /**
     * 更新
     *
     * @param notice
     * @return
     */
    @ApiOperation(value = "更新公告接口",notes = "根据公告前台json数据对象进行删除公告!")
    @PostMapping("/admin/notice/update")
    public String update(@RequestBody Notice notice) {
        Notice upNotice = notice;
        upNotice.setNtime(new Date());
        if (upNotice != null) {
            int index = noticeService.updateByPrimaryKey(upNotice);
            if (index > 0) {
                return "success";
            }
        }
        return "error";
    }

    /**
     * 保存操作
     *
     * @param notice
     * @return
     */
    @ApiOperation(value = "保存公告接口",notes = "根据前台传入json数据对象进行保存公告")
    @PostMapping("/admin/notice/save")
    public String save(@RequestBody Notice notice) {
        Notice saveNotice = notice;
        saveNotice.setNtime(new Date());
        if (saveNotice != null) {
            int index = noticeService.insert(saveNotice);
            if (index > 0) {
                return "success";
            }
        }
        return "error";
    }
}
