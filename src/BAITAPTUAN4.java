import java.time.Year;
import java.util.Scanner;

public class BAITAPTUAN4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int namHienTai = Year.now().getValue();

        // ===== Nhập thông tin (giữ nguyên từ tuần 3) =====
        System.out.println("===== NHẬP THÔNG TIN SÁCH =====");
        System.out.print("Nhập mã sách: ");
        String maSach = sc.nextLine();
        System.out.print("Nhập tên sách: ");
        String tenSach = sc.nextLine();
        System.out.print("Nhập tác giả: ");
        String tacGia = sc.nextLine();
        System.out.print("Nhập năm xuất bản: ");
        int namXuatBan = sc.nextInt();
        System.out.print("Nhập đơn giá (VNĐ): ");
        double donGia = sc.nextDouble();
        System.out.print("Nhập số lượng: ");
        int soLuong = sc.nextInt();

        // ===== BÀI 1: Kiểm tra tính hợp lệ =====
        boolean hopLe = true;
        if (donGia <= 0) {
            System.out.println("Lỗi: Đơn giá phải > 0");
            hopLe = false;
        }
        if (soLuong < 0) {
            System.out.println("Lỗi: Số lượng phải >= 0");
            hopLe = false;
        }
        if (namXuatBan < 1900 || namXuatBan > namHienTai) {
            System.out.println("Lỗi: Năm xuất bản phải từ 1900 đến " + namHienTai);
            hopLe = false;
        }
        if (!hopLe) {
            System.out.println("=> Sách KHÔNG hợp lệ, dừng chương trình.");
            sc.close();
            return;
        }
        System.out.println("\n=> Sách hợp lệ.");

        // Sách mới hay cũ (xuất bản trong vòng 2 năm là sách mới)
        if (namHienTai - namXuatBan <= 2) {
            System.out.println("Tình trạng: Sách mới");
        } else {
            System.out.println("Tình trạng: Sách cũ");
        }

        // ===== BÀI 2: Phân loại giá =====
        String loaiGia;
        if (donGia < 50000) {
            loaiGia = "Sách giá thấp";
        } else if (donGia <= 100000) {
            loaiGia = "Sách giá trung bình";
        } else if (donGia <= 200000) {
            loaiGia = "Sách giá cao";
        } else {
            loaiGia = "Sách giá đặc biệt";
        }

        // ===== BÀI 3: Phân loại tồn kho =====
        String tonKho;
        if (soLuong == 0) {
            tonKho = "Hết sách";
        } else if (soLuong <= 5) {
            tonKho = "Sắp hết";
        } else if (soLuong <= 20) {
            tonKho = "Còn ít";
        } else {
            tonKho = "Còn nhiều";
        }

        // ===== BÀI 4: Chọn loại sách bằng switch =====
        System.out.println("\n===== CHỌN LOẠI SÁCH =====");
        System.out.println("1. Sách giáo khoa");
        System.out.println("2. Sách tham khảo");
        System.out.println("3. Sách chuyên ngành");
        System.out.println("4. Sách khác");
        System.out.print("Nhập lựa chọn (1-4): ");
        int chon = sc.nextInt();

        String loaiSach;
        switch (chon) {
            case 1:
                loaiSach = "Sách giáo khoa";
                break;
            case 2:
                loaiSach = "Sách tham khảo";
                break;
            case 3:
                loaiSach = "Sách chuyên ngành";
                break;
            case 4:
                loaiSach = "Sách khác";
                break;
            default:
                loaiSach = "Không xác định (lựa chọn không hợp lệ)";
        }

        // ===== Tính tiền như tuần 3 =====
        double thanhTien = donGia * soLuong;
        double phiVanChuyen = thanhTien * 0.05;
        double tongTienNhap = thanhTien + phiVanChuyen;

        // ===== Xuất kết quả =====
        System.out.println("\n===== THÔNG TIN SÁCH =====");
        System.out.println("Mã sách       : " + maSach);
        System.out.println("Tên sách      : " + tenSach);
        System.out.println("Tác giả       : " + tacGia);
        System.out.println("Năm xuất bản  : " + namXuatBan);
        System.out.printf("Đơn giá       : %,.0f VNĐ%n", donGia);
        System.out.println("Số lượng      : " + soLuong);
        System.out.println("Phân loại giá : " + loaiGia);
        System.out.println("Tồn kho       : " + tonKho);
        System.out.println("Loại sách     : " + loaiSach);
        System.out.printf("Tổng tiền nhập: %,.0f VNĐ%n", tongTienNhap);

        sc.close();
    }
}