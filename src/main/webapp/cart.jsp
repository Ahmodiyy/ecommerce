<%@page import="java.util.ArrayList"%>
<%@page import="Endpoint.Connections"%>
<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%
    Connections connection = new Connections();
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
    long total = 0;
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/includes/head.jsp"%>
        <title>E-Commerce Cart</title>
        <style type="text/css">

            .total{
                display: flex;
                justify-content: center;
                
            }

        </style>
    </head>
    <body>
        <%@include file="/includes/navbar.jsp"%>

        <div class="container my-3">
                    <%     if (cart_list != null) {
                            for (Cart c : cart_list) {
                            Product p = connection.getProduct(String.valueOf(c.getId()));
                            total += p.getPrice()*c.getQuantity();
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
                    <h6><%=c.getQuantity()%></h6>
                    <div class="mt-3 d-flex justify-content-between">
                         <a href="remove-from-cart?id=<%=c.getId()%>" class="btn btn-sm btn-danger">Remove</a>
                    </div>
                   
                </div>
            </div> 
                    <%
                            }
                        }%>
                <div class="row">
                    <div class="col-10"></div>
                    <div class="col-2">
                        <h3>Total Price: $<%= total%></h3> 
                        <a class="mx-3 btn btn-primary" href="cart-check-out">Check Out</a></div>
                    </div>
                    
        </div>

        <%@include file="/includes/footer.jsp"%>
    </body>
</html>