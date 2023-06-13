<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/client/assets" var="url"/>
       <section id="aa-slider">
    <div class="aa-slider-area">
      <div id="sequence" class="seq">
        <div class="seq-screen">
          <ul class="seq-canvas">
            <!-- single slide item -->
            <li>
              <div class="seq-model">
                <img data-seq src="${url}/images/slide1.png" alt="" />
              </div>
              <div class="seq-title">
               <span data-seq>Giảm giá lên đến 50%</span>                
                <h2 data-seq>Các Loại Thẻ</h2>                
                <p data-seq>Nhanh Chóng, Uy Tín.</p>
                <a data-seq href="${pageContext.request.contextPath}/product/list" class="aa-shop-now-btn aa-secondary-btn">Xem Sản Phẩm</a>
              </div>
            </li>
            <!-- single slide item -->
            <li>
              <div class="seq-model">
                <img data-seq src="${url}/images/slide_2.png" alt="" />
              </div>
              <div class="seq-title">
                <span data-seq>Giảm giá lên đến 20%</span>                
                <h2 data-seq>Thẻ Garena</h2>                
                <p data-seq>Nhanh chóng, 1 nốt nhạc.</p>
                <a data-seq href="${pageContext.request.contextPath}/product/list" class="aa-shop-now-btn aa-secondary-btn">Xem Sản Phẩm</a>
              </div>
            </li>
            <!-- single slide item -->
            <li>
              <div class="seq-model">
                <img data-seq src="${url}/images/slide_3.jpg" alt="" />
              </div>
              <div class="seq-title">
                <span data-seq>Giảm giá lên đến 33%</span>                
                <h2 data-seq>Thẻ Viettel</h2>                
                <p data-seq>Chiết Khấu cao.</p>
                <a data-seq href="${pageContext.request.contextPath}/product/list" class="aa-shop-now-btn aa-secondary-btn">Xem Sản Phẩm</a>
              </div>
            </li>
            <!-- single slide item -->           
            <li>
              <div class="seq-model">
                <img data-seq src="${url}/images/slide_4.jpg" alt="" />
              </div>
              <div class="seq-title">
                <span data-seq>Giảm giá lên đến 25%</span>                
                <h2 data-seq>Combo 1 thẻ viettel + 1 thẻ garena</h2>                
                <p data-seq>Là 2 sản phẩm mới bên cửa hàng của chúng tôi,sản phẩm đã được kiểm định
                và cấp phép về an toàn.</p>
                <a data-seq href="${pageContext.request.contextPath}/product/list" class="aa-shop-now-btn aa-secondary-btn">Xem Sản Phẩm</a>
              </div>
            </li>                   
          </ul>
        </div>
        <!-- slider navigation btn -->
        <fieldset class="seq-nav" aria-controls="sequence" aria-label="Slider buttons">
          <a type="button" class="seq-prev" aria-label="Previous"><span class="fa fa-angle-left"></span></a>
          <a type="button" class="seq-next" aria-label="Next"><span class="fa fa-angle-right"></span></a>
        </fieldset>
      </div>
    </div>
  </section>
