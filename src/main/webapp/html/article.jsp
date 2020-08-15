<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2020/8/14
  Time: 16:25
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
                <h2 class="h5 no-margin-bottom">发布文章</h2>
            </div>
        </div>

        <section class="no-padding-bottom">

            <div class="list-group myList">
                <!--搜索文章的条件-->
                <div class="myTitle">
                    <form class="form-inline" action="/article/findArticle">
                        <div class="form-group">
                            <label for="inlineFormInput" class="sr-only">Name</label>
                            <input id="inlineFormInput" type="text" name="title" placeholder="按标题名字查找" class="mr-sm-3 form-control">
                        </div>
                        <div class="form-group">
                            <input type="submit" value="查询" class="btn btn-primary">
                        </div>
                    </form>

                    <input id = "addArt" type="submit" value="发布文章" class="btn btn-primary">

                </div>

                <ul>
                    <c:forEach items="${allArticle.data}" var="article">
                    <li class="list-group-item">
                        <a href="article_detail.html">${article.title}</a>
                        <p class="h6"><strong>作者：</strong>${article.publish_real_name}</p>
                        <p class="h6"><strong>时间：</strong>${article.publish_date}</p>
                        <p style="white-space:nowrap;overflow:hidden;text-overflow: ellipsis">${article.content}</p>
                    </li>
                    </c:forEach>
                </ul>

                <nav class="text-center" aria-label="Page navigation">
                    <ul class="pagination">
                        <li>
                            <a href="#" aria-label="Previous">
                                <span aria-hidden="true">&laquo;</span>
                            </a>
                        </li>
                        <c:forEach begin="${allArticle.startIndex}" end="${allArticle.endIndex}" varStatus="i">
                            <li><a href="/article/findArticle?currPage=${i.count}">${i.count}</a></li>
                        </c:forEach>
                        <li>
                            <a href="#" aria-label="Next">
                                <span aria-hidden="true">&raquo;</span>
                            </a>
                        </li>
                    </ul>
                </nav>
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
<script>
    /*** 上一页 */
    function pre() {
        if (${pageData.currPage-1<=0}) {
            layer.msg('已经到顶啦！');
            return;
        }
        window.location.href = "/user/myUser?currPage=${pageData.currPage - 1}"
    }
    /*** 下一页 */
    function next() {
        if (${pageData.currPage+1>pageData.totalPage}) {
            layer.msg('已经到底啦！');
            return;
        }
        window.location.href = "/user/myUser?currPage=${pageData.currPage + 1}"
    }
</script>
</html>
