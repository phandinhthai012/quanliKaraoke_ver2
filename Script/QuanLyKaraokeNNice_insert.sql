USE [master]
GO

USE  Karaoke3
GO

-- 1 tao ma tu tang bang nhan vien
CREATE FUNCTION AUTO_ID_NhanVien()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaNhanVien) FROM NhanVien) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaNhanVien, 3) AS INT)) FROM NhanVien
	SET @ID = @ID + 1

	DECLARE @MaNhanVien VARCHAR(7)
	SET @MaNhanVien = 'NV' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaNhanVien
END
GO

-- 2 tao ma tu tang bang khach hang
CREATE FUNCTION AUTO_ID_KhachHang()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaKhachHang) FROM [dbo].[KhachHang]) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaKhachHang, 3) AS INT)) FROM [dbo].[KhachHang]
	SET @ID = @ID + 1

	DECLARE @MaKhachHang VARCHAR(7)
	SET @MaKhachHang = 'KH' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaKhachHang
END
GO

-- 3 tao ma tu tang bang loai phong
CREATE FUNCTION AUTO_ID_LoaiPhong()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaLoaiPhong) FROM LoaiPhong) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaLoaiPhong, 3) AS INT)) FROM LoaiPhong
	SET @ID = @ID + 1

	DECLARE @MaLoaiPhong VARCHAR(7)
	SET @MaLoaiPhong = 'LP' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaLoaiPhong
END
GO

-- 4 tao ma tu tang bang phong
CREATE FUNCTION AUTO_ID_Phong()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaPhong) FROM Phong) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaPhong, 3) AS INT)) FROM Phong
	SET @ID = @ID + 1

	DECLARE @MaPhong VARCHAR(7)
	SET @MaPhong = 'P' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaPhong
END
GO

-- 5 tao ma tu tang bang loai dich vu
CREATE FUNCTION AUTO_ID_LoaiDichVu()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaLoaiDichVu) FROM LoaiDichVu) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaLoaiDichVu, 3) AS INT)) FROM LoaiDichVu
	SET @ID = @ID + 1

	DECLARE @MaLoaiDichVu VARCHAR(7)
	SET @MaLoaiDichVu = 'LDV' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaLoaiDichVu
END
GO

-- 6 tao ma tu tang bang dich vu
CREATE FUNCTION AUTO_ID_DichVu()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaDichVu) FROM DichVu) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaDichVu, 3) AS INT)) FROM DichVu
	SET @ID = @ID + 1

	DECLARE @MaDV VARCHAR(7)
	SET @MaDV = 'DV' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaDV
END
GO

-- 7 tao ma tu tang bang hoa don 
CREATE FUNCTION AUTO_ID_HoaDon()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaHoaDon) FROM HoaDon) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaHoaDon, 3) AS INT)) FROM HoaDon
	SET @ID = @ID + 1

	DECLARE @MaHoaDon VARCHAR(7)
	SET @MaHoaDon = 'HD' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaHoaDon
END
GO

-- 8 tao ma tu tang bang chi tiet hoa don
CREATE FUNCTION AUTO_ID_ChiTietHoaDon()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaChiTietHoaDon) FROM ChiTietHoaDon) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaChiTietHoaDon, 3) AS INT)) FROM ChiTietHoaDon
	SET @ID = @ID + 1

	DECLARE @MaChiTietHoaDon VARCHAR(7)
	SET @MaChiTietHoaDon = 'CTHD' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaChiTietHoaDon
END
GO 

-- 9 tao ma tu tang bang chi tiet dich vu
CREATE FUNCTION AUTO_ID_ChiTietDatPhong()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaChiTietDatPhong) FROM ChiTietDatPhong) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaChiTietDatPhong, 3) AS INT)) FROM ChiTietDatPhong
	SET @ID = @ID + 1

	DECLARE @MaChiTietDatPhong VARCHAR(7)
	SET @MaChiTietDatPhong = 'CTDP' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaChiTietDatPhong
