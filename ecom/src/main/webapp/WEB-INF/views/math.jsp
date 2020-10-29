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

<title>Math</title>

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
<style id="jsbin-css">
body {
  text-align:center;
  padding-top:40px;
}

#calculator {
  margin:auto;
}
</style>

<style id="sidescroll-css">
div.scrollmenu {
  background-color: rgb(243 234 234 / 15%);
  overflow: auto;
  white-space: nowrap;
}

div.scrollmenu a {
  display: inline-block;
  color: black;
  text-align: center;
  padding: 14px;
  text-decoration: none;
}

div.scrollmenu a:hover {
  background-color: #C2A476;
}
</style>

</head>

<body class="customer-account-login inner-page">
<div id="page"> 
  
   <!-- Header -->
  <jsp:include page="components/header.jsp"/>
  <!-- end header --> 
   
   <!-- Main Container -->
   <!-- Side Bar -->
 <aside class="col-left sidebar col-sm-3 animated" style="visibility: visible;">
          <div class="page-title">
              <h1>Math Help</h1>
            </div>
          <div class="block block-account">
            <br>
            
          <div class="block-content ">
              <h5 id="id">${codeEq}</h5>
              <h5>${help}</h5>
              
            </div>
            <!--block-content--> 
          </div>
          <!--block block-account--> 
          
 </aside>
 <!-- end side bar -->
 
  <div class="col-main col-sm-9 animated" style="visibility: visible;">
 	<div class="page-title">
       <div class="product-collateral col-lg-12 col-sm-12 col-xs-12 bounceInUp animated">
                <ul id="product-detail-tab" class="nav nav-tabs product-tabs">
          
                  <li class="active"> <a href="#all" data-toggle="tab" aria-expanded="true"> All </a> </li>
                  <li class=""> <a href="#math_algebra" data-toggle="tab" aria-expanded="false">Algebra</a></li>
                  <li class=""> <a href="#math_geometry" data-toggle="tab" aria-expanded="false">Geometry</a></li>
                  <li class=""> <a href="#math_statistics" data-toggle="tab" aria-expanded="false">Statistics</a> </li>
                  <li class=""> <a href="#math_calc1" data-toggle="tab" aria-expanded="false">Calculus I</a> </li>
                </ul>
                <div id="productTabContent" class="tab-content">
                  <div class="tab-pane fade active in" id="all">
                    <div class="row">
                    
                    <div class="col-main col-sm-8 animated" style="visibility: visible;">
          			<div class="all">
        				<div class="scrollmenu">
  							<c:forEach var="item" items="${list}">
  									<a href="displayhelp?id=${item.id}" id="${item.id}">${item.equation}</a>
  									
  							</c:forEach>
  							
						</div>
         
            
          		   </div>
        		   </div>       
    			   </div>
  				</div>
  				<div class="tab-pane fade" id="math_algebra">
                    <div class="row">
                    
                    <div class="col-main col-sm-8 animated" style="visibility: visible;">
          			<div class="algebra">
        				<div class="scrollmenu">
  							<c:forEach var="item" items="${list}">
  								<c:if test="${item.math eq 'Algebra'}">
  									<a href="displayhelp?id=${item.id}" id="${item.id}">${item.equation}</a>
  									
  								</c:if>
  							</c:forEach>
						</div>
         
            
          		   </div>
        		   </div>       
    			   </div>
  				</div>
                  <div class="tab-pane fade" id="math_geometry">
                    <div class="row">
                    
                    <div class="col-main col-sm-8 animated" style="visibility: visible;">
          			<div class="geometry">
        				<div class="scrollmenu">
  							<c:forEach var="item" items="${list}">
  								<c:if test="${item.math eq 'Geometry'}">
  									<a href="displayhelp?id=${item.id}" id="${item.id}">${item.equation}</a>
  									
  								</c:if>
  							</c:forEach>
						</div>
         
            
          		   </div>
        		   </div>       
    			   </div>
  				</div>
  				</div>
  				</div>
  				</div>
  				</div>
  <br>
  <div id="calculator" style="width: 600px; height: 400px;">
  	<p><button id="btnNext">Example</button></p>
  	<script src="https://www.desmos.com/api/v1.5/calculator.js?apiKey=dcb31709b452b1cf9dc26972add0fda6"></script>
	<br>
<script>
	
(function () {
	  "use strict";
	  
	  var calculator;
	  var linear = "x+"
	  var quadratic = "x^2+x+";
	  var cubic =  "x^3+x^2+x+";
	  var equation = document.getElementById("id").innerHTML;

	  function between (a, b) {
	    var range = b - a + 1;
	    return a + Math.floor(Math.random() * range);
	  }

	  function getPoints () {
	    return [
	      { x: 0, y: between(-4, 4) },
	      { x: 1, y: between(-5, 5) }
	    ];
	  }
	  
	  function getGradient (points) {
	    return (points[1].y - points[0].y) / (points[1].x - points[0].x);
	  }

	  function pointString (point) {
	    return '(' + point.x + ', ' + point.y + ')';
	  }

	  function lineString (points) {
		var line = "y = ";
		if(equation != null){
			var e = String(equation)
			var gradient = getGradient(points);
			line += gradient + e;
			line += points[0].y;
		} else {
			var gradient = getGradient(points);
			line += gradient + "x+";
			line += points[0].y;
		}
		return line;
	  }

	  function showLine (points) {
	    points.forEach(function (point, i) {
	      calculator.setExpression({id: 'p' + i, latex: pointString(point)});
	    });

	    calculator.setExpression({id:'line', latex: lineString(points)});
	  }

	  function next () {
	    showLine(getPoints());
	  }

	  function init () {
	    var elt = document.getElementById('calculator');
	    calculator = Desmos.GraphingCalculator(elt);
	  	
	    document.getElementById("btnNext").addEventListener('click', next);
	  }
	  
	  init();
	})();
	
	
</script>
</div>
  	
    
        
  <!-- Main Container End --> 
  
 
</div>  
<!-- Javascript -->
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