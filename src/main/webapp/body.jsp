<%-- 
    Document   : header
    Created on : Oct 20, 2022, 4:45:17 AM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Body Page</title>
        <link href="img/favicon.ico" rel="icon">



        <!-- Customized Bootstrap Stylesheet -->
        <link href="css/style.css" rel="stylesheet">
        <script type="text/javascript">
            function doAddCart(id, name,username) {
                if (!!username) {
                    if (confirm("You sure you want add " + name + " to cart ?")) {
//                    window.location = "check?action=delete&id="+id;
                        window.location = "addcart?idproc=" + id;
                        window.alert("Add to cart successful!");
                    }
                    
                } else {
                    window.alert("You must login!");
                    window.location = "login";
                }

                
            }

        </script>
    </head>

    <body>
        <!-- Carousel Start -->
        <div class="container-fluid mb-3">
            <div class="row px-xl-5">
                <div class="col-lg-8">
                    <div id="header-carousel" class="carousel slide carousel-fade mb-30 mb-lg-0" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#header-carousel" data-slide-to="0" class="active"></li>
                            <li data-target="#header-carousel" data-slide-to="1"></li>
                            <li data-target="#header-carousel" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="carousel-item position-relative active" style="height: 430px;">
                                <img class="position-absolute w-100 h-100" src="img/carousel-1.jpg" style="object-fit: cover;">
                                <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                                    <div class="p-3" style="max-width: 700px;">
                                        <h1 class="display-4 text-white mb-3 animate__animated animate__fadeInDown">Men Fashion</h1>
                                        <p class="mx-md-5 px-5 animate__animated animate__bounceIn">Thương hiệu thời trang nam 4MEN được thành lập từ tháng 3 năm 2010, là thương hiệu thời trang uy tín hàng đầu tại Việt Nam dành riêng cho phái mạnh.</p>
                                        <a class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp" href="shop">Shop Now</a>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item position-relative" style="height: 430px;">
                                <img class="position-absolute w-100 h-100" src="img/carousel-2.jpg" style="object-fit: cover;">
                                <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                                    <div class="p-3" style="max-width: 700px;">
                                        <h1 class="display-4 text-white mb-3 animate__animated animate__fadeInDown">Women Fashion</h1>
                                        <p class="mx-md-5 px-5 animate__animated animate__bounceIn">Thời trang uy tín</p>
                                        <a class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp" href="shop">Shop Now</a>
                                    </div>
                                </div>
                            </div>
                            <div class="carousel-item position-relative" style="height: 430px;">
                                <img class="position-absolute w-100 h-100" src="img/carousel-3.jpg" style="object-fit: cover;">
                                <div class="carousel-caption d-flex flex-column align-items-center justify-content-center">
                                    <div class="p-3" style="max-width: 700px;">
                                        <h1 class="display-4 text-white mb-3 animate__animated animate__fadeInDown">Kids Fashion</h1>
                                        <p class="mx-md-5 px-5 animate__animated animate__bounceIn"></p>
                                        <a class="btn btn-outline-light py-2 px-4 mt-3 animate__animated animate__fadeInUp" href="shop">Shop Now</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="product-offer mb-30" style="height: 200px;">
                        <img class="img-fluid" src="img/offer-1.jpg" alt="">
                        <div class="offer-text">
                            <h6 class="text-white text-uppercase">Save 20%</h6>
                            <h3 class="text-white mb-3">Special Offer</h3>
                            <a href="" class="btn btn-primary">Shop Now</a>
                        </div>
                    </div>
                    <div class="product-offer mb-30" style="height: 200px;">
                        <img class="img-fluid" src="img/offer-2.jpg" alt="">
                        <div class="offer-text">
                            <h6 class="text-white text-uppercase">Save 20%</h6>
                            <h3 class="text-white mb-3">Special Offer</h3>
                            <a href="" class="btn btn-primary">Shop Now</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Carousel End -->


        <!-- Featured Start -->
        <div class="container-fluid pt-5">
            <div class="row px-xl-5 pb-3">
                <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                    <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                        <h1 class="fa fa-check text-primary m-0 mr-3"></h1>
                        <h5 class="font-weight-semi-bold m-0">Quality Product</h5>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                    <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                        <h1 class="fa fa-shipping-fast text-primary m-0 mr-2"></h1>
                        <h5 class="font-weight-semi-bold m-0">Free Shipping</h5>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                    <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                        <h1 class="fas fa-exchange-alt text-primary m-0 mr-3"></h1>
                        <h5 class="font-weight-semi-bold m-0">14-Day Return</h5>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6 col-sm-12 pb-1">
                    <div class="d-flex align-items-center bg-light mb-4" style="padding: 30px;">
                        <h1 class="fa fa-phone-volume text-primary m-0 mr-3"></h1>
                        <h5 class="font-weight-semi-bold m-0">24/7 Support</h5>
                    </div>
                </div>
            </div>
        </div>
        <!-- Featured End -->


        <!-- Categories Start -->
        <div class="container-fluid pt-5">
            <h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4"><span class="bg-secondary pr-3">Categories</span></h2>
            <div class="row px-xl-5 pb-3">
                <!--                -->

                <c:forEach items="${sessionScope.data}" var="c">
                    <c:set var="cid" value="${c.id}" />
                    <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
                        <a class="text-decoration-none" href="products?cid=${c.id}">
                            <div class="cat-item d-flex align-items-center mb-4">
                                <div class="overflow-hidden" style="width: 100px; height: 100px;">
                                    <img class="img-fluid" src="${c.url_image}" alt="">
                                </div>
                                <div class="flex-fill pl-3">
                                    <h6>${c.name}</h6>
                                    <small class="text-body">Have Product</small>
                                </div>
                            </div>
                        </a>
                    </div>
                </c:forEach>


            </div>
        </div>
        <!-- Categories End -->


        <!-- Products Start -->
        <div class="container-fluid pt-5 pb-3">
            <h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4"><span class="bg-secondary pr-3">Featured Products</span></h2>
            <div class="row px-xl-5">
                <c:forEach items="${requestScope.list}" var="p">
                    <c:set var="pid" value="${p.id}" />
                    <c:set var="idproc" value="${p.id}" />
                    <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
                        <div class="product-item bg-light mb-4">
                            <div class="product-img position-relative overflow-hidden">
                                <img class="img-fluid w-100" src="${p.image}" alt="">
                                <div class="product-action">
                                    <a class="btn btn-outline-dark btn-square" href="" onclick="doAddCart('${p.id}','${p.name}','${sessionScope.infor.username}')"><i class="fa fa-shopping-cart"></i></a>
                                    <a class="btn btn-outline-dark btn-square" href=""><i class="far fa-heart"></i></a>
                                    <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-sync-alt"></i></a>
                                    <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-search"></i></a>
                                </div>
                            </div>
                            <div class="text-center py-4">
                                <c:set var="detailid" value="${p.id}" />
                                <a class="h6 text-decoration-none text-truncate" href="productdetail?detailid=${p.id}">${p.name}</a>
                                <div class="d-flex align-items-center justify-content-center mt-2">
                                    <h5 style="color: #ee4d2d"><s:formatNumber value="${p.price}" type="currency"/></h5>
                                    <h5 style="margin-left: 5px;">VND</h5>
                                    <h6 class="text-muted ml-2">(${p.quantity})</h6>
                                </div>
                                <div class="d-flex align-items-center justify-content-center mb-1">
                                    <c:forEach begin="1" end="${p.rate}" step="1" var="i">
                                        <small class="fa fa-star text-primary mr-1"></small>
                                    </c:forEach>
                                    <c:forEach begin="${p.rate}" end="4" step="1" var="i">
                                        <small class="far fa-star text-primary mr-1"></small>
                                    </c:forEach>


                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        <!-- Products End -->


        <!-- Offer Start -->
        <div class="container-fluid pt-5 pb-3">
            <div class="row px-xl-5">
                <div class="col-md-6">
                    <div class="product-offer mb-30" style="height: 300px;">
                        <img class="img-fluid" src="img/offer-1.jpg" alt="">
                        <div class="offer-text">
                            <h6 class="text-white text-uppercase">Save 20%</h6>
                            <h3 class="text-white mb-3">Special Offer</h3>
                            <a href="" class="btn btn-primary">Shop Now</a>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="product-offer mb-30" style="height: 300px;">
                        <img class="img-fluid" src="img/offer-2.jpg" alt="">
                        <div class="offer-text">
                            <h6 class="text-white text-uppercase">Save 20%</h6>
                            <h3 class="text-white mb-3">Special Offer</h3>
                            <a href="" class="btn btn-primary">Shop Now</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- Offer End -->


        <!-- Products Start -->
        <div class="container-fluid pt-5 pb-3">
            <h2 class="section-title position-relative text-uppercase mx-xl-5 mb-4"><span class="bg-secondary pr-3">Recent Products</span></h2>
            <div class="row px-xl-5">
                <c:forEach items="${requestScope.list2}" var="p2">
                    <c:set var="pid" value="${p2.id}" />
                    <c:set var="idproc" value="${p2.id}" />
                    <div class="col-lg-3 col-md-4 col-sm-6 pb-1">
                        <div class="product-item bg-light mb-4">
                            <div class="product-img position-relative overflow-hidden">
                                <img class="img-fluid w-100" src="${p2.image}" alt="">
                                <div class="product-action">
                                    <a class="btn btn-outline-dark btn-square" href="" onclick="doAddCart('${p2.id}','${p2.name}','${sessionScope.infor.username}')"><i class="fa fa-shopping-cart"></i></a>
                                    <a class="btn btn-outline-dark btn-square" href=""><i class="far fa-heart"></i></a>
                                    <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-sync-alt"></i></a>
                                    <a class="btn btn-outline-dark btn-square" href=""><i class="fa fa-search"></i></a>
                                </div>
                            </div>
                            <div class="text-center py-4">
                                <c:set var="detailid" value="${p2.id}" />
                                <a class="h6 text-decoration-none text-truncate" href="productdetail?detailid=${p2.id}">${p2.name}</a>
                                <div class="d-flex align-items-center justify-content-center mt-2">
                                    <h5 style="color: #ee4d2d"><s:formatNumber value="${p2.price}" type="currency"/></h5>
                                    <h5 style="margin-left: 5px;">VND</h5>
                                    <h6 class="text-muted ml-2">(${p2.quantity})</h6>
                                </div>
                                <div class="d-flex align-items-center justify-content-center mb-1">
                                    <c:forEach begin="1" end="${p2.rate}" step="1" var="i">
                                        <small class="fa fa-star text-primary mr-1"></small>
                                    </c:forEach>
                                    <c:forEach begin="${p2.rate}" end="4" step="1" var="i">
                                        <small class="far fa-star text-primary mr-1"></small>
                                    </c:forEach>
                                    <small>(${p2.rate})</small>

                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
        </div>
        <!-- Products End -->
        <!-- Vendor Start -->
        <div class="container-fluid py-5">
            <div class="row px-xl-5">
                <div class="col">
                    <div class="owl-carousel vendor-carousel">
                        <div class="bg-light p-4" style="float: left;">
                            <img src="img/vendor-1.jpg" alt="">
                        </div>
                        <div class="bg-light p-4" style="float: left;">
                            <img src="img/vendor-2.jpg" alt="">
                        </div>
                        <div class="bg-light p-4" style="float: left;">
                            <img src="img/vendor-3.jpg" alt="">
                        </div>
                        <div class="bg-light p-4" style="float: left;">
                            <img src="img/vendor-4.jpg" alt="">
                        </div>
                        <div class="bg-light p-4" style="float: left;">
                            <img src="img/vendor-5.jpg" alt="">
                        </div>
                        <div class="bg-light p-4" style="float: left;">
                            <img src="img/vendor-6.jpg" alt="">
                        </div>
                        <div class="bg-light p-4" style="float: left;">
                            <img src="img/vendor-7.jpg" alt="">
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <!-- Vendor End -->
        <!--Back to top-->
        <a href="#" class="btn btn-primary back-to-top" style="display: inline;"><i class="fa fa-angle-double-up"></i></a>
        <!-- JavaScript Libraries -->
        <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
        <script src="lib/easing/easing.min.js"></script>
        <script src="lib/owlcarousel/owl.carousel.min.js"></script>

        <!-- Contact Javascript File -->
        <script src="mail/jqBootstrapValidation.min.js"></script>
        <script src="mail/contact.js"></script>

        <!-- Template Javascript -->
        <script src="js/main.js"></script>
    </body>

</html>
