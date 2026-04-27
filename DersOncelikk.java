import java.util.Scanner;
import java.io.*;

public class DersOncelikk {
    //kullanıcıdan derslerin bilgilerini alarak bu derslerden hangisine daha öncelik vermesi gerektiğini verlen bilgilere dayanarak bir puan hesabı yaparak puan sonucuna göre ders önceliğini veren 
    public static void main(String[] args) throws Exception {
        File f = new File("calismaplani.txt");
        if (!f.exists()) {
        f.mkdir();
        }
        Scanner oku = new Scanner(System.in);

        FileWriter yaz = new FileWriter("calismaplani.txt");
        System.out.print("Kaç ders gireceksiniz: ");
        int n = oku.nextInt();
        oku.nextLine();

        String[] dersAd = new String[n];  // her bilgiyi ayrı sakladıkk
        int[] gun = new int[n];
        int[] zorluk = new int[n];
        int[] puan = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n Ders " + (i + 1));

            System.out.print("Ders adı: ");
            dersAd[i] = oku.nextLine();

            System.out.print("Sınava kaç gün kaldı: ");
            gun[i] = Integer.parseInt(oku.nextLine());

            System.out.print("Zorluk seviyesi (1-5): ");
            zorluk[i] = Integer.parseInt(oku.nextLine());
            
            puan[i] = (30- gun[i]) + (zorluk[i] * 2);
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {

                if (puan[j] > puan[i]) {

                    int tempPuan = puan[i];
                    puan[i] = puan[j];
                    puan[j] = tempPuan;

                    String tempAd = dersAd[i];
                    dersAd[i] = dersAd[j];
                    dersAd[j] = tempAd;

                    int tempGun = gun[i];
                    gun[i] = gun[j];
                    gun[j] = tempGun;
    
                    int tempZorluk = zorluk[i];
                    zorluk[i] = zorluk[j];
                    zorluk[j] = tempZorluk;
                   
                }
            }
        }

       

        System.out.println("\n--- ÇALIŞMA PLANI ---");
        yaz.write("--- ÇALIŞMA PLANI ---\n");

        for (int i = 0; i < n; i++) {
            String satir = (i + 1) + ". gün: " + dersAd[i]
                    + "   puan: " + puan[i]
                    + "   kalan gün: " + gun[i]
                    + "   zorluk: " + zorluk[i];

            System.out.println(satir);
            yaz.write(satir + "\n");
        }
        yaz.close();
        System.out.println("\n çalışma planı calismaplani.txt dosyasına kaydedildi.");
    }
}


