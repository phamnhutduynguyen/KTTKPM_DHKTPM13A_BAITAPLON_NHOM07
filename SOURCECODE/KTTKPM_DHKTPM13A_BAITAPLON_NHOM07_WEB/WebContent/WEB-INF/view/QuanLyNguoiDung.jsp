<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Quản lý người dùng</title>
<link rel="shortcut icon" href="images/favicon.png">

<link href="css/bootstrap.css" rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,300,300italic,400italic,500,700,500italic,100italic,100'
	rel='stylesheet' type='text/css'>
<link href="css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/flexslider.css" type="text/css"
	media="screen" />
<link href="css/styleQuanLy.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrapper">
		<div class="header">
			<div class="container">
				<div class="row">
					<div class="col-md-2 col-sm-2">
						<div class="logo">
							<a href="Home"> <img src="images/HinhWebsite/logo.png"
								alt="Trang chu">
							</a>
						</div>
					</div>
					<div class="col-md-10 col-sm-10">
						<div class="clearfix"></div>
						<div class="header_bottom">
							<div class="navbar-collapse collapse">
								<ul class="nav navbar-nav">
									<li><a href="QuanLyDonHang">Quản lý đơn hàng </a></li>
									<li><a href="QuanLySanPham"> Quản lý sản phẩm </a></li>
									<li><a href="QuanLyNguoiDung"> Quản lý người dùng </a></li>
									<%if (session.getAttribute("user") != null) {%>
									<li style="padding-left: 100px"><a>Xin chào : <strong
											style="color: blue;"><%=session.getAttribute("user")%></strong></a>
									</li>
									<li><a href="DangXuat">Đăng xuất</a></li>
									<%
										} else {
									%>
									<li style="padding-left: 100px"><a href="DangNhap">Đăng
											Nhập</a></li>
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
			<div class="clearfix"></div>
		</div>
		<div class="clearfix"></div>
		<div class="container_fullwidth">
			<div class="container shopping-cart">
				<div class="row">
					<div class="col-md-12">
						<div class="clearfix"></div>
						<table class="shop-table ">
							<thead>
								<tr>
									<th>Mã</th>
									<th>Tên người dùng</th>
									<th>Địa chỉ</th>
									<th>Email</th>
									<th>Số điện thoại</th>
									<th>Tài khoảng</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${dsnd}" var="nd">
									<tr>
										<td>
											<h5>
												<c:out value="${nd.maNguoiDung}"></c:out>
											</h5>
										</td>
										<td>
											<h5>
												<c:out value="${nd.tenNguoiDung}"></c:out>
											</h5>
										</td>
										<td>
											<h5>
												<c:out value="${nd.diaChi}"></c:out>
											</h5>
										</td>
										<td>
											<h5>
												<c:out value="${nd.email}"></c:out>
											</h5>
										</td>
										<td>
											<h5>
												<c:out value="${nd.soDienThoai}"></c:out>
											</h5>
										</td>
										<td>
											<h5>
												<c:out value="${nd.username}"></c:out>
											</h5>
										</td>

									</tr>
								</c:forEach>

							</tbody>
						</table>
						<div class="clearfix"></div>
						<div class="row">
							<div class="subtotal"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="clearfix"></div>
	<%@ include file="fotter.jsp"%>
	<!-- Bootstrap core JavaScript==================================================-->
	<script type="text/javascript" src="js/jquery-1.10.2.min.js">
		
	</script>
	<script type="text/javascript" src="js/bootstrap.min.js">
		
	</script>
	<script defer src="js/jquery.flexslider.js">
		
	</script>
	<script type="text/javascript"
		src="js/jquery.carouFredSel-6.2.1-packed.js">
		
	</script>
	<script type="text/javascript" src="js/script.min.js">
		
	</script>
</body>
</html>