<%--
  Created by IntelliJ IDEA.
  User: JAKARIN
  Date: 11/5/2021
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:choose>
    <c:when test="${cart==null || empty cart.allItem}">
        <h3 class="text-danger">No item in your shopping cart</h3>
    </c:when>
    <c:otherwise>
        <table class="table table-striped table-bordered w-100">
            <thead>
            <th>#</th>
            <th>Code</th>
            <th>Description</th>
            <th>Quantity</th>
            <th>Price</th>
            <th>Total</th>
            </thead>
            <tbody>
            <c:forEach items="${cart.allItem}" var="lineItem" varStatus="vs">
                <tr>
                    <td>${vs.count}</td>
                    <td>${lineItem.product.id}</td>
                    <td>${lineItem.product.productName}</td>
                    <td>
                            ${lineItem.quantity}
                                <i class="bi bi-bag-plus"onclick="addToCart('${lineItem.product.id}'),setTimeout(()=>viewCart(),500)" ></i></span>
                                <i class="bi bi-bag-dash"onclick="removeToCart('${lineItem.product.id}'),setTimeout(()=>viewCart(),250)"></i></span>
                    </td>
                    <td>${lineItem.product.msrp}</td>
                    <td>
                        <fmt:formatNumber pattern="##.00" value="${lineItem.total}"/>
                    </td>
                </tr>
            </c:forEach>
            <tr>
                <td colspan="5" style="text-align: right;margin-right: 5px">Total</td>
                <td>
                     <fmt:formatNumber pattern="#,###.##" value="${cart.totalPrice}"/>
                </td>
            </tr>
            </tbody>
        </table>
    </c:otherwise>
</c:choose>