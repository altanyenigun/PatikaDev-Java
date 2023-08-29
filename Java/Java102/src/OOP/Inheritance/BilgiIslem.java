package OOP.Inheritance;

public class BilgiIslem extends Memur {
    private String gorev;

    public BilgiIslem(String adSoyad, String telefon, String eposta, String departman, String mesai, String gorev) {
        super(adSoyad, telefon, eposta, departman, mesai);
        this.gorev = gorev;
    }

    public void networkKurulum(){
        System.out.println(this.getAdSoyad() + " network kurulumu yapti");
    }
}
