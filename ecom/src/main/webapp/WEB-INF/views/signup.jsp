<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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