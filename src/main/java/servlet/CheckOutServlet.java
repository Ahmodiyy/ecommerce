package servlet;

import model.User;

import model.Cart;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/cart-check-out")
public class CheckOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		try(PrintWriter out = response.getWriter()){
//			ArrayList<Cart> cart_list = (ArrayList<Cart>) request.getSession().getAttribute("cart-list");
//			User auth = (User) request.getSession().getAttribute("auth");
//			if(cart_list != null && auth!=null) {
//				for(Cart c:cart_list) {
//					Order order = new Order();
//					order.setId(c.getId());
//					
//					
//					OrderDao oDao = new OrderDao(DbCon.getConnection());
//					boolean result = oDao.insertOrder(order);
//					if(!result) break;
//				}
//				cart_list.clear();
//				response.sendRedirect("orders.jsp");
//			}else {
//				if(auth==null) {
//					response.sendRedirect("login.jsp");
//				}
//				response.sendRedirect("cart.jsp");
//			}
//		} catch (ClassNotFoundException|SQLException e) {
//			
//			e.printStackTrace();
//		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
