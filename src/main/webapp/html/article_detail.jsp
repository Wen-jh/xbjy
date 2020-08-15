<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86135
  Date: 2020/8/15
  Time: 11:22
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
                <h2 class="h5 no-margin-bottom">文章详情</h2>
            </div>
        </div>

        <section class="no-padding-bottom">

            <div class="myTitle">
                <h3 class="text-center">${Farticle.title}</h3>
                <input type="submit" value="取消收藏" class="btn btn-info">

            </div>

            <div class="myContent">
                <p class="h6"><strong>发布人：</strong>${Farticle.publishRealName}</p>
                <p class="h6"><strong>创建时间：</strong>${Farticle.publishDate}</p>
                <p class="h6"><strong>浏览次数：</strong>1</p>
                <p class="h6"><strong>收藏次数：</strong>${Farticle.browseCount}</p>
                <textarea style="padding: 2px" disabled="disabled" class="form-control" rows="11">${Farticle.content}</textarea>

            </div>

            <div class="myList">
                <p>您关注的小伙伴等人也收藏了该文章</p>
                <ul>
                    <c:forEach items="${allFollowById}" var="people">
                        <c:choose>
                            <c:when test="${people.real_name!=null}">
                                <li class="list-group-item">
                                    <a href="#">${people.real_name}</a>
                                </li>
                            </c:when>
                            <c:when test="${people.username!=null}">
                                <li class="list-group-item">
                                    <a href="#">${people.username}</a>
                                </li>
                            </c:when>
                        </c:choose> 
                       
                    </c:forEach>
                    

                </ul>
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


</body>
</html>