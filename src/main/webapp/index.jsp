<%@page import="model.Product"%>
<%@page import="Endpoint.Connections"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%
    Connections connection = new Connections();
    List<Product> products = connection.getProducts();
%>
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
             <%     if (products != null) {
                        for (Product p : products) {
                %>
            <div class="row">
                <div class="col-md-6 my-6">
                    <div class="card w-100">
                        <img class="card-img-top" src="image/<%=p.getImage()%>"
                             alt="Card image cap">
                    </div>
                </div>
               <div class="col-md-6 my-6" >
                    <h2 class="name"><%=p.getName()%></h2>
                    <h5 class="price">$<%=p.getPrice()%></h5>
                    <h4>Description</h4>
                    <h6><%=p.getDescription()%></h6>
                    <h4>Quantity</h4>
                    <form action="add-to-cart" method="get">
                    <div class="form-group d-flex justify-content-between">
                    <input type="text" name="quantity" class="form-control"  value="1">
                    <input type="text" name="productId" class="form-control" hidden="true" value="<%=p.getId()%>"> 
                    </div>
                    <div class="mt-3 d-flex justify-content-between">
                        <button class="btn btn-dark" type="submit">Submit</button>
                    </div>
                    </form>
                </div>
            </div>
            <%
                        }
                    } else {
                        out.println("No product yet");
                    }
                %>
        </div>
        <%@include file="/includes/footer.jsp"%>
    </body>
</html>