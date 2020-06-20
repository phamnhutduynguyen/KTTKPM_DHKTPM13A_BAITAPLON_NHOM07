<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Quản lý sản phẩm</title>
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
                <a href="Home">
                  <img src="images/HinhWebsite/logo.png" alt="Trang Chu">
                </a>
              </div>
            </div>
            <div class="col-md-10 col-sm-10">
              <div class="header_top">
                <div class="row">
                           <div class="col-md-3">
                              
                           </div>
                           <div class="col-md-6">
 							<strong><p class="white">Nhóm 07</p></strong>
                           </div>
                           <div class="col-md-3">
                           <%if (session.getAttribute("user") != null) {%>
                           <ul class="usermenu">
                           	<li> 
                           	<div><p style="color: white;">Admin :
                           	<strong style="color: blue;"><%=session.getAttribute("user") %></strong></p> 
                           	</div>
                           	</li>
                           	<li><a href="DangXuat" class="log">Đăng xuất</a></li>
                           	</ul>
                           	<%} else{ %>
                              <ul class="usermenu">
                                 <li><a href="DangNhap" class="log">Đăng Nhập</a></li>
                                 <li><a href="DangKy" class="reg">Đăng ký</a></li>
                              </ul>
                              <%} %>
                           </div>
                        </div>
              </div>
              <div class="clearfix">
              </div>
              <div class="header_bottom">
                
              
     <!-- ======================================================================= MENU ================================================================================== -->
                <div class="navbar-collapse collapse">
                  <ul class="nav navbar-nav">
                    <li >
                      <a href="QuanLyDonHang" >
                        Quản lý đơn hàng
                      </a>
                    </li>
                    <li class="active dropdown">
                      <a href="QuanLySanPham">
                        Quan lý sản phẩm
                      </a>
                    </li>
                    <li >
                      <a href="QuanLyNguoiDung" >
                       Quản lý người dùng
                      </a>
                    </li>
                  </ul>
                </div>
    <!-- ======================================================================= MENU ================================================================================== -->
              </div>
            </div>
          </div>
        </div>
        <div class="clearfix">
        </div>
        <div class="page-index">
          <div class="container">
            <button class="" data-toggle="modal" data-target="#myModalThem">
                   Thêm mới sản phẩm
             </button>
          </div>
          
        </div>
      </div>
      <div class="clearfix">
      </div>
      
      
      <!-- ------------------------------------------------------- Code hien thi san pham -------------------------------------------------->
      
      
      <div class="container_fullwidth">
      
        <div class="container shopping-cart">
          <div class="row">
          	
            <div class="col-md-12">
              
              <div class="clearfix">
              </div>
              <table class="shop-table ">
                <thead>
                  <tr>
                    <th>
                      Mã
                    </th>
                    <th>
                      Tên sản hẩm
                    </th>
                    <th>
                      Giá
                    </th>
                    <th>
                      Số lượng
                    </th>
                    <th>
                      Mô tả
                    </th>
                    <th>
                      Danh mục
                    </th>
                    <th>
                      Hình ảnh
                    </th>
                    <th>
                      Sửa
                    </th>
                    <th>
                      Xóa
                    </th>
                  </tr>
                </thead>
                <tbody>
                <c:forEach items="${listsanpham}" var="sp">
                  <tr>
                    <td>
                      <h5>
                       <c:out value="${sp.maSanPham}"></c:out>
                      </h5>
                    </td>
                    <td>
                      <h5>
                       <c:out value="${sp.tenSanPham}"></c:out>
                      </h5>
                    </td>
                    <td>
                      <h5>
                       <c:out value="${sp.gia}"></c:out>
                      </h5>
                    </td>
                    <td>
                      <h5>
                       <c:out value="${sp.soLuong}"></c:out>
                      </h5>
                    </td>
                    <td>
                      <h5>
                       <c:out value="${sp.moTa}"></c:out>
                      </h5>
                    </td>
                    
                    <td>
                    	<h5>
                       <c:out value="${sp.maDanhMuc.tenDanhMuc}"></c:out>
                      </h5>
                    	
                    </td>
                    <td>
                      <img src='<c:out value="${sp.hinh}"></c:out>' alt="">
                    </td>
                    <td>
                    	<a href="SuaSanPham_QuanLy?id=<c:out value="${sp.maSanPham}"/>">
                    		<input type="button" value="Sửa" class="btn btn-success">
                    	</a>
                    </td>
                    <td>
                    	<a href="XoaSanPham_QuanLy?id=<c:out value="${sp.maSanPham}"/>" >	
                    		<input type="button" value="Xóa" class="btn btn-danger">
                    	</a>
                    </td>
                    
                  </tr>
                  
                  </c:forEach>
                
                </tbody>
     <!-- -------------------------------------------------------------------------------------------------------------------- Modal thêm-->
		  <div class="modal fade" id="myModalThem" role="dialog">
		    <div class="modal-dialog">
		    
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Thêm sản phẩm</h4>
		        </div>
		        <div class="modal-body">
		          <form action="QuanLySanPham?cn=1" method="post">
					  <div class="form-group">
					    <label >Tên sản phẩm :</label>
					    <input type="text" class="form-control" name="tensanpham" required>
					  </div>
					  <div class="form-group">
					    <label >Giá:</label>
					    <input type="text"" class="form-control" name="gia" required>
					  </div>
					  <div class="form-group">
					    <label >Số lượng:</label>
					    <input type="text" class="form-control" name="soluong" required pattern="^([1-9][0-9]{0,2}|1000)$">
					  </div>
					  <div class="form-group">
					    <label >Mô tả:</label>
					    <input type="text" class="form-control" name="mota">
					  </div>
					  <div class="form-group">
					    <label >Link ảnh:</label>
					    <input type="text" class="form-control" name="hinh" pattern="([/|\w|\s|-])*\.(?:jpg|gif|png)">
					  </div>
					  <div class="form-group">
					    <label>Danh muc:</label>
						<select class="form-control" name="madanhmuc" required>
							<c:forEach items="${dsdm}" var="dsdm">
								<option value="${dsdm.maDanhMuc}"><c:out value="${dsdm.maDanhMuc} | ${dsdm.tenDanhMuc}"></c:out> </option>
							</c:forEach>
						</select>
					  </div>
					  <button type="submit" class="btn btn-primary" >Lưu</button>
				</form>
		        
      
		    </div>
		  </div>
   
              
               
	 <!-- -------------------------------------------------------------------------------------------------------------------- Modal xóa -->
	 	<div class="modal fade" id="myModalXoa" role="dialog">
		    <div class="modal-dialog">
		    
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">Xóa sản phẩm</h4>
		        </div>
		        <div class="modal-body">
		          <h3>Bạn có chắc chắn muôn xóa sản phẩm này không?</h3>
		        </div>
		        <div class="modal-footer">
		        	<button type="button" class="btn btn-default" data-dismiss="modal">Không</button>
		        	<a href="QuanLySanPham?cn=3" >
		        		<button type="button" class="btn btn-default" data-dismiss="modal">Có</button>
		        	</a>
		        </div>
		      </div>
      
		    </div>
		  </div>
	 <!-- -------------------------------------------------------------------------------------------------------------------- Modal -->
	 </table>
              <div class="clearfix">
              </div>
              <div class="row">
                    <div class="subtotal">
                      
                    
                  </div>
                </div>
              </div>
            </div>
          </div>
         <!-- ----------------------------------------------------------------------------------------------------------------------- -->
        </div>
      </div>
      <div class="clearfix">
      </div>
       <%@ include file="fotter.jsp" %>
    </div>
    <!-- Bootstrap core JavaScript==================================================-->
    <script type="text/javascript" src="js/jquery-1.10.2.min.js">
    </script>
    <script type="text/javascript" src="js/bootstrap.min.js">
    </script>
    <script defer src="js/jquery.flexslider.js">
    </script>
    <script type="text/javascript" src="js/jquery.carouFredSel-6.2.1-packed.js">
    </script>
    <script type="text/javascript" src="js/script.min.js" >
    </script>
</body>
</html>