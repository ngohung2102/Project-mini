<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/client/assets" var="url"/>

<!-- footer -->  
<footer id="aa-footer">
    <!-- footer bottom -->
    <div class="aa-footer-top">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="aa-footer-top-area">
                        <div class="row">
                            <div class="col-md-4 col-sm-6">
                                <div class="aa-footer-widget">
                                    <a href="${pageContext.request.contextPath}/"><img src="${url}/images/logo.png" alt="logo img" width="30%"></a> 
                                    <ul class="aa-footer-nav">
                                        <li><p style="color:#888; text-align: justify; width: 95%">Là nơi chuyên buôn bán tất cả các mặt hàng thẻ nạp các nền tảng.</p></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-6">
                                <div class="aa-footer-widget">
                                    <div class="aa-footer-widget">
                                        <h3>HỖ TRỢ KHÁCH HÀNG</h3>
                                        <ul class="aa-footer-nav">
                                            <li><a href="${pageContext.request.contextPath}/client/order">Hướng dẫn đặt hàng</a></li>
                                            <li><a href="${pageContext.request.contextPath}/client/payment">Hướng dẫn thanh toán</a></li>
                                            <li><a href="${pageContext.request.contextPath}/policy">Chính sách bảo mật thông tin</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-4 col-sm-6">
                                <div class="aa-footer-widget">
                                    <div class="aa-footer-widget">
                                        <h3 >LIÊN HỆ</h3>
                                        <address>
                                            <p>ĐH FPT</p>
                                            <p><span class="fa fa-phone"></span>0123456789</p>
                                            <p><span class="fa fa-envelope"></span>knagzaoh@gmail.com</p>
                                        </address>
                                        <div class="aa-footer-social">
                                            <a href="https://www.facebook.com/kitori.omori.7/"><span class="fab fa-facebook"></span></a>
                                            <a href="https://www.facebook.com/kitori.omori.7/"><span class="fab fa-youtube"></span></a>
                                            <a href="https://www.facebook.com/kitori.omori.7/"><span class="fab fa-instagram"></span></a>
                                            <a href="https://www.facebook.com/kitori.omori.7/"><span class="fab fa-skype"></span></a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

</footer>
<!-- / footer -->

</body>
<jsp:include page = "script.jsp" flush = "true" />

</html>
