<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2020/8/12
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
                <h2 class="h5 no-margin-bottom">全部部门</h2>
            </div>
        </div>
        <section class="no-padding-bottom">

            <div class="list-group subject">
    <c:forEach items="${allDept}" var="dept">
                <div class="list-group-item">
                    <a href="#${dept[ 'key' ]}" data-toggle="collapse">${dept[ 'key' ]} &nbsp;人</a>
                    <div id="${dept[ 'key' ]}" class="collapse deptDetail">
                        <ul>
                            <c:forEach items="${dept[ 'value' ]}" var="value">
                            <li>
                                <c:if test="${value.realName!=null}">
                                    <a href="#">${value.realName}</a>
                                </c:if>
                                <c:if test="${value.realName==null}">
                                    <a href="#">${value.username}</a>
                                </c:if>
                            </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
    </c:forEach>
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
