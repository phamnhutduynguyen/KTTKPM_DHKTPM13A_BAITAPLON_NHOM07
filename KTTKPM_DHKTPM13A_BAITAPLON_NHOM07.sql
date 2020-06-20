use master
go
CREATE DATABASE KTTKPM_DHKTPM13A_BAITAPLON_NHOM07
go
USE [KTTKPM_DHKTPM13A_BAITAPLON_NHOM07]
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietDonHang](
	[MaDonHang] [int] NOT NULL,
	[MaSanPham] [int] NOT NULL,
	[SoLuongSanPham] [int] NULL,
	[GiaSanPham] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDonHang] ASC,
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DanhMuc](
	[MaDanhMuc] [int] IDENTITY(1,1) NOT NULL,
	[TenDanhMuc] [nvarchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDanhMuc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DonHang](
	[MaDonHang] [int] IDENTITY(1,1) NOT NULL,
	[MaNguoiDung] [int] NULL,
	[NgayTaoDonHang] [date] NULL,
	[TinhTrangDonHang] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaDonHang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[NguoiDung](
	[MaNguoiDung] [int] IDENTITY(1,1) NOT NULL,
	[TenNguoiDung] [nvarchar](30) NOT NULL,
	[DiaChi] [nvarchar](200) NULL,
	[Email] [varchar](50) NULL,
	[SoDienThoai] [varchar](15) NULL,
	[Username] [varchar](30) NOT NULL,
	[Pass] [varchar](40) NOT NULL,
	[isNhanVien] [bit] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNguoiDung] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SanPham](
	[MaSanPham] [int] IDENTITY(1,1) NOT NULL,
	[TenSanPham] [nvarchar](100) NOT NULL,
	[Gia] [int] NOT NULL,
	[SoLuong] [int] NOT NULL,
	[MoTa] [nvarchar](500) NULL,
	[Hinh] [nvarchar](500) NULL,
	[MaDanhMuc] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[MaSanPham] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[ChiTietDonHang] ([MaDonHang], [MaSanPham], [SoLuongSanPham], [GiaSanPham]) VALUES (1, 1, 1, 30000)
INSERT [dbo].[ChiTietDonHang] ([MaDonHang], [MaSanPham], [SoLuongSanPham], [GiaSanPham]) VALUES (1, 2, 3, 20000)
INSERT [dbo].[ChiTietDonHang] ([MaDonHang], [MaSanPham], [SoLuongSanPham], [GiaSanPham]) VALUES (2, 3, 3, 15000)
INSERT [dbo].[ChiTietDonHang] ([MaDonHang], [MaSanPham], [SoLuongSanPham], [GiaSanPham]) VALUES (2, 4, 4, 15000)
SET IDENTITY_INSERT [dbo].[DanhMuc] ON 

INSERT [dbo].[DanhMuc] ([MaDanhMuc], [TenDanhMuc]) VALUES (1, N'Chiên')
INSERT [dbo].[DanhMuc] ([MaDanhMuc], [TenDanhMuc]) VALUES (2, N'Nướng')
SET IDENTITY_INSERT [dbo].[DanhMuc] OFF
SET IDENTITY_INSERT [dbo].[DonHang] ON 

INSERT [dbo].[DonHang] ([MaDonHang], [MaNguoiDung], [NgayTaoDonHang], [TinhTrangDonHang]) VALUES (1, 2, CAST(0x173F0B00 AS Date), 1)
INSERT [dbo].[DonHang] ([MaDonHang], [MaNguoiDung], [NgayTaoDonHang], [TinhTrangDonHang]) VALUES (2, 2, CAST(0x613E0B00 AS Date), 1)
SET IDENTITY_INSERT [dbo].[DonHang] OFF
SET IDENTITY_INSERT [dbo].[NguoiDung] ON 

INSERT [dbo].[NguoiDung] ([MaNguoiDung], [TenNguoiDung], [DiaChi], [Email], [SoDienThoai], [Username], [Pass], [isNhanVien]) VALUES (1, N'Phạm Nhứt Nguyên', N'Gò Vấp', N'phamnhutduynguyen@gmail.com', N'0123456789', N'1', N'1', 1)
INSERT [dbo].[NguoiDung] ([MaNguoiDung], [TenNguoiDung], [DiaChi], [Email], [SoDienThoai], [Username], [Pass], [isNhanVien]) VALUES (2, N'Phạm Duy Nguyên', N'Tần Bình', N'gianguyengiaa3@gmail.com', N'0123456654', N'2', N'2', 0)
SET IDENTITY_INSERT [dbo].[NguoiDung] OFF
SET IDENTITY_INSERT [dbo].[SanPham] ON 

INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Gia], [SoLuong], [MoTa], [Hinh], [MaDanhMuc]) VALUES (1, N'Món Ăn 1', 30000, 20, N'Món Ăn 1', N'images/HinhSanPham/hinh1.jpg', 1)
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Gia], [SoLuong], [MoTa], [Hinh], [MaDanhMuc]) VALUES (2, N'Món Ăn 2', 15000, 15, N'Món Ăn 2', N'images/HinhSanPham/hinh2.jpg', 1)
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Gia], [SoLuong], [MoTa], [Hinh], [MaDanhMuc]) VALUES (3, N'Món Ăn 3', 15000, 15, N'Món Ăn 3', N'images/HinhSanPham/hinh3.jpg', 1)
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Gia], [SoLuong], [MoTa], [Hinh], [MaDanhMuc]) VALUES (4, N'Món Ăn 4', 15000, 15, N'Món Ăn 4', N'images/HinhSanPham/hinh4.jpg', 1)
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Gia], [SoLuong], [MoTa], [Hinh], [MaDanhMuc]) VALUES (5, N'Món Ăn 5', 30000, 20, N'Món Ăn 5', N'images/HinhSanPham/hinh5.jpg', 1)
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Gia], [SoLuong], [MoTa], [Hinh], [MaDanhMuc]) VALUES (6, N'Món Ăn 6', 15000, 15, N'Món Ăn 6', N'images/HinhSanPham/hinh6.jpg', 1)
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Gia], [SoLuong], [MoTa], [Hinh], [MaDanhMuc]) VALUES (7, N'Món Ăn 7', 15000, 15, N'Món Ăn 7', N'images/HinhSanPham/hinh7.jpg', 1)
INSERT [dbo].[SanPham] ([MaSanPham], [TenSanPham], [Gia], [SoLuong], [MoTa], [Hinh], [MaDanhMuc]) VALUES (8, N'Món Ăn 8', 15000, 15, N'Món Ăn 8', N'images/HinhSanPham/hinh8.jpg', 1)
SET IDENTITY_INSERT [dbo].[SanPham] OFF
ALTER TABLE [dbo].[ChiTietDonHang]  WITH CHECK ADD FOREIGN KEY([MaDonHang])
REFERENCES [dbo].[DonHang] ([MaDonHang])
GO
ALTER TABLE [dbo].[ChiTietDonHang]  WITH CHECK ADD FOREIGN KEY([MaSanPham])
REFERENCES [dbo].[SanPham] ([MaSanPham])
GO
ALTER TABLE [dbo].[DonHang]  WITH CHECK ADD FOREIGN KEY([MaNguoiDung])
REFERENCES [dbo].[NguoiDung] ([MaNguoiDung])
GO
ALTER TABLE [dbo].[SanPham]  WITH CHECK ADD FOREIGN KEY([MaDanhMuc])
REFERENCES [dbo].[DanhMuc] ([MaDanhMuc])
GO
