package etu.labs.currency.controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081", maxAge = 3600)
@RestController
public class CurrencyController {

    private Integer rate;

    CurrencyController(){
        this.rate = 1;
    }

    @GetMapping(value = "/convert")
    public @ResponseBody Integer convert(@RequestParam("amount") Integer amount){
        return rate*amount;
    }

    @GetMapping(value = "/setrate")
    public @ResponseBody Integer setrate(@RequestParam("rate") Integer rate) {
        this.rate = rate;
        return this.rate;
    }

    @GetMapping(value = "/getrate")
    public @ResponseBody Integer getrate() {
        return this.rate;
    }

}

