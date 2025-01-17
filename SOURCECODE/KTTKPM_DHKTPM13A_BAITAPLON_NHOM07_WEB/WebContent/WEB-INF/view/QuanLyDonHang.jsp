<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý đơn hàng</title>
<link rel="shortcut icon" href="images/favicon.png">

<link href="css/bootstrap.css" rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Roboto:400,300,300italic,400italic,500,700,500italic,100italic,100'
	rel='stylesheet' type='text/css'>
<link href="css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/flexslider.css" type="text/css"
	media="screen" />
<link href="css/styleQuanLyDonHang.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div class="wrapper">
		<div class="header">
			<div class="container">
				<div class="row">
					<div class="col-md-2 col-sm-2">
						<div class="logo">
							<a href="Home"> <img src="images/HinhWebsite/logo.png"
								alt="Trang Chu">
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
									<li style="padding-left: 100px"><a>Xin chào : <strong style="color: blue;"><%=session.getAttribute("user")%></strong></a>
									</li>
									<li><a href="DangXuat">Đăng xuất</a></li>
									<%
										} else {
									%>
									<li style="padding-left: 100px"><a href="DangNhap">Đăng Nhập</a></li>
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
						<h2>Đơn hàng mới</h2>
						<table class="shop-table ">
							<thead>
								<tr>
									<th>Mã</th>
									<th>Danh sách sản phẩm
										<table class="tablemini">
											<tr>
												<th>Tên Sản Phẩm</th>
												<th>Số lượng</th>
											</tr>
										</table>
									</th>
									<th>Thông tin khách hàng</th>
									<th>Hủy đơn hàng</th>
									<th>Xác nhận đơn hàng</th>
								</tr>
							</thead>
							<tbody>
								<c:set var="stt" value="0" />
								<c:forEach items="${dsdhfalse}" var="dh">
									<tr>
										<td><c:set var="stt" value="${stt+1}" /> <c:out
												value="${stt}" /></td>
										<td>
											<table class="tablemini">
												<c:forEach items="${dh.chiTietDonHangList}" var="listctdh">
													<tr>
														<th><h5>
																<c:out value="${listctdh.sanPham.tenSanPham}" />
															</h5></th>
														<th><h5>
																<c:out value="${listctdh.soLuongSanPham}" />
															</h5></th>
													</tr>
												</c:forEach>
											</table>
										</td>
										<td>
											<h5>
												User:
												<c:out value="${dh.maNguoiDung.username}"></c:out>
											</h5>
											<h5>
												Họ tên:
												<c:out value="${dh.maNguoiDung.tenNguoiDung}"></c:out>
											</h5>
										</td>
										<td>
											<form action="QuanLyDonHang?cn=1" method="post">
												<input type="submit" value="Hủy" class="btn btn-danger">
											</form>
										</td>
										<td>
											<form
												action="QuanLyDonHang?cn=2&user=<c:out value="${dh.maNguoiDung.username}"/>"
												method="post">
												<input type="submit" value="Xác Nhận"
													class="btn btn-success">
											</form>
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
			<hr>
			<div class="container shopping-cart">
				<div class="row">
					<div class="col-md-12">
						<div class="clearfix"></div>
						<h2>Đơn hàng cũ</h2>
						<table class="shop-table ">
							<thead>
								<tr>
									<th>Mã</th>
									<th>Danh sách sản phẩm
										<table class="tablemini">
											<tr>
												<th>Tên</th>
												<th>Số lượng</th>
												<th>Giá</th>
											</tr>
										</table>
									</th>
									<th>Khách hàng</th>
									<th>Ngày Tạo</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${dsdhtrue}" var="dh">
									<tr>
										<td>
											<h5>
												<c:out value="${dh.maDonHang}"></c:out>
											</h5>
										</td>
										<td>
											<table class="tablemini">
												<c:forEach items="${dh.chiTietDonHangList}" var="listctdh">
													<tr>
														<th><h5>
																<c:out value="${listctdh.sanPham.tenSanPham}" />
															</h5></th>
														<th><h5>
																<c:out value="${listctdh.soLuongSanPham}" />
															</h5></th>
														<th><h5>
																<c:out value="${listctdh.giaSanPham}" />
															</h5></th>
													</tr>
												</c:forEach>
											</table>
										</td>
										<td>
											<h5>
												<c:out value="${dh.maNguoiDung.username}"></c:out>
											</h5>
										</td>
										<td>
											<h5>
												<c:out value="${dh.ngayTaoDonHang}"></c:out>
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
	<script type="text/javascript" src="js/jquery-1.10.2.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script defer src="js/jquery.flexslider.js"></script>
	<script type="text/javascript" src="js/jquery.carouFredSel-6.2.1-packed.js"></script>
	<script type="text/javascript" src="js/script.min.js"></script>
</body>
</html>