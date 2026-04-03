package com.ahlenius.wigell_cinema.model;

public enum AgeLimit {
    MINI("0"),
    KIDS("6"),
    TEENS("13"),
    GROWNUP("18");

    private final String age;

    AgeLimit(String age){this.age = age;}

    public String getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Åldersgräns : " + age;    }
}
