public class Kendaraan {
    private String noTNKB;
    private String nama;
    private String jenis;
    private int cc;
    private int tahun;
    private int bulanHarusBayar;

    public Kendaraan(String TNKB, String nama, String jenis, int cc, int tahun, int bulanHarusBayar) {
        this.noTNKB = TNKB;
        this.nama = nama;
        this.jenis = jenis;
        this.cc = cc;
        this.tahun = tahun;
        this.bulanHarusBayar = bulanHarusBayar;
    }
    

    public String getTNKB() {
        return noTNKB;
    }

    public String getNama() {
        return nama;
    }

    public String getJenis() {
        return jenis;
    }

    public int getCc() {
        return cc;
    }

    public int getTahun() {
        return tahun;
    }

    public int getBulanHarusBayar() {
        return bulanHarusBayar;
    }

    public void printKdr() {
        System.out.printf("| %-10s | %-12s | %-6s | %-12d | %-5d | %-15d |\n", noTNKB, nama, jenis, cc, tahun, bulanHarusBayar);
    }
}