END
GO 

-- 10 tao ma tu tang bang chi tiet dich vu
CREATE FUNCTION AUTO_ID_ChiTietDichVu()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaChiTietDichVu) FROM ChiTietDichVu) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaChiTietDichVu, 3) AS INT)) FROM ChiTietDichVu
	SET @ID = @ID + 1

	DECLARE @MaChiTietDichVu VARCHAR(7)
	SET @MaChiTietDichVu = 'CTDV' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaChiTietDichVu
END
GO 

-- 11 tao ma tu tang bang chi tiet dich vu
CREATE FUNCTION AUTO_ID_PhieuDatPhong()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaPhieuDatPhong) FROM PhieuDatPhong) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaPhieuDatPhong, 3) AS INT)) FROM PhieuDatPhong
	SET @ID = @ID + 1

	DECLARE @MaPhieuDatPhong VARCHAR(7)
	SET @MaPhieuDatPhong = 'PDP' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaPhieuDatPhong
END
GO 

CREATE FUNCTION AUTO_ID_ChiTietPhieuDatPhong()
RETURNS VARCHAR(7)
AS
BEGIN
	DECLARE @ID INT
	IF (SELECT COUNT(MaChiTietPhieuDatPhong) FROM ChiTietPhieuDatPhong) = 0
		SET @ID = 0
	ELSE
		SELECT @ID = MAX(CAST(RIGHT(MaChiTietPhieuDatPhong, 3) AS INT)) FROM ChiTietPhieuDatPhong
	SET @ID = @ID + 1

	DECLARE @MaChiTietPhieuDatPhong VARCHAR(7)
	SET @MaChiTietPhieuDatPhong = 'CTPD' + RIGHT('00' + CAST(@ID AS VARCHAR(3)), 3)

	RETURN @MaChiTietPhieuDatPhong
END
GO 

---------------
---------------

ALTER TABLE [dbo].[NhanVien]
ADD DEFAULT DBO.AUTO_ID_NhanVien()
FOR [MaNhanVien]
GO

ALTER TABLE [dbo].[ChiTietDatPhong]
ADD DEFAULT DBO.AUTO_ID_ChiTietDatPhong()
FOR MaChiTietDatPhong
GO

ALTER TABLE [dbo].[ChiTietDichVu]
ADD DEFAULT DBO.AUTO_ID_ChiTietDichVu()
FOR MaChiTietDichVu
GO

ALTER TABLE [dbo].[ChiTietHoaDon]
ADD DEFAULT DBO.AUTO_ID_ChiTietHoaDon()
FOR MaChiTietHoaDon
GO

ALTER TABLE [dbo].[ChiTietPhieuDatPhong]
ADD DEFAULT DBO.AUTO_ID_ChiTietPhieuDatPhong()
FOR MaChiTietPhieuDatPhong
GO

ALTER TABLE [dbo].[DichVu]
ADD DEFAULT DBO.AUTO_ID_DichVu()
FOR MaDichVu
GO

ALTER TABLE [dbo].[HoaDon]
ADD DEFAULT DBO.AUTO_ID_HoaDon()
FOR MaHoaDon
GO

ALTER TABLE [dbo].[KhachHang]
ADD DEFAULT DBO.AUTO_ID_KhachHang()
FOR MaKhachHang
GO

ALTER TABLE [dbo].[LoaiDichVu]
ADD DEFAULT DBO.AUTO_ID_LoaiDichVu()
FOR MaLoaiDichVu
GO

ALTER TABLE [dbo].[LoaiPhong]
ADD DEFAULT DBO.AUTO_ID_LoaiPhong()
FOR MaLoaiPhong
GO

ALTER TABLE [dbo].[PhieuDatPhong]
ADD DEFAULT DBO.AUTO_ID_PhieuDatPhong()
FOR MaPhieuDatPhong
GO

