<%-- 
    Document   : accountmid.jsp
    Created on : Nov 1, 2022, 1:32:53 AM
    Author     : asus
--%>

<%-- Document : account Created on : Oct 30, 2022, 6:18:35 PM Author : asus --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/profile.css" rel="stylesheet">

        <style type="text/css"></style>
    </head>

    <body>
        <div class="container-fluid">
            <div class="container rounded bg-white mt-5 mb-5">
                <form action="accountinfor" method="post">
                    <div class="row">
                        <div class="col-md-3 border-right">
                            <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                                <img class="rounded-circle mt-5" width="150px" src="${sessionScope.infor.image}">
                                <div class="col-md-6"><label class="labels" style="text-align: center;">Url Image :</label><input type="text" class="form-control" name="imagex" placeholder="url image" value="${sessionScope.infor.image}">
                                </div>
                                <span class="font-weight-bold">${sessionScope.infor.firstname} ${sessionScope.infor.lastname}</span>
                                <span class="text-black-50">@${sessionScope.infor.username}</span><span> </span>

                            </div>

                        </div>

                        <div class="col-md-5 border-right">

                            <div class="p-3 py-5">
                                <div class="d-flex justify-content-between align-items-center mb-3">
                                    <h4 class="text-right">Profile Settings</h4>
                                </div>
                                <div class="row mt-2">
                                    <div class="col-md-6"><label class="labels">First Name :</label><input type="text" class="form-control" name="firstnamex" placeholder="first name" value="${sessionScope.infor.firstname}">
                                    </div>
                                    <div class="col-md-6"><label class="labels">Last Name :</label><input type="text" class="form-control" name="lastnamex" value="${sessionScope.infor.lastname}" placeholder="last name">
                                    </div>
                                </div>
                                <div class="row mt-3">
                                    <div class="col-md-12"><label class="labels">Age :</label><input type="text" class="form-control" name="agex" placeholder="age" value="${sessionScope.infor.age}" name="">
                                    </div>
                                    <div class="col-md-12"><label class="labels">Phone Number :</label><input type="text" class="form-control" name="phonex" placeholder="phone number" value="${sessionScope.infor.phonenumber}">
                                    </div>
                                    <div class="col-md-12"><label class="labels">Address :</label><input type="text" class="form-control" name="addressx" placeholder="address" value="${sessionScope.infor.address}">
                                    </div>

                                </div>
                                <div class="row mt-3">
                                    <div class="col-md-6"><label class="labels">Country : </label><input type="text" class="form-control" placeholder="country" value="Kinh">
                                    </div>
                                    <div class="col-md-6"><label class="labels">Region : </label><input type="text" class="form-control" value="Dan toc Kinh" placeholder="state">
                                    </div>
                                </div>
                                <div>
                                    <div style="margin-top: 20px;">
                                        <h5 style="display: inline-block;">Surplus :</h5> 
                                        <h5 style="color: #ee4d2d;display: inline-block;"><s:formatNumber value="${sessionScope.infor.surplus}" type="currency"/></h5>
                                        <h5 style="margin-left: 5px;display: inline-block;">VND</h5>
                                    </div>
                                </div>
                                <div class="mt-5 text-center">
                                    <!--                                    <button class="btn btn-primary profile-button" type="button">-->
                                    <input type="submit" value="Save Profile">

                                    <!--                                    </button>-->
                                </div>
                            </div>

                        </div>

                        <div class="col-md-4">
                            <form action="resetpass" method="post">
                                <div class="p-3 py-5">
                                    <div class="d-flex justify-content-between align-items-center experience">
                                        <h5>Input Change Password :</h5>
                                    </div><br>
                                    <div class="col-md-12"><label class="labels">Password Old : </label><input type="text" class="form-control" placeholder="old pass" name="passold" value="">
                                        <label class="labels">${requestScope.error1}</label>
                                    </div> <br>
                                    <div class="col-md-12"><label class="labels">New Password : </label><input type="text" class="form-control" placeholder="new pass" name="passnew" value="">
                                    <label class="labels">${requestScope.error2}</label>
                                    </div>
                                    
                                </div>
                                    <label class="labels">${requestScope.succ}</label>
                                <div class="col-md-7" style="float: right;">
                                        <input type="submit" value="Change Password">
                                    </div>
                                
                            </form>

                        </div>
                    </div>
                </form>
            </div>
        </div>

    </body>

</html>
