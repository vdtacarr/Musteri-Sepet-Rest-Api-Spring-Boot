package com.vedat.jpa.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.vedat.jpa.entity.Musteri;
import com.vedat.jpa.entity.Sepet;
import com.vedat.jpa.entity.SepetUrun;
import org.springframework.stereotype.Service;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
@Service
public class GeneralService {
public List<Musteri> TestVerisiOlusturMusteri(int sayi1) {
    String[] sehirler = {"Ankara", "İstanbul", "İzmir", "Bursa", "Edirne", "Konya", "Antalya", "Diyarbakır", "Van", "Rize"};
    List<Musteri> musteri = new ArrayList<Musteri>();
    for (int i = 0; i < sayi1; i++) {
        Random rnd = new Random();
        Musteri musteridef = new Musteri();
        musteridef.setAd(generateRandomPassword(5));
        musteridef.setSoyad(generateRandomPassword(5));
        musteridef.setSehir(sehirler[rnd.nextInt(10)]);
        musteri.add(musteridef);
    }
    return musteri;
}

public List<Sepet> TestVerisiOlusturSepet(int sayi1, int sayi2, int id1){
        List<Sepet> sepet = new ArrayList<Sepet>();
        for (int i = 0; i < sayi2; i++) {
            //databasedeki son id ye sahip kişi ile eklenecek kişi sayısı arasında id oluşturuyor.
            int rnd = ThreadLocalRandom.current().nextInt(id1, id1 + sayi1);
            Sepet spt = new Sepet();
            spt.setMusteriId(rnd);
            sepet.add(spt);
        }
        return sepet;
    }

public List<SepetUrun> TestVerisiOlusturSepetUrun(int sayi2, int id2){
        List<SepetUrun> sepetUrunler = new ArrayList<SepetUrun>();
        int urunAdet = ThreadLocalRandom.current().nextInt(1, 5);
        for (int i = 0; i < sayi2; i++) {
            SepetUrun sptUrun = new SepetUrun();
            for(int j=0;j<urunAdet;j++){
                sptUrun.setSepetId(id2+i+1);
                sptUrun.setTutar(BigDecimal.valueOf(ThreadLocalRandom.current().nextInt(100,1000)));
                sptUrun.setAciklama(generateRandomPassword(50));
                sepetUrunler.add(sptUrun);
            }
        }
        return sepetUrunler;
    }


public static String generateRandomPassword(int len) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijk";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        }
        return sb.toString();
    }
}
