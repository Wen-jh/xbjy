<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav id="sidebar">
    <!-- Sidebar Header-->
    <div class="sidebar-header d-flex align-items-center">
        <div id="avatar" class="avatar"><img src="${loginUser.pic}" alt="..." class="img-fluid rounded-circle" id="loginUserPic"></div>
        <div class="title">
            <h1 class="h5">${name}</h1>
            <p>${deptName}</p>
            <input type="hidden" id="targetName" value="${username}">
            <input type="hidden" id="id" value="${uId}">
        </div>
    </div>
    <!-- Sidebar Navidation Menus--><span class="heading">Main</span>
    <ul class="list-unstyled">
        <li><a href="home.html"> <i class="icon-home"></i>主页 </a></li>
        <li><a href="#userDropdown"  data-toggle="collapse" aria-expanded="true"> <i class="icon-windows"></i>用户列表</a>
            <ul id="userDropdown" class="collapse show">
                <li class="active"><a href="/user/findUser?currPage=1">查看用户</a></li>
                <li><a href="/user/myUser">我关注的用户</a></li>
                <li><a href="/article/findArticle">发布文章</a></li>
                <li><a href="/article/articleCollect">我的收藏</a></li>
            </ul>
        </li>
        <!--<li><a href="login.html"> <i class="icon-logout"></i>Login page </a></li>-->

        <li><a href="#depDropdown"  data-toggle="collapse"> <i class="icon-windows2"></i>部门列表</a>
            <ul id="depDropdown" class="collapse list-unstyled ">
                <li><a href="/dept/findAll">全部部门</a></li>
                <li><a href="/meet/findAllMeet">会议系统</a></li>
            </ul>
        </li>

    </ul>
</nav>