ALTER TABLE [dbo].[Phong]
ADD DEFAULT DBO.AUTO_ID_Phong()
FOR MaPhong
GO

CREATE TRIGGER ThemHoaDon
ON HoaDon
AFTER INSERT 
AS
	DECLARE @MaKhachHang VARCHAR(7)
	SELECT @MaKhachHang = INSERTED.MaKhachHang FROM INSERTED
	IF NOT EXISTS (SELECT * FROM [dbo].[KhachHang] WHERE MaKhachHang = @MaKhachHang)
		ROLLBACK
	
	UPDATE [dbo].[KhachHang]
	SET SoLanDatPhong = SoLanDatPhong + 1
	WHERE MaKhachHang = @MaKhachHang
GO

----------------------------------------------------
----------------------------------------------------


INSERT INTO [dbo].[NhanVien] ([HoTen], [SoDienThoai], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Phan Thị Huỳnh Thư', '0333411964', 'phanthihthu@gmail.com', '226505948824', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 1993, 35000, N'Quản lí',1)
INSERT INTO [dbo].[NhanVien] ([HoTen], [SoDienThoai], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Trần Thị Huyền Trân', '0907293510', 'tranthihuyentran@gmail.com', '222828115276', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 1999, 30000, N'Quản lí', 1)
INSERT INTO [dbo].[NhanVien] ([HoTen], [SoDienThoai], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Nguyễn Minh Hải', '0389660754', 'nguyenhai2009@gmail.com', '217958221685', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 1989, 28000, N'Tiếp tân',1)
INSERT INTO [dbo].[NhanVien] ([HoTen], [SoDienThoai], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Nguyễn Tiến Dũng', '0782566343', 'nguyentdung1110@gmail.com', '211019927954', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 2000, 28000, N'Tiếp tân',1)
INSERT INTO [dbo].[NhanVien] ([HoTen], [SoDienThoai], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Phan Thanh Nam', '0936279762', 'thanhnam1210@gmail.com', '219422793198', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 2000, 28000, N'Tiếp tân', 0)
INSERT INTO [dbo].[NhanVien] ([HoTen], [SoDienThoai], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Nguyễn Vân', '0984164251', 'nguyenvan@gmail.com', '227794341138', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 1999, 28000, N'Tiếp tân', 1)
INSERT INTO [dbo].[NhanVien] ([HoTen], [SoDienThoai], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Bùi Tuấn Phú', '0982464251', 'fubui03@gmail.com', '229894341138', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 1999, 28000, N'Tiếp tân', 1)
INSERT INTO [dbo].[NhanVien] ([HoTen], [SoDienThoai], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Nguyễn Thị Nên Hoài', '0982876251', 'nenhoai@gmail.com', '229894344538', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 2000, 29000, N'Tiếp tân', 1)
INSERT INTO [dbo].[NhanVien] ([HoTen], [SoDienThoai], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Trần Thị Lệ Giang', '0970876251', 'legiang0301@gmail.com', '229894994538', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 2001, 30000, N'Tiếp tân', 1)
INSERT INTO [dbo].[NhanVien] ([HoTen], [SoDienThoai], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Văn Công Thành Đạt', '0367306158', 'vancongthanhdata10@gmail.com', '229004994538', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 2003, 27000, N'Tiếp tân', 1)
INSERT INTO [dbo].[NhanVien] ([HoTen], [SoDienThoai], [Email], [CCCD], [Password], [NamSinh], [MucLuong], [ChucVu], [TrangThai]) VALUES (N'Nguyễn Tấn Thái Dương', '0356309561', 'duongnguyen1323@gmail.com', '229004994538', 'ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f', 1998, 31000, N'Tiếp tân', 1)
GO

select * from NhanVien
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Tống Anh Quân', '0388973214', 'nguyenanhquan@gmail.com', 1999)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Trần Đức Vũ', '0385732141', 'tranducvu@gmail.com', 1979)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Thành Nghiêm', '0384532564', 'thanhnghiem@gmail.com', 2000)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Vòng Vĩnh Lợi', '0384589653', 'vvloi@gmail.com', 1985)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Tiến Hoàng', '0384892314', 'nthoang@gmail.com', 1994)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Lê Bá Hậu', '0384598371', 'lebahau@gmail.com', 1992)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Thanh Hiền', '0381242314', 'thanhhien@gmail.com', 2000)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Lê Hữu Duy', '0373127573', 'lehuuduy@gmail.com', 1991)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Thanh Tuyền', '0309650214', 'nguyenthanhtien@gmail.com', 1995)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Trần Huỳnh Bắc', '0984643251', 'huynhbac05@gmail.com', 2005)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Phan Huỳnh Tuấn', '0976643251', 'phtuan01@gmail.com', 2001)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Trương Trần Quốc Quân', '0970973251', 'ttquocquan@gmail.com', 2003)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Lê Minh Đại', '0982535251', 'leminhdai003@gmail.com', 2003)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Đặng Trần Đan Vũ', '0809633251', 'vuxinhdep@gmail.com', 2000)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Thị Thanh Ngân', '0954363251', 'thanhngan99@gmail.com', 1999)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Lê Thị Phương Xa', '0908782212', 'lethiphuongxa@gmail.com', 1993)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Ngọc Hạ', '0809638764', 'nguyenngocha0402@gmail.com', 2002)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Triệu Gia Bảo', '0996538754', 'trieugiabao0903@gmail.com', 2003)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Hàng Tuyết My', '0977238753', 'mymy0899@gmail.com', 1999)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Đinh Trần Anh Quân', '0977238876', 'daicaquan02@gmail.com', 2002)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Đình Đan Phi', '0883389234', 'nguyendinhdanfi@gmail.com', 1990)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Thị Trúc Uyên', '0988238594', 'uyenuyencongchua@gmail.com', 1989)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Phùng Thị Kim Trúc', '0992138284', 'ptktruc97@gmail.com', 1997)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Phan Như Uyên', '0903058232', 'phannhuuyen95@gmail.com', 1995)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Nhật Khánh', '0965338221', 'nguyennhatkhanh@gmail.com', 1998)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Bá Nha', '0969938253', 'banha010394@gmail.com', 1993)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Trần Thanh Sang', '0847898234', 'tranthanhsang93@gmail.com', 1993)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Lê Văn Rôn', '0882498254', 'levanron02@gmail.com', 1992)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Nguyễn Lưu Anh Thư', '0987898874', 'nguyenluuanhthu@gmail.com', 2001)
INSERT INTO [dbo].[KhachHang] ([HoTen], [SoDienThoai], [Email], [NamSinh]) VALUES (N'Phan Huy Phong', '0993898874', 'huyphong@gmail.com', 2001)
GO

