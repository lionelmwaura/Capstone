<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<!--[if IE]>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<!-- Favicons Icon -->

<title>Shop</title>

<!-- Mobile Specific -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- CSS Style -->

<link rel="stylesheet" href="static/css/fancybox.css" type="text/css">
<link rel="stylesheet" href="static/css/animate.css" type="text/css">
<link rel="stylesheet" href="static/css/bootstrap.min.css" type="text/css">
<link rel="stylesheet" href="static/css/style.css" type="text/css">
<link rel="stylesheet" href="static/css/revslider.css" type="text/css">
<link rel="stylesheet" href="static/css/owl.carousel.css" type="text/css">
<link rel="stylesheet" type="text/css" href="static/css/flexslider.css">
<link rel="stylesheet" href="static/css/owl.theme.css" type="text/css">
<link rel="stylesheet" href="static/css/font-awesome.css" type="text/css">

<link rel="stylesheet" type="text/css" href="static/css/internal.css">
<link rel="stylesheet" type="text/css" href="static/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="static/css/font-awesome.css" media="all">
<link rel="stylesheet" type="text/css" href="static/css/simple-line-icons.css" media="all">
<link rel="stylesheet" type="text/css" href="static/css/style.css" media="all">
<link rel="stylesheet" type="text/css" href="static/css/revslider.css" >
<link rel="stylesheet" type="text/css" href="static/css/owl.carousel.css">
<link rel="stylesheet" type="text/css" href="static/css/owl.theme.css">
<link rel="stylesheet" type="text/css" href="static/css/flexslider.css">
<link rel="stylesheet" type="text/css" href="static/css/jquery.mobile-menu.css">

<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Raleway:400,100,200,300,500,600,700,800,900' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300italic,300,600,600italic,400italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
</head>

<body class="customer-account-login inner-page">
<div id="page"> 
  
  <!-- Header -->
  <jsp:include page="components/header.jsp"/>
  <!-- end header --> 
   
  <!-- Main Container -->
  <div class="col-main col-sm-9 animated" style="visibility: visible;">
          <div class="my-account">
            <div class="page-title">
              <h1>Welcome back ${user_account.fName}  ${msg}<a href="#" data-toggle="modal" data-target="#edits"> <i class="fa fa-pencil"></i></a>
              <br><span class="text-danger">${error}</span></h1>
            </div>
            <div class="product-collateral col-lg-12 col-sm-12 col-xs-12 bounceInUp animated">
                <ul id="product-detail-tab" class="nav nav-tabs product-tabs">
                  <li class="active"> <a href="#acc_info" data-toggle="tab" aria-expanded="true"> Account Detail </a> </li>
                  <li class=""> <a href="#acc_update" data-toggle="tab" aria-expanded="false">Update Address</a></li>
                  <li class=""> <a href="#acc_cards" data-toggle="tab" aria-expanded="false">Cards</a> </li>
                  <li class=""> <a href="#acc_password" data-toggle="tab" aria-expanded="false">Change Password</a> </li>
                  <li class=""> <a href="#acc_products" data-toggle="tab" aria-expanded="false">My Products</a> </li>
                </ul>
                <div id="productTabContent" class="tab-content">
                  <div class="tab-pane fade active in" id="acc_info">
                    <div class="row">
  <!-- Main Container End --> 
  
 <jsp:include page="components/footer.jsp"/>
</div>  
<!-- JavaScript --> 
<script type="text/javascript" src="static/js/jquery.fancybox.js"></script> 
<script type="text/javascript" src="static/js/toggle.js"></script>
<script type="text/javascript" src="static/js/jquery.min.js"></script> 
<script type="text/javascript" src="static/js/bootstrap.min.js"></script> 
<script type="text/javascript" src="static/js/jquery.flexslider.js"></script> 
<script type="text/javascript" src="static/js/parallax.js"></script> 
<script type="text/javascript" src="static/js/common.js"></script> 
<script type="text/javascript" src="static/js/revslider.js"></script> 
<script type="text/javascript" src="static/js/owl.carousel.min.js"></script>
<script type="text/javascript" src="static/js/cloud-zoom.js"></script>
</body>
</html>