<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-2 col-sm-2">
				<div class="logo">
					<a href="Home"><img src="images/HinhWebsite/logo.png"
						alt="BigBirth Restaurant"></a>
				</div>
			</div>
			<div class="col-md-10 col-sm-10">
				<div class="clearfix"></div>
				<div class="header_bottom">
					<div class="navbar-collapse collapse">
						<ul class="nav navbar-nav">
							<li><a href="Home">Trang Chủ</a></li>
							<li><a href="ThongTinGioHang">Giỏ Hàng</a></li>
							<li class="dropdown"><a href="#" class="dropdown-toggle"
								data-toggle="dropdown">Danh Mục</a>
								<div class="dropdown-menu mega-menu">
									<ul class="mega-menu-links">
										<c:forEach items="${sessionScope.dsdm}" var="dm">
											<li><a
												href="DanhMucSanPham?id=<c:out value="${dm.maDanhMuc}"/>">
													<c:out value="${dm.tenDanhMuc}" />
											</a></li>
										</c:forEach>
									</ul>
								</div></li>
							<%if (session.getAttribute("user") != null) {%>
							<li style="padding-left: 150px"><a>Xin chào : <strong style="color: blue;"><%=session.getAttribute("user")%></strong></a>
							</li>
							<li><a href="DangXuat">Đăng xuất</a></li>
							<%
								} else {
							%>
							<li style="padding-left: 150px"><a href="DangNhap">Đăng Nhập</a></li>
							<li><a href="DangKy">Đăng ký</a></li>
							<%
								}
							%>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>