INSERT INTO [dbo].[LoaiPhong] (TenLoai) VALUES (N'Thường')
INSERT INTO [dbo].[LoaiPhong] (TenLoai) VALUES (N'VIP')
GO

INSERT INTO [dbo].[Phong] ([SoPhong], [MaLoaiPhong], [TrangThai], [SucChua]) VALUES (101, 'LP001', N'Trống', 10)
INSERT INTO [dbo].[Phong] ([SoPhong], [MaLoaiPhong], [TrangThai], [SucChua]) VALUES (102, 'LP001', N'Trống', 20)
INSERT INTO [dbo].[Phong] ([SoPhong], [MaLoaiPhong], [TrangThai], [SucChua]) VALUES (103, 'LP001', N'Trống', 10)
INSERT INTO [dbo].[Phong] ([SoPhong], [MaLoaiPhong], [TrangThai], [SucChua]) VALUES (104, 'LP001', N'Trống', 10)
INSERT INTO [dbo].[Phong] ([SoPhong], [MaLoaiPhong], [TrangThai], [SucChua]) VALUES (105, 'LP001', N'Trống', 20)
INSERT INTO [dbo].[Phong] ([SoPhong], [MaLoaiPhong], [TrangThai], [SucChua]) VALUES (201, 'LP002', N'Trống', 10)
INSERT INTO [dbo].[Phong] ([SoPhong], [MaLoaiPhong], [TrangThai], [SucChua]) VALUES (202, 'LP002', N'Trống', 10)
INSERT INTO [dbo].[Phong] ([SoPhong], [MaLoaiPhong], [TrangThai], [SucChua]) VALUES (203, 'LP002', N'Trống', 20)
INSERT INTO [dbo].[Phong] ([SoPhong], [MaLoaiPhong], [TrangThai], [SucChua]) VALUES (204, 'LP002', N'Trống', 10)
INSERT INTO [dbo].[Phong] ([SoPhong], [MaLoaiPhong], [TrangThai], [SucChua]) VALUES (205, 'LP002', N'Trống', 20)
INSERT INTO [dbo].[Phong] ([SoPhong], [MaLoaiPhong], [TrangThai], [SucChua]) VALUES (206, 'LP002', N'Trống', 20)
INSERT INTO [dbo].[Phong] ([SoPhong], [MaLoaiPhong], [TrangThai], [SucChua]) VALUES (207, 'LP002', N'Trống', 20)
GO

