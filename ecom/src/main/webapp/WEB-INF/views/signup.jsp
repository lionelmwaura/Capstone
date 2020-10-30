<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<!--[if IE]>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<![endif]-->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Lionel">

<!-- Favicons Icon -->

<title>Sign up</title>

<!-- Mobile Specific -->
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

<!-- CSS Style -->
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
<body>
<jsp:include page="components/header.jsp"></jsp:include>
<div class="container">
	  <div class="col-lg-6">
              <div class="box">
                <h1 class="text-center"> ${msg}</h1>
                <h3 class="text-muted"><span class="text-danger">${error}</span></h3>
                <hr>
                <form:form action="register" modelAttribute="users" method="post">
                  <h3 class="text-danger">${_error}</h3>
                  <div class="form-group">
                    <label for="fName">First Name</label>
                    <form:input path="fName"  class="form-control" placeholder="First Name"/>
                    <form:errors path="fName" class="text-danger text-center"/>
                  </div>
                  <div class="form-group">
                    <label for="lName">Last Name</label>
                    <form:input path="lName"  class="form-control" placeholder="Last Name"/>
                    <form:errors path="lName" class="text-danger text-center"/>
                  </div>
                  <div class="form-group">
                    <label for="email">Email</label>
                    <form:input path="email" id="e-mail" type="email" class="form-control" placeholder="Last Name"/>
                    <form:errors path="email" class="text-danger text-center"/>
                  </div>
                  <div class="form-group">
                    <label for="password">Password</label>
                    <form:input path="password" type="password" id="pass" class="form-control" placeholder="password"/>
                   <form:errors path="password"  class="text-danger text-center"/>
                  </div>
                  <div class="form-group">
                    <label for="password2">Re-Enter Password</label>
                    <form:input path="password2" id="pass2" type="password" class="form-control" placeholder="Re-enter password"/>
                   <form:errors path="password2" class="text-danger text-center"/>
                  </div>
                  <div class="text-left">
                    <button type="submit" class="btn btn-primary" id="submit-register"><i class="fa fa-user-md"></i> Register</button>
                  </div>
                
                </form:form>
              </div>
            </div>

</div>
</body>
</html>