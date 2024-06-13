import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static String tnbk;
    private static int bulanBayar, Pajak, Denda, penguranganBulan, totPendapatan, totPen;
    private static int counter = 1;
    private static DLL kendaraanList = new DLL();

    static {
        kendaraanList.insert(new Kendaraan("S 4567 YV", "Basko", "Mobil", 2000, 2012, 4));
        kendaraanList.insert(new Kendaraan("N 4511 VS", "Arta", "Mobil", 2500, 2015, 3));
        kendaraanList.insert(new Kendaraan("AB 4321 A", "Wisnu", "Motor", 125, 2010, 2));
        kendaraanList.insert(new Kendaraan("B 1234 AG", "Sisa", "Motor", 150, 2020, 1));
    }

    private static TransaksiPajak[] pjk = new TransaksiPajak[4];

    public static void main(String[] args) {
        int pilih = 0;
        while (pilih != 6) {
            menu();
            System.out.print(" Pilih menu: ");
            pilih = Integer.parseInt(sc.nextLine());
            switch (pilih) {
                case 1:
                    DataKendaraan();
                    break;
                case 2:
                    bayarPajak();
                    break;
                case 3:
                    tampilTransaksi();
                    break;
                case 4:
                    transaksiPemilik();
                    break;
                case 5:
                    System.out.println("Anda Berhasil Keluar");
                    break;
            }
        }
    }

    static void menu() {
        System.out.println("Menu: ");
        System.out.println(" 1. Menampilkan Data Kendaraan");
        System.out.println(" 2. Menginputkan Pajak ");
        System.out.println(" 3. Menampilkan Seluruh Transaksi ");
        System.out.println(" 4. Menampilkan Total Pendapatan ");
        System.out.println(" 5. Keluar ");
    }

    static void DataKendaraan() {
        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Daftar Kendaraan");
        System.out.println("+++++++++++++++++++++++++++++++++++++++++");
        System.out.printf("| %-10s | %-12s | %-6s | %-12s | %-5s | %-15s |\n", "Nomor TNKB", "Nama Pemilik", "Jenis", "CC Kendaraan", "Tahun", "Bulan harus Bayar");
        kendaraanList.display();
    }
    

    static void bayarPajak() {
        System.out.println("-------------------------------");
        System.out.println("MASUKKAN DATA PEMBAYARAN");
        System.out.println("-------------------------------");
        System.out.print("Masukkan Nomor TNBK: ");
        tnbk = sc.nextLine();
        System.out.print("Bulan Bayar: ");
        bulanBayar = Integer.parseInt(sc.nextLine());
        System.out.println();
        
        Node current = kendaraanList.getHead();
        while (current != null) {
            Kendaraan kendaraan = current.data;
            if (kendaraan.getTNKB().contains(tnbk)) {
                if (kendaraan.getJenis().equals("Motor")) {
                    if (kendaraan.getCc() < 100) {
                        Pajak = 100000;
                    } else if (kendaraan.getCc() >= 250) {
                        Pajak = 250000;
                    } else {
                        Pajak = 500000;
                    }
                } else if (kendaraan.getJenis().equals("Mobil")) {
                    if (kendaraan.getCc() < 1000) {
                        Pajak = 750000;
                    } else if (kendaraan.getCc() <= 2500) {
                        Pajak = 1000000;
                    } else {
                        Pajak = 1500000;
                    }
                }

                penguranganBulan = bulanBayar - kendaraan.getBulanHarusBayar();
                if (penguranganBulan >= 1 && penguranganBulan <= 3) {
                    Denda = 50000;
                } else if (penguranganBulan > 3) {
                    Denda = penguranganBulan * 50000;
                } else {
                    Denda = 0;
                }
                System.out.println("===================================================================");
                System.out.printf("| %-10s | %-12s | %-12s | %-6s |\n", "TNKB", "Nama", "Nominal", "Denda");
                System.out.println("-------------------------------------------------------------------");
                System.out.printf("| %-10s | %-12s | %-12d | %-6d |\n", kendaraan.getTNKB(), kendaraan.getNama(), Pajak, Denda);
                System.out.println("===================================================================");

                totPendapatan = Pajak + Denda;
                totPen += totPendapatan;
                counter++;
                break;
            }
            current = current.next;
        }
        System.out.println();
        System.out.println();
    }

    static void tampilTransaksi() {
        System.out.println("======================");
        System.out.println("TOTAL TRANSAKSI");
        System.out.println("=======================");
        System.out.println("---------------------------------------------------");
        System.out.println("| KODE | PLAT | NAMA | NOMINAL | DENDA |");
        System.out.println("----------------------------------------------------");
        for (TransaksiPajak transaksi : pjk) {
            if (transaksi == null) {
                System.out.println(" ");
                return;
            }
            transaksi.printpjk();
        }
    }

    static void transaksiPemilik() {
        tampilTransaksi();
        System.out.println("==================================================================");
        System.out.printf("| TOTAL PENDAPATAN = %d |\n", totPen);
        System.out.println("==================================================================");
        System.out.println();
        System.out.println();
    }
}