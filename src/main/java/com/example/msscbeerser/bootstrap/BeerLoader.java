package com.example.msscbeerser.bootstrap;

import com.example.msscbeerser.domain.Beer;
import com.example.msscbeerser.repositories.BeerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BeerLoader implements CommandLineRunner {
   private final BeerRepository beerRepository;

    public BeerLoader(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadBeerObjects();
    }

    private void loadBeerObjects() {
        if(beerRepository.count()==0){
            beerRepository.save(Beer.builder()
            .beerName("Mango")
            .beerStyle("IPA")
            .quantityToBrew(200)
            .minOnHand(12)
            .upc(337010000001L)
            .price(new BigDecimal("12.95"))
            .build());

            beerRepository.save(Beer.builder()
                    .beerName("Galaxy cat")
                    .beerStyle("Pale_ALE")
                    .quantityToBrew(200)
                    .minOnHand(12)
                    .upc(337010000002L)
                    .price(new BigDecimal("11.95"))
                    .build());
        }
        System.out.println("Loaded Beers"+beerRepository.count());
    }

}
