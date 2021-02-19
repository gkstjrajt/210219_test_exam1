<%@page import="ncs_java_yhs2.dto.Sale"%>
<%@page import="java.util.List"%>
<%@page import="ncs_java_yhs2.dao.SaleDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	SaleDao dao = SaleDao.getInstance();
	List<Sale> list = dao.selectSaleByAll();
%>

<h2>회원매출조회</h2>
<table border="1px solid black">
	<thead>
		<tr>
			<td>회원번호</td>
			<td>회원성명</td>
			<td>고객등급</td>
			<td>매출</td>
		</tr>
	</thead>
	<tbody>
		<% for(Sale sale : list) { %>
			<tr>
				<td><%=sale.getCustNo() %></td>
				<td><%=sale.getCustName() %></td>
				
				<% if(sale.getGrade().equals("A")){ %>
					<td>VIP</td>
				<% } else if(sale.getGrade().equals("B")){ %>
					<td>일반</td>
				<% } else { %>
					<td>직원</td>
				<% } %>
				
				<td><%=sale.getSale() %></td>
			</tr>
		<% } %>
	</tbody>
</table>