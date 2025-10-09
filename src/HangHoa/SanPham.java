package HangHoa;

import DanhSach.DanhSachSanPham;

public class SanPham extends PhanTu {
    private String maSanPham;
    private String tenSanPham;
    private String thuonghieu;
    private String noiSanXuat;
    private int soLuong;
    private int gia;
    
    public SanPham(){
        
    }

    public SanPham(String maSanPham, String tenSanPham, String thuonghieu, String noiSanXuat, int soLuong, int gia) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.thuonghieu = thuonghieu;
        this.noiSanXuat = noiSanXuat;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham() {
        System.out.print("Nhap ma san pham: ");
        DanhSachSanPham ttds = new DanhSachSanPham();
        boolean check = false;
        do
        {
            maSanPham = sc.nextLine();
            check = ttds.layPhanTuVoi(maSanPham) == null; // kiểm tra mã sản phẩm xem đã tồn tại trong danh sách chưa
            if (!check) System.out.print("Ma san pham da ton tai, moi nhap lai: ");
        } while (!check);
    }
    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham() {
        System.out.print("Nhap ten san pham: ");
        tenSanPham = sc.nextLine();
    }
    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getThuonghieu() {
        return thuonghieu;
    }

    public void setThuonghieu() {
        System.out.print("Nhap thuong hieu: ");
        thuonghieu = sc.nextLine();
    }
    public void setThuonghieu(String thuonghieu) {
        this.thuonghieu = thuonghieu;
    }

    public String getNoiSanXuat() {
        return noiSanXuat;
    }

    public void setNoiSanXuat() {
        System.out.print("Nhap noi san xuat: ");
        noiSanXuat = sc.nextLine();
    }
    public void setNoiSanXuat(String noiSanXuat) {
        this.noiSanXuat = noiSanXuat;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong() {
        System.out.print("Nhap so luong: ");
        boolean check;
        do {
            check = true;
            try {
                soLuong = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                check = false;
                System.out.print("Vui long nhap mot so: ");
            }
        } while (!check);
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getGia() {
        return gia;
    }

    public void setGia() {
        boolean check;
        System.out.print("Vui long nhap gia: ");
        do {
            check = true;
            try {
                gia = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                check = false;
                System.out.print("Vui long nhap mot so: ");
            }
        } while (!check);
    }
    public void setGia(String gia) {
        this.gia = Integer.parseInt(gia);
    }

    
    @Override
    public void nhap(){
        setMaSanPham();
        setTenSanPham();
        setThuonghieu();
        setNoiSanXuat();
        setSoLuong();
        setGia();
    }

    @Override
    public void xuat() {
        System.out.printf("%-20s %-50s %-20s %-20s %-20s %-20s \n",maSanPham,tenSanPham,thuonghieu,noiSanXuat,soLuong,gia);
    }    

    @Override
    public void suaThongTin() {
        System.out.println("=== Sua thong tin san pham ===");
        System.out.println("1. Sua ma san pham");
        System.out.println("2. Sua ten san pham");
        System.out.println("3. Sua thuong hieu");
        System.out.println("4. Sua noi san xuat");
        System.out.println("5. Sua so luong");
        System.out.println("6. Sua gia");
        System.out.println("0. Quay ve menu quan ly san pham");
        System.out.println("===============================");
        int chon;
        do {
            System.out.print("Nhap lua chon: ");
            chon = Integer.parseInt(sc.nextLine());
            switch (chon) {
                case 0:
                    break;
                case 1:
                    System.out.println("Thong tin hien tai: "+getMaSanPham());
                    setMaSanPham();
                    break;
                case 2:
                    System.out.println("Thong tin hien tai: "+getTenSanPham());
                    setTenSanPham();
                    break;
                case 3:
                    System.out.println("Thong tin hien tai: "+getThuonghieu());
                    setThuonghieu();
                    break;
                case 4:
                    System.out.println("Thong tin hien tai: "+getNoiSanXuat());
                    setNoiSanXuat();
                    break;
                case 5:
                    System.out.println("Thong tin hien tai: "+getSoLuong());
                    setSoLuong();
                    break;
                case 6:
                    System.out.println("Thong tin hien tai: "+getGia());
                    setGia();
                    break;
                default:
                    System.out.println("Hay chon lai!");
                    break;
            }
        } while(chon!=0);
    }
}