<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/client/assets" var="url"/>
<!-- start header top  -->
<div class="aa-header-top">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="aa-header-top-area">
                    <!-- start header top left -->
                    <div class="aa-header-top-left">
                        <div class="cellphone hidden-xs">
                            <p><a href="${pageContext.request.contextPath}/home"><span class="fas fa-home" >  </span></a>Kênh Quản Trị</p>
                        </div>
                        <!-- start language -->
                        <div class="aa-language">
                            <div class="dropdown">
                                <a class="btn dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
                                    <img src="${url}/img/flag/vietnam.png" alt="english flag">Việt Nam
                                </a>
                            </div>
                        </div>

                    </div>
                    <!-- / header top left -->
                    <div class="aa-header-top-right">
                        <ul class="aa-head-top-nav-right">

                            <c:if test="${sessionScope.account != null}">
                                <li>
                                    <a><strong>Hello </strong> ${sessionScope.account}</a>
                                </li>
                                <li class="hidden-xs"><a href="login">Đăng xuất</a></li>
                                </c:if>
                            <c:if test="${sessionScope.account == null}">
                                <li class="hidden-xs"><a href="${pageContext.request.contextPath}/register">Đăng ký</a></li>
                                <li><a href="${pageContext.request.contextPath}/login">Đăng nhập</a></li>
                                </c:if>
                            <!--  data-toggle="modal" data-target="#login-modal" -->
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- / header top  -->
