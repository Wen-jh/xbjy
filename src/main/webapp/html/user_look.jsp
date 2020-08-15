<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2020/8/12
  Time: 18:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<%@include file="../jsp/head.jsp"%>
<body>
<%@include file="../jsp/header.jsp"%>

<div class="d-flex align-items-stretch">
    <!-- Sidebar Navigation-->
    <%@include file="../jsp/left.jsp"%>
    <!-- Sidebar Navigation end-->
    <div class="page-content">
        <div class="page-header">
            <div class="container-fluid">
                <h2 class="h5 no-margin-bottom">个人中心</h2>
            </div>
        </div>
        <section class="no-padding-bottom">
            <!-- Form Elements -->
            <div class="col-lg-12">
                <div class="block">
                    <div class="title"><strong>我的头像</strong></div>
                    <div class="avatar"><img src="${loginUser.pic}" id='pic' alt="加载中..." style="width: 150px;height: 150px" class="img-thumbnail rounded-circle"></div>
                    <div style="margin-top: 15px" class="text-left">

                        <!-- 真正的文件上传表单 -->
                        <input name="realFile" type="file" id="picFile" style="display: none" />
                    </div>
                    <div class="title">
                        <br>
                        <p class="h5"><strong>关注数：</strong><span>&nbsp;</span><span>&nbsp;</span><span>${follow}</span></p>
                        <br>
                        <p class="h5"><strong>被看数：</strong><span>&nbsp;</span><span>&nbsp;</span><span>${targetUser.look}</span></p>
                        <br>
                    </div>
                    <div class="title"><strong>我的数据</strong></div>
                    <div class="block-body">
                        <form class="form-horizontal" action="/user/updateUser" method="post">
                            <input type="hidden" id="upId" name="upId" value="${uId}">
                            <div class="form-group row">
                                <label class="col-sm-3 form-control-label">真实姓名</label>
                                <div class="col-sm-9">
                                    <input type="text" name="upRealName" value="${targetUser.realName}" class="form-control">
                                </div>
                            </div>
                            <div class="line"></div>
                            <div class="form-group row">
                                <label class="col-sm-3 form-control-label">所属部门</label>
                                <div class="col-sm-9">
                                    <select class="selectpicker" data-live-search="true">
                                        <option>研发部</option>
                                        <option>销售部</option>
                                        <option>行政部</option>
                                        <option>财务部</option>
                                        <option>总裁办公室</option>
                                        <option>推广部</option>
                                        <option>秘书部</option>
                                        <option>市场部</option>
                                        <option>宣传部</option>
                                    </select>
                                </div>
                            </div>
                            <div class="line"></div>
                            <div class="form-group row">
                                <label class="col-sm-3 form-control-label">电话</label>
                                <div class="col-sm-9">
                                    <input type="text" value="${targetUser.phone}" name="upPhone" class="form-control">
                                </div>
                            </div>
                            <div class="line"></div>
                            <div class="form-group row">
                                <label class="col-sm-3 form-control-label">年龄</label>
                                <div class="col-sm-9">
                                    <input type="text" placeholder="${targetUser.age}"  name="upAge" class="form-control">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label class="col-sm-3 form-control-label">性别 </label>
                                <div class="col-sm-9">

                                    <div class="i-checks">
                                        <c:if test="${targetUser.gender==null}">
                                            <input id="radioCustom1" type="radio" value="1" name="upGender" class="radio-template" >
                                            <label for="radioCustom1">男</label>
                                            <span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span>
                                            <input id="radioCustom2" type="radio" value="0" name="upGender" class="radio-template">
                                            <label for="radioCustom2">女</label>
                                        </c:if>
                                        <c:if test="${targetUser.gender=='1'}">
                                        <input id="radioCustom1" type="radio" value="1" name="upGender" class="radio-template" checked>
                                        <label for="radioCustom1">男</label>
                                        <span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span>
                                        <input id="radioCustom2" type="radio" value="0" name="upGender" class="radio-template">
                                        <label for="radioCustom2">女</label>
                                        </c:if>
                                        <c:if test="${targetUser.gender=='0'}">
                                            <input id="radioCustom1" type="radio" value="1" name="upGender" class="radio-template">
                                            <label for="radioCustom1">男</label>
                                            <span>&nbsp;</span><span>&nbsp;</span><span>&nbsp;</span>
                                            <input id="radioCustom2" type="radio" value="0" name="upGender" class="radio-template" checked>
                                            <label for="radioCustom2">女</label>
                                        </c:if>
                                    </div>
                                </div>


                            </div>
                            <div class="line"></div>
                            <div class="form-group row">
                                <label class="col-sm-3 form-control-label">注册时间</label>
                                <div class="col-sm-9">
                                    <input type="text" disabled="" name="upRegisterTime" placeholder="${targetUser.registerTime}" class="form-control">
                                </div>
                            </div>
                            <div class="line"></div>
                            <div class="form-group row">
                                <label class="col-sm-3 form-control-label">登录时间</label>
                                <div class="col-sm-9">
                                    <input type="text" disabled="" name="upLoginTime" placeholder="${targetUser.loginTime}" class="form-control">
                                </div>
                            </div>
                            <div class="line"></div>

                            <div class="form-group row">
                                <label class="col-sm-3 form-control-label">是否私密 <br><small class="text-primary">默认为否，可以不设置</small></label>
                                <div class="col-sm-9">
                                    <div class="i-checks">
                                        <c:if test="${targetUser.isSecret==null||targetUser.isSecret==1}">
                                        <input id="checkboxCustom1" name="upIsSecret"  type="checkbox" value="0" class="checkbox-template" >
                                        <label for="checkboxCustom1">是否私密</label>
                                        </c:if>
                                        <c:if test="${targetUser.isSecret==0}">
                                            <input id="checkboxCustom1" name="upIsSecret" type="checkbox" value="0" class="checkbox-template" checked>
                                            <label for="checkboxCustom1">是否私密</label>
                                        </c:if>
                                    </div>

                                </div>


                            </div>
                            <div class="line"></div>
                            <div class="text-center">
                                <input type="submit" class="btn btn-primary" value="保存">
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </section>

        <footer class="footer">
            <div class="footer__block block no-margin-bottom">
                <div class="container-fluid text-center">
                    <p class="no-margin-bottom">Copyright &copy; 2019.Company <a href="#" >东方标准</a> </p>
                </div>
            </div>
        </footer>
    </div>
</div>


<script type="text/javascript">

    $("#pic").click(function () {

        $("#picFile").click();
    })
    $('#picFile').change(function () {

        var formData=new FormData();
        formData.append("iconFile", document.getElementById("picFile").files[0]);
        $.ajax({
            url:"/user/updatePic",
            processData:false,
            contentType:false,
            data:formData,
            type: "post",
            async: true,
            success:function (res,status) {
                if (status=="success"){
                    layer.msg('上传成功');
                    $("#picFile").val("");
                    alert(res);
                    $("#pic").attr("src",res);
                    alert($("#pic").src())
                    $("#loginUserPic").attr("src",res);
                } else {
                    layer.msg("上传失败");
                }
            },
            error: function (data) {
                layer.msg('服务器忙');
            }
        })
    });
</script>
</body>
</html>
