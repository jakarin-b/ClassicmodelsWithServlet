package sit.int202.classicmodelweb.servlets;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import sit.int202.classicmodelweb.entities.Product;
import sit.int202.classicmodelweb.models.Cart;
import sit.int202.classicmodelweb.models.ClassicModelLineItem;
import sit.int202.classicmodelweb.repositories.ProductRepository;

import java.io.IOException;

@WebServlet(name = "ChangeCartServlet", value = "/dash-cart")
public class DashCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productCode = request.getParameter("productCode");
        HttpSession session = request.getSession();
        Cart<String, ClassicModelLineItem> cart = (Cart) session.getAttribute("cart");

        ProductRepository productRepository = new ProductRepository();
        Product product = productRepository.findProduct(productCode);
        if (product != null) {
            cart.removeEachItem(productCode, new ClassicModelLineItem(product));
        }
        response.getWriter().print(cart.countPiece());

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
