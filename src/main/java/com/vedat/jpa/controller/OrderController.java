package com.vedat.jpa.controller;

import com.vedat.jpa.entity.Musteri;
import com.vedat.jpa.entity.Sepet;
import com.vedat.jpa.entity.SepetUrun;
import com.vedat.jpa.repository.*;
import com.vedat.jpa.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    private MusteriRepository musteriRepository;
    @Autowired
    private SepetRepository sepetRepository;
    @Autowired
    private SepetUrunRepository sepetUrunRepository;

    @Autowired
    private GeneralService generalService;

    @PostMapping("/testverisiolustur")
    public  String testVerisiOlustur(@RequestParam int musteriAdet, @RequestParam int sepetAdet){
        int musteri_id = musteriRepository.findMusteriId();
        int sepet_id = sepetRepository.findSepetId();

        List<Musteri> must = generalService.TestVerisiOlusturMusteri(musteriAdet);
        List<Sepet> sepet = generalService.TestVerisiOlusturSepet(musteriAdet, sepetAdet,musteri_id);
        List<SepetUrun> sepetUrun = generalService.TestVerisiOlusturSepetUrun(sepetAdet, sepet_id);

        musteriRepository.saveAll(must);
        sepetRepository.saveAll(sepet);
        sepetUrunRepository.saveAll(sepetUrun);
        return "Saved";
    }

}
