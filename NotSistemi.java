import java.util.Scanner;

public class NotSistemi {
    static class Ders {
        String isim;
        int vize;
        int finalNot;
        double ortalama;
        String durum;

        void hesapla() {
            ortalama = (vize * 0.4) + (finalNot * 0.6);

          
                if (ortalama >= 50) {
                    durum = "GEÇTİ";
                } else {
                    durum = "KALDI";
                }
        }
    }

    static class Ogrenci {
    String isim;

    Ders[] dersler = new Ders[10]; // en fazla 10 ders
    int sayac = 0;

    void dersEkle(Ders d) {
        if (sayac < dersler.length) {
            dersler[sayac] = d;
            sayac++;
        } else {
            System.out.println("Daha fazla ders eklenemez!");
        }
    }
    void Yazdir() {
        
        System.out.println("\n Öğrenci: " + isim);

        for (int i = 0; i < sayac; i++) {
            Ders d = dersler[i];

            System.out.println(  d.isim + "  Ort: " + d.ortalama +"  Durum: " + d.durum);
        }
    }
}


    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Öğrenci adı: ");
        Ogrenci ogr= new Ogrenci();
        ogr.isim= sc.nextLine();

        while (true) {
             System.out.println("\n1- Ders ekle");
             System.out.println("2- Rapor göster");
             System.out.println("3- Çıkış");
             System.out.print("Seçim: ");

            int secim = sc.nextInt();
            sc.nextLine();

            if (secim == 1) {

                Ders not =new Ders();

                System.out.print("Ders adı: ");
                not.isim = sc.nextLine();

                System.out.print("Vize: ");
                not.vize = sc.nextInt();

                System.out.print("Final: ");
                not.finalNot = sc.nextInt();
                sc.nextLine();

                not.hesapla();
   
                ogr.dersEkle(not);

            } else if (secim == 2) {

                ogr.Yazdir();
            } else {
                break;
            }
        }

        sc.close();
    }
}

