public class TransaksiPajak {
    private int kode;
    private String TNKB;
    private String nama;
    private int pajak;
    private int denda;

    public TransaksiPajak(int kode, String TNKB, String nama, int pajak, int denda) {
        this.kode = kode;
        this.TNKB = TNKB;
        this.nama = nama;
        this.pajak = pajak;
        this.denda = denda;
    }

    public void printpjk() {
        System.out.printf("| %d | %s | %s | %d | %d |\n", kode, TNKB, nama, pajak, denda);
    }
}