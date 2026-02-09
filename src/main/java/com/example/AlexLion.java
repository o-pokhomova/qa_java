package com.example;

import java.util.List;

public class AlexLion extends Lion{
    public AlexLion(Feline feline) throws Exception {
        super(feline, "Самец");
    }

    public List<String> getFriends() {
        return List.of(
                "Марти",
                "Глория",
                "Мелман"
        );
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }

    @Override
    public int getKittens() {
        return 0;
    }
}
