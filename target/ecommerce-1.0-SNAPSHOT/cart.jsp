<%@page import="java.util.ArrayList"%>
<%@page import="Endpoint.Connections"%>
<%@page import="dao.ProductDao"%>
<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%
    Connections connection = new Connections();
    ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/includes/head.jsp"%>
        <title>E-Commerce Cart</title>
        <style type="text/css">

            .table tbody td{
                vertical-align: middle;
            }
            .btn-incre, .btn-decre{
                box-shadow: none;
                font-size: 25px;
            }
        </style>
    </head>
    <body>
        <%@include file="/includes/navbar.jsp"%>

        <div class="container my-3">
            <div class="d-flex py-3"><h3>Total Price: $ ${(total>0)?dcf.format(total):0} </h3> <a class="mx-3 btn btn-primary" href="cart-check-out">Check Out</a></div>
            
                    <%     if (cart_list != null) {
                            for (Cart c : cart_list) {
                            Product p = connection.getProduct(String.valueOf(c.getId()));
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
                    <div class="mt-3 d-flex justify-content-between">
                        <button class="btn btn-dark" type="submit">Submit</button>
                    </div>
                    </form>
                </div>
            </div>
                    
          
                        <a href="remove-from-cart?id=<%=c.getId()%>" class="btn btn-sm btn-danger">Remove</a>
                    

                    <%
                            }
                        }%>
                
        </div>

        <%@include file="/includes/footer.jsp"%>
    </body>
</html>