package File;

import ThanhToan.ThanhToan;
import java.io.File;  
import java.io.IOException;  
import java.io.FileWriter;
import java.util.Scanner;

import HangHoa.SanPham;

public class FileHandler {
    private static Scanner fr;
    // reset file theo tên
    public static void resetFile(String tenFile) {
        try {
            FileWriter fw = new FileWriter(tenFile);
            fw.write("");
            fw.close();
        } catch (Exception e) {
            System.out.println("Khong the reset file!");
        }
    }
    
    // thêm sản phẩm vào file dssp.txt
    public static void themSP(String masp, String tensp, String thuongHieu, String noiSx, int sl, int gia) {
        String tmp = masp+"#"+tensp+"#"+thuongHieu+"#"+noiSx+"#"+sl+"#"+gia;
        ghiFile(tmp, "dssp.txt");
    }
    // thêm nhân viên vào file dsnv.txt
    public static void themNv(int manv, String hoten, String cmt, String diachi, String sdt,
        String ngayVaoLam, double heSoLuong, int soNgayNghiTrongThang) {
        String tmp = manv+"#"+hoten+"#"+cmt+"#"+diachi+"#"+sdt+"#"+ngayVaoLam+"#"+heSoLuong+"#"+soNgayNghiTrongThang;
        ghiFile(tmp, "dsnv.txt");
    }
    // thêm khách hàng vào file dskh.txt
    public static void themKh(int makh, String hoten, String cmt, String diachi, String sdt,
        int soDonHangDaThanhToan, int tongTienDaThanhToan, ThanhToan phThThanhToan) {
        String tmp = makh+"#"+hoten+"#"+cmt+"#"+diachi+"#"+sdt+"#"+soDonHangDaThanhToan+"#"+tongTienDaThanhToan+"#";
        if (phThThanhToan != null) {
            tmp+=phThThanhToan.getPhuongThucThanhToan()+"#";
            // -># # # # # # # #
            // ghi phương thức ngân hàng
            if (phThThanhToan.getPTNganHang() != null) {
                tmp+=phThThanhToan.getPTNganHang().getSoTheTk()+"#"+phThThanhToan.getPTNganHang().getCVV()+"#";
            } else for(int i=0;i<2;i++) tmp+=" #";
            
            // ghi phương thức tín dụng
            if (phThThanhToan.getPTTinDung()!= null) {
                tmp+=phThThanhToan.getPTTinDung().getSoThe()+"#"
                +phThThanhToan.getPTTinDung().getLoaiThe()+"#"
                +phThThanhToan.getPTTinDung().getCVV()+"#";
            } else for(int i=0;i<3;i++) tmp+=" #";
            
            // ghi phương thức ví điện tử
            if (phThThanhToan.getPTViDienTu()!= null) {
                tmp+=phThThanhToan.getPTViDienTu().getSoDienThoaiLienKet()+"#"+phThThanhToan.getPTViDienTu().getTenVi();
            } else {
                tmp+=" # ";
            }
        } else {
            tmp+="TienMat#";
            for(int i=0;i<7;i++)
                if (i!=6) tmp+=" #";
                else tmp+=" ";
        }
        ghiFile(tmp, "dskh.txt");
    }
    // thêm danh mục sản phẩm vào file dsdmsp.txt
    public static void themDmSP(String maDanhMuc, String tenDanhMuc, int soLuong, String[] dsMaSanPham) {
        String tmp = maDanhMuc+"#"+tenDanhMuc+"#"+soLuong+"#";
        
        for(int i=0;i<dsMaSanPham.length;i++)
            if (i!=dsMaSanPham.length-1)
                tmp += dsMaSanPham[i]+"#";
            else tmp += dsMaSanPham[i];
        ghiFile(tmp, "dsdmsp.txt");
    }
    // thêm hoá đơn vào file dshd.txt
    public static void themHd(int soHoaDon, int soLuongSanPham, int tongTien, int maKhachHang, 
        int maThuNgan, String phThThanhToan, SanPham[] dssp) {
        String tmp = soHoaDon+"#"+soLuongSanPham+"#"+tongTien+"#"+maKhachHang+"#"+maThuNgan+"#"+phThThanhToan+"#";
        
        for(int i=0;i<dssp.length;i++)
        {
            tmp+=dssp[i].getMaSanPham()+"#"+dssp[i].getSoLuong();
        }
        ghiFile(tmp, "dshd.txt");
    }
    
