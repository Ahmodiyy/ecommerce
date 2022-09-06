
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/includes/head.jsp"%>
        <title>E-Commerce Cart</title>
    </head>
    <body>
        <%@include file="/includes/navbar.jsp"%>
        <div class="container" ng-app="products">
            <div class="card-header my-3">Products</div>
          
            <div class="row">
                <div class="col-md-6 my-6">
                    <div class="card w-100">
                        <img class="card-img-top" src="image/gionee.jpg"
                             alt="Card image cap">
                    </div>
                </div>
               <div class="col-md-6 my-6" >
                    <h2 class="title">Iphone 13</h2>
                    <h5 class="price">$567</h5>
                    <h5 class="category">phone</h5>
                    <h6>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</h6>
                    <div class="form-group d-flex justify-content-between">
               
                    <input type="text" name="quantity" class="form-control"  value="1"> 
                    </div>
                    <div class="mt-3 d-flex justify-content-between">
                    <a class="btn btn-dark" href="">Add to Cart</a>
                    </div>
                </div>
            </div>
         
        </div>
        <%@include file="/includes/footer.jsp"%>
    </body>
</html>