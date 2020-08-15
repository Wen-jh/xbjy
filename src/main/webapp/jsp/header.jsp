<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<header class="header">
    <nav class="navbar navbar-expand-lg">
        <div class="search-panel">
            <div class="search-inner d-flex align-items-center justify-content-center">
                <div class="close-btn">Close <i class="fa fa-close"></i></div>
                <form id="searchForm" action="#">
                    <div class="form-group">
                        <input type="search" name="search" placeholder="What are you searching for...">
                        <button type="submit" class="submit">Search</button>
                    </div>
                </form>
            </div>
        </div>
        <div class="container-fluid d-flex align-items-center justify-content-between">
            <div class="navbar-header">
                <!-- Navbar Header--><a href="home.html" class="navbar-brand">
                <div class="brand-text brand-big visible text-uppercase"><strong class="text-primary">小标</strong><strong>会议平台</strong></div>
                <div class="brand-text brand-sm"><strong class="text-primary">X</strong><strong>B</strong></div></a>
                <!-- Sidebar Toggle Btn-->
                <button class="sidebar-toggle"><i class="fa fa-long-arrow-left"></i></button>
            </div>
            <div class="right-menu list-inline no-margin-bottom">
                <!-- Log out -->
                <div class="list-inline-item logout">
                    <a id="logout" href="../index.html" class="nav-link"><span class="d-none d-sm-inline">Logout </span></a>
                </div>
            </div>
        </div>
    </nav>
</header>

<!-- JavaScript files-->
<script src="${pageContext.request.contextPath}/vendor/jquery/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/popper.js/umd/popper.min.js"> </script>
<script src="${pageContext.request.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap-switch.min.js"></script>
<script src="${pageContext.request.contextPath}/vendor/jquery.cookie/jquery.cookie.js"> </script>
<script src="${pageContext.request.contextPath}/vendor/chart.js/Chart.min.js"></script>
<script src="${pageContext.request.contextPath}/js/layer.js"></script>
<script src="${pageContext.request.contextPath}/vendor/jquery-validation/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/js/charts-home.js"></script>
<script src="${pageContext.request.contextPath}/js/front.js"></script>
<script src="${pageContext.request.contextPath}/js/custom.js"></script>