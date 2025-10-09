import DanhSach.*;
import HangHoa.PhanTu;
import java.util.Scanner;

public class XuLy {
    private static Scanner sc = new Scanner(System.in);
    // Phương thức tạo menu hướng dẫn chính
    public static void xuLyTrungTam(){
        // DanhSachHoaDon dshd = new DanhSachHoaDon();
        // DanhSachKhachHang dskh = new DanhSachKhachHang();
        // DanhSachNhanVien dsnv = new DanhSachNhanVien();
        DanhSachDanhMucSP dsdmsp = new DanhSachDanhMucSP();
        
        int chon;
        System.out.println("***** Chuong Trinh Quan Ly Sieu Thi Mini *****");
        do {
            System.out.println("==============================");
            System.out.println("1. Tao hoa don moi");
            System.out.println("2. Them khach hang moi");
            System.out.println("3. Them nhan vien moi");
            System.out.println("4. In danh sach danh muc cung san pham");
            System.out.println("5. Di toi menu quan ly");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("==============================");
            System.out.print("Moi chon: ");
            
            chon = Integer.parseInt(sc.nextLine());
            
            switch (chon) {
                case 1:
                    // dshd.themKPhanTuVaoDanhSach();
                    break;
                case 2:
                    // dskh.themKPhanTuVaoDanhSach();
                    break;
                case 3:
                    // dsnv.themKPhanTuVaoDanhSach();
                    break;
                case 4:
                    dsdmsp.xuatDanhSach();
                    break;
                case 5:
                    quanLy();
                    break;
                default:
                    chon = 0;
                    System.out.println("Cam on ban da su dung chuong trinh");
                    break;
            }
            if (chon == 5) break;
        } while (chon!=0);
    }
    // Phương thức tạo menu quản lý
    public static void quanLy() {
        System.out.println("***** Chuong Trinh Sieu Thi Mini *****");
        System.out.println("==============================");
        System.out.println("1. Quan ly danh sach san pham");
        System.out.println("2. Quan ly danh sach nhan vien");
        System.out.println("3. Quan ly danh sach khach hang");
        System.out.println("4. Quan ly danh sach hoa don");
        System.out.println("5. Quan ly danh sach danh muc san pham");
        System.out.println("0. Quay lai menu trung tam");
        System.out.println("==============================");
        System.out.print("Moi chon: ");
        int chon;
        chon = Integer.parseInt(sc.nextLine());
        switch (chon) {
            case 1:
                quanLyDSSP();
                break;
            case 2:
                // quanLyDSNV();
                break;
            case 3:
                // quanLyDSKH();
                break;
            case 4:
                // quanLyDSHD();
                break;
            case 5:
                quanLyDSDanhMucSP();
                break;
            default:
                xuLyTrungTam();
                break;
        }
    }
    // Phương thức in menu dùng chung cho 5 đối tượng (nhân viên, khách hàng, sản phẩm, danh mục sản phẩm, hoá đơn
    private static void inMenu(String ten) {
        System.out.println("==============================");
        System.out.println("*** QUAN LY DANH SACH "+ten.toUpperCase()+" ***");
        System.out.println("1. Nhap moi danh sach");
        System.out.println("2. Xuat danh sach");
        System.out.println("3. Them "+ten+" vao danh sach");
        System.out.println("4. Chinh sua thong tin "+ten);
        System.out.println("5. Xoa "+ten);
        System.out.println("6. Tim "+ten);
        System.out.println("7. Thong ke");
        System.out.println("8. Tong so luong "+ten);
        System.out.println("0. Quay lai menu quan ly");
        System.out.println("==============================");
        System.out.print("Moi chon: ");
    }
    // Menu quản lý danh sách sản phẩm
    public static void quanLyDSSP() {
        DanhSachSanPham ttds = new DanhSachSanPham();
        inMenu("san pham");
        int chon;
        do {
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 1:
                    ttds.nhapDanhSach();
                    break;
                case 2:
                    ttds.xuatDanhSach();
                    break;
                case 3:
                    ttds.themKPhanTuVaoDanhSach();
                    break;
                case 4:
                    ttds.chinhSuaThongTinPhanTu();
                    break;
                case 5:
                    ttds.xoaPhanTu();
                    break;
                case 6:
                    PhanTu pt = ttds.timPhanTu();
                    if (pt != null) {
                        System.out.println("** Thong tin tim thay **");
                        pt.xuat();
                    } else System.out.println("Khong tim thay!");
                    break;
                case 7:
                    ttds.thongKe();
                    break;
                default:
                    if (chon==0) quanLy();
                    chon = 0;
                    break;
            }
            if (chon!=0)inMenu("san pham");
        } while(chon!=0);
    }
    // Menu quản lý danh sách nhân viên
    // public static void quanLyDSNV() {
    //     DanhSachNhanVien ttds = new DanhSachNhanVien();
    //     inMenu("nhan vien");
    //     int chon;
    //     do {
    //         chon = Integer.parseInt(sc.nextLine());
    //         switch (chon) {
    //             case 1:
    //                 ttds.nhapDanhSach();
    //                 break;
    //             case 2:
    //                 ttds.xuatDanhSach();
    //                 break;
    //             case 3:
    //                 ttds.themKPhanTuVaoDanhSach();
    //                 break;
    //             case 4:
    //                 ttds.chinhSuaThongTinPhanTu();
    //                 break;
    //             case 5:
    //                 ttds.xoaPhanTu();
    //                 break;
    //             case 6:
    //                 PhanTu pt = ttds.timPhanTu();
    //                 if (pt != null) {
    //                     System.out.println("** Thong tin tim thay **");
    //                     pt.xuat();
    //                 } else System.out.println("Khong tim thay!");
    //                 break;
    //             case 7:
    //                 ttds.thongKe();
    //                 break;
    //             default:
    //                 if (chon==0) quanLy();
    //                 chon = 0;
    //                 break;
    //         }
    //         if (chon!=0)inMenu("nhan vien");
    //     } while(chon!=0);
    // }
    // Menu quản lý danh sách khách hàng
    // public static void quanLyDSKH() {
    //     DanhSachKhachHang ttds = new DanhSachKhachHang();
    //     inMenu("khach hang");
    //     int chon;
    //     do {
    //         chon = Integer.parseInt(sc.nextLine());
    //         switch (chon) {
    //             case 1:
    //                 ttds.nhapDanhSach();
    //                 break;
    //             case 2:
    //                 ttds.xuatDanhSach();
    //                 break;
    //             case 3:
    //                 ttds.themKPhanTuVaoDanhSach();
    //                 break;
    //             case 4:
    //                 ttds.chinhSuaThongTinPhanTu();
    //                 break;
    //             case 5:
    //                 ttds.xoaPhanTu();
    //                 break;
    //             case 6:
    //                 PhanTu pt = ttds.timPhanTu();
    //                 if (pt != null) {
    //                     System.out.println("** Thong tin tim thay **");
    //                     pt.xuat();
    //                 } else System.out.println("Khong tim thay!");
    //                 break;
    //             case 7:
    //                 ttds.thongKe();
    //                 break;
    //             default:
    //                 if (chon==0) quanLy();
    //                 chon = 0;
    //                 break;
    //         }
    //         if (chon!=0)inMenu("khach hang");
    //     } while(chon!=0);
    // }
    // Menu quản lý danh sách hoá đơn
    // public static void quanLyDSHD() {
    //     DanhSachHoaDon ttds = new DanhSachHoaDon();
    //     DanhSachSanPham dssp = new DanhSachSanPham();
    //     inMenu("hoa don");
    //     int chon;
    //     do {
    //         chon = Integer.parseInt(sc.nextLine());
    //         // chỉ cho phép thao tác nếu đã có danh sách sản phẩm
    //         if (dssp.getsoLuong() == 0) {
    //             System.out.println("Vui long nhap danh sach san pham truoc khi quan ly hoa don!");
    //             chon = 0;
    //         }
    //         switch (chon) {
    //             case 1:
    //                 ttds.nhapDanhSach();
    //                 break;
    //             case 2:
    //                 ttds.xuatDanhSach();
    //                 break;
    //             case 3:
    //                 ttds.themKPhanTuVaoDanhSach();
    //                 break;
    //             case 4:
    //                 ttds.chinhSuaThongTinPhanTu();
    //                 break;
    //             case 5:
    //                 ttds.xoaPhanTu();
    //                 break;
    //             case 6:
    //                 PhanTu pt = ttds.timPhanTu();
    //                 if (pt != null) {
    //                     System.out.println("** Thong tin tim thay **");
    //                     pt.xuat();
    //                 } else System.out.println("Khong tim thay!");
    //                 break;
    //             case 7:
    //                 ttds.thongKe();
    //                 break;
    //             default:
    //                 chon = 0;
    //                 if (chon==0) quanLy();
    //                 break;
    //         }
    //         if (chon!=0)inMenu("hoa don");
    //     } while(chon!=0);
    // }
    // Menu quản lý danh sách danh mục sản phẩm
    public static void quanLyDSDanhMucSP() {
        DanhSachDanhMucSP ttds = new DanhSachDanhMucSP();
        DanhSachSanPham dssp = new DanhSachSanPham();
        inMenu("danh muc san pham");
        int chon;
        do {
            chon = Integer.parseInt(sc.nextLine());
            if (dssp.getsoLuong() == 0) {
                System.out.println("Vui long nhap danh sach san pham truoc khi quan ly danh muc!");
                chon = 0;
            }
            switch (chon) {
                case 1:
                    ttds.nhapDanhSach();
                    break;
                case 2:
                    ttds.xuatDanhSach();
                    break;
                case 3:
                    ttds.themKPhanTuVaoDanhSach();
                    break;
                case 4:
                    ttds.chinhSuaThongTinPhanTu();
                    break;
                case 5:
                    ttds.xoaPhanTu();
                    break;
                case 6:
                    PhanTu pt = ttds.timPhanTu();
                    if (pt != null) {
                        System.out.println("** Thong tin tim thay **");
                        pt.xuat();
                    } else System.out.println("Khong tim thay!");
                    break;
                case 7:
                    ttds.thongKe();    
                    break;
                default:
                    if (chon==0) quanLy();
                    chon = 0;
                    break;
            }
            if (chon!=0)inMenu("danh muc san pham");
        } while(chon!=0);
    }
}