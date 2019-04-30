/**

 @Name：layuiAdmin 公共业务
 */

layui.define(function (exports) {
    var $ = layui.$
        , layer = layui.layer
        , laytpl = layui.laytpl
        , setter = layui.setter
        , view = layui.view
        , admin = layui.admin

    //公共业务的逻辑处理可以写在此处，切换任何页面都会执行
    //……


    //退出
    admin.events.logout = function () {
        $.ajax({
            type: 'GET',
            url: '/logout',
            success: function () {
                layer.msg('退出成功！', {
                    offset: '15px'
                    , icon: 1
                    , time: 1000
                });
                location.reload();

            }
        });
    };


    //对外暴露的接口
    exports('common', {});
});