    // hàm khởi tạo các file
    public static void taoCacFile() {
        File[] f = new File[5];
        try {
            f[0] = new File("dssp.txt");
            f[1] = new File("dsnv.txt");
            f[2] = new File("dskh.txt");
            f[3] = new File("dshd.txt");
            f[4] = new File("dsdmsp.txt");
            String tenFile = "";
            for(int i=0;i<f.length;i++) {
                if (f[i].createNewFile()) { // nếu file chưa tồn tại
                    switch (i) { // khởi tạo giá trị mẫu
                        case 0:
                            tenFile = "dssp.txt";
                            ghiFile("20", tenFile);
                            // nước ngọt - 4
                            themSP("NN01", "Nuoc ngot co ga Pepsi", "Pepsi", "Viet Nam", 1427, 10000);
                            themSP("NN02", "Nuoc ngot co ga Coca-Cola", "Coca-Cola", "Viet Nam", 623, 12000);
                            themSP("NN03", "Nuoc tang luc Red-bull", "Red-bull", "Viet Nam", 152, 18000);
                            themSP("NN04", "Nuoc tang luc Number1", "Number1", "Viet Nam", 254, 15000);
                            // bánh kẹo
                            themSP("BK01", "Banh bong lan cuon kem", "Solite", "Viet Nam", 872, 5500);
                            themSP("BK02", "Banh chocopie", "Orion", "Viet Nam", 314, 8000);
                            themSP("BK03", "Keo chupa chups", "Chupa Chups", "Viet Nam", 541, 3200);
                            themSP("BK04", "Keo deo", "Haribo", "Viet Nam", 170, 1900);
                            // tập
                            themSP("TAP01", "Tap tot loai A", "A", "Viet Nam", 142, 5800);
                            themSP("TAP02", "Tap tot loai B", "B", "Viet Nam", 314, 6200);
                            themSP("TAP03", "Tap thuong loai A", "C", "Viet Nam", 541, 3000);
                            themSP("TAP04", "Tap thuong loai A", "D", "Viet Nam", 170, 3500);
                            // sách
                            themSP("SACH01", "Sach giao khoa Toan hoc lop 10 tap 1", "NXBGDVN", "Viet Nam", 142, 5200);
                            themSP("SACH02", "Sach giao khoa Toan hoc lop 10 tap 2", "NXBGDVN", "Viet Nam", 141, 5100);
                            themSP("SACH03", "Sach giao khoa Tin hoc lop 10 tap 1", "NXBGDVN", "Viet Nam", 316, 3200);
                            themSP("SACH04", "Sach giao khoa Tin hoc lop 10 tap 2", "NXBGDVN", "Viet Nam", 314, 4800);
                            // Hóa mỹ phẩm
                            themSP("HMP01", "Dau goi duoc lieu", "Nguyen Xuan", "Viet Nam", 142, 85000);
                            themSP("HMP02", "Dau goi sach gau", "Clear", "Viet Nam", 141, 60000);
                            themSP("HMP03", "Sua rua mat", "Cetafill", "Viet Nam", 316, 96000);
                            themSP("HMP04", "Sua tam huong nuoc hoa", "Bath & Body Works", "Viet Nam", 314, 80000);
                            break;
                        case 1:
                            tenFile = "dsnv.txt";
                            ghiFile("4", tenFile);
                            themNv(1, "Nguyen Van A", "320763982", "273 An Duong Vuong, P3, Q5, TP.HCM",
                                    "0924832941", "19/1/2021", 0.5, 0);
                            themNv(2, "Nguyen Hoang B", "320763982", "273 An Duong Vuong, P3, Q5, TP.HCM",
                                    "0924832941", "17/6/2012", 1.2, 0);
                            themNv(3, "Doan Thi C", "320763982", "273 An Duong Vuong, P3, Q5, TP.HCM",
                                    "0924832941", "16/1/2021", 0.4, 1);
                            themNv(4, "Tran Van D", "320763982", "273 An Duong Vuong, P3, Q5, TP.HCM",
                                    "0924832941", "1/6/2015", 0.9, 3);
                            break;
                        case 2:
                            tenFile = "dskh.txt";
                            ghiFile("3", tenFile);
                            themKh(1, "Doan Van A", "320873941", "273 An Duong Vuong, P3, Q5, TP.HCM", "0894172635", 0, 0, null);
                            themKh(2, "Nguyen Van B", "320142913", "273 An Duong Vuong, P3, Q5, TP.HCM", "0913716241", 0, 0, null);
                            themKh(3, "Tran Van C", "320638711", "273 An Duong Vuong, P3, Q5, TP.HCM", "0907412663", 0, 0, null);
                            break;
                        case 3:
                            break;
                        case 4:
                            tenFile = "dsdmsp.txt";
                            ghiFile("5", tenFile);
                            // 1
                            String[] dsMaSp = new String[]{"NN01","NN02","NN03","NN04"};
                            themDmSP("NUOCNGOT", "Nuoc ngot", 4, dsMaSp);
                            // 2
                            dsMaSp = new String[]{"BK01","BK02","BK03","BK04"};
                            themDmSP("BANHKEO", "Banh keo", 4, dsMaSp);
                            // 3
                            dsMaSp = new String[]{"TAP01","TAP02","TAP03","TAP04"};
                            themDmSP("TAP", "Tap", 4, dsMaSp);
                            // 4
                            dsMaSp = new String[]{"SACH01","SACH02","SACH03","SACH04"};
                            themDmSP("SGK", "Sach giao khoa", 4, dsMaSp);
                            // 5
                            dsMaSp = new String[]{"HMP01","HMP02","HMP03","HMP04"};
                            themDmSP("HOAMYPHAM", "Hoa my pham", 4, dsMaSp);
                            break;
                        default:
                            break;
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Khong the tao file!");
        }
    }
    // ghi nội dung vào file
    public static void ghiFile(String giaTri, String tenFile) {
        try {
            File fo = new File(tenFile);
            fr = new Scanner(fo, "utf-8");
            
            String data = "";
            
            while(fr.hasNextLine())
                data += fr.nextLine() + "\n";

            FileWriter fw = new FileWriter(tenFile);
            
            fw.write(data+giaTri);
            fw.close();
        } catch (Exception e) {
            System.out.println("Khong the ghi file!");
        }
    }
    
    public static String docFile(String tenFile) {
        try {
            File fo = new File(tenFile);
            fr = new Scanner(fo, "utf-8");
            
            String data = "";
            
            while(fr.hasNextLine())
                data += fr.nextLine() + "\n";
            
            return data;
        } catch (Exception e) {
            System.out.println("Khong the doc file!");
            return null;
        }
    }
}