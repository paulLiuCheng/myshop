package com.jacklin.myshop.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jacklin.myshop.common.ServerLayResult;
import com.jacklin.myshop.entity.User;
import com.jacklin.myshop.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 用户Controller控制器
 */
@Api(value = "用户管理接口")
@RestController
public class UserController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    //注入业务
    @Autowired
    private UserService userService;

    /**
     * table数据列表
     *
     * @param page
     * @param limit
     * @return
     */
    @ApiOperation(value = "用户列表", notes = "查询用户结果集")
    @GetMapping("/admin/user/tableList")
    public ServerLayResult userList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                    @RequestParam(value = "limit", defaultValue = "10") Integer limit,
                                    @RequestParam(value = "keyword", defaultValue = "") String keyword) {
        if (keyword == null || keyword.equals("")) {
            logger.info("====================================1======" + keyword);
            //封装Json数据对象
            ServerLayResult result = new ServerLayResult(0, "", userService.count(), userService.selectAll(page, limit));
            return result;
        } else if (keyword != null) {
            logger.info("====================================2======" + keyword);
            ServerLayResult result = new ServerLayResult(0, "", userService.selectByUsername(keyword, page, limit).size(),
                    userService.selectByUsername(keyword, page, limit));
            return result;
        }
        logger.info("====================================3======" + keyword);
        return null;
    }


    /**
     * 根据id删除
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "用户删除", notes = "根据用户ID删除用户")
    @GetMapping("/admin/user/del")
    public String del(@RequestParam("id") Integer id) {
        if (id != null && id != 0) {
            int del = userService.deleteByPrimaryKey(id);
            if (del > 0) {
                return "success";
            }
        }
        return "error";
    }

    /**
     * 根据用户传入的对象进行更新
     *
     * @param user
     * @return
     */
    @ApiOperation(value = "用户对象更新", notes = "根据用户对象更新")
    @PostMapping("/admin/user/update")
    public String updateUser(@RequestBody User user) {

        if (user != null) {
            //根据用户对象的id 查询用户的密码，防止密码丢失
            User user1 = userService.selectByPrimaryKey(user.getId());
            //再次封装进对象中
            if (user1 != null) {
                user.setPassword(user1.getPassword());
                //更新对象
                int update = userService.updateByPrimaryKey(user);
                if (update > 0) {
                    return "success";
                }
            }
        }
        return "error";
    }

    /**
     * 重置用户密码
     *
     * @param id
     * @return
     */
    @ApiOperation(value = "重置密码接口", notes = "根据用户ID查询用户重置密码为123456，最后进行MD5加密")
    @GetMapping("/admin/user/resetPwd")
    public String restPwd(@RequestParam("id") Integer id) {
        if (id != null && id > 0) {
            //根据id查询出用户
            User user = userService.selectByPrimaryKey(id);
            //开始重置密码，重置密码使用的Spring提供的工具类进行对密码123456进行加密
            user.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
            //调用更新方法
            int restPwd = userService.updateByPrimaryKey(user);
            if (restPwd > 0) {
                return "success";
            }
        }
        return "error";
    }

    @ApiOperation(value = "Excel表格接口", notes = "表格导出")
    @GetMapping(value = "/admin/exportBtn")
    public void export(HttpServletResponse response) throws IOException {
        List<User> users = userService.selectAll();

        HSSFWorkbook wb = new HSSFWorkbook();

        HSSFSheet sheet = wb.createSheet("获取excel测试表格");

        HSSFRow row = null;

        row = sheet.createRow(0);//创建第一个单元格
        row.setHeight((short) (26.25 * 20));
        row.createCell(0).setCellValue("用户信息表");//为第一行单元格设值

        /*为标题设计空间
         * firstRow从第1行开始
         * lastRow从第0行结束
         *
         *从第1个单元格开始
         * 从第3个单元格结束
         */
        CellRangeAddress rowRegion = new CellRangeAddress(0, 0, 0, 2);
        sheet.addMergedRegion(rowRegion);

      /*CellRangeAddress columnRegion = new CellRangeAddress(1,4,0,0);
      sheet.addMergedRegion(columnRegion);*/


        /*
         * 动态获取数据库列 sql语句 select COLUMN_NAME from INFORMATION_SCHEMA.Columns where table_name='user' and table_schema='test'
         * 第一个table_name 表名字
         * 第二个table_name 数据库名称
         * */
        row = sheet.createRow(1);
        row.setHeight((short) (22.50 * 20));//设置行高
        row.createCell(0).setCellValue("用户Id");//为第一个单元格设值
        row.createCell(1).setCellValue("用户登入名");//为第二个单元格设值
        row.createCell(2).setCellValue("用户密码");//为第三个单元格设值
        row.createCell(3).setCellValue("用户邮箱");//为第三个单元格设值
        row.createCell(4).setCellValue("用户名");//为第三个单元格设值
        row.createCell(5).setCellValue("用户地址");//为第三个单元格设值
        row.createCell(6).setCellValue("用户电话");//为第三个单元格设值

        for (int i = 0; i < users.size(); i++) {
            row = sheet.createRow(i + 2);
            User user = users.get(i);
            row.createCell(0).setCellValue(user.getId());
            row.createCell(1).setCellValue(user.getUsername());
            row.createCell(2).setCellValue(user.getPassword());
            row.createCell(3).setCellValue(user.getEmail());
            row.createCell(4).setCellValue(user.getName());
            row.createCell(5).setCellValue(user.getAddress());
            row.createCell(6).setCellValue(user.getPhone());
        }
        sheet.setDefaultRowHeight((short) (16.5 * 20));
        //列宽自适应
        for (int i = 0; i <= 13; i++) {
            sheet.autoSizeColumn(i);
        }

        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        OutputStream os = response.getOutputStream();
        response.setHeader("Content-disposition", "attachment;filename=user.xls");//默认Excel名称
        wb.write(os);
        os.flush();
        os.close();
    }

    @RequestMapping(value = "/import")
    public String exImport(@RequestParam(value = "filename") MultipartFile file, HttpSession session) {
        return null;
    }


}