INSERT INTO [dbo].[LoaiDichVu] ([TenLoaiDichVu]) VALUES (N'Nước uống')
INSERT INTO [dbo].[LoaiDichVu] ([TenLoaiDichVu]) VALUES (N'Món chính')
INSERT INTO [dbo].[LoaiDichVu] ([TenLoaiDichVu]) VALUES (N'Tráng miệng')
INSERT INTO [dbo].[LoaiDichVu] ([TenLoaiDichVu]) VALUES (N'Khai vị')
GO

INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Nước ép trái cây', 'LDV001', 35000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Nước khoáng', 'LDV001', 20000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Coca-Cola', 'LDV001', 25000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Pepsi', 'LDV001', 25000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Sữa tươi', 'LDV001', 30000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Bia Tiger', 'LDV001', 50000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Bia Heineken', 'LDV001', 25000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Rượu vang đỏ', 'LDV001', 25000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Rượu vang trắng', 'LDV001', 100000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Cocktail Mojito', 'LDV001', 70000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Cocktail Margarita', 'LDV001', 70000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Trà đá', 'LDV001', 20000)

INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Bánh kem', 'LDV003', 100000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Chè thập cẩm', 'LDV003', 40000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Trái cây theo mùa', 'LDV003', 80000)

INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Mực chiên giòn', 'LDV002', 100000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Cơm chiên hải sản', 'LDV002', 120000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Lẩu thái', 'LDV002', 250000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Gà nước BBQ', 'LDV002', 150000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Cá hồi áp chảo', 'LDV002', 180000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Bò xào lá lốt', 'LDV002', 180000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Tôm sốt me', 'LDV002', 160000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Tôm rim mặn ngọt', 'LDV002', 120000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Gà rang muối', 'LDV002', 150000)

INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Bánh tráng nướng', 'LDV004', 50000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Gỏi cuốn', 'LDV004', 50000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Nem rán', 'LDV004', 55000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Chả giò', 'LDV004', 55000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Khoai tây chiên', 'LDV004', 45000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Salad rau củ', 'LDV004', 40000)
INSERT INTO [dbo].[DichVu] ([TenDichVu], [MaLoaiDichVu], [Gia]) VALUES (N'Soup cua', 'LDV004', 60000)
GO

select * from Phong
select * from PhieuDatPhong
select * from ChiTietDatPhong
select * from ChiTietPhieuDatPhong