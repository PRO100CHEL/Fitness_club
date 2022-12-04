package it.ikbo1120.fitness_club_v1_1.domain.repository.mock;

import java.util.ArrayList;
import java.util.List;

import it.ikbo1120.fitness_club_v1_1.domain.model.Services;

public class MockBase {
    private static List<Services> services;

    static {
        services = new ArrayList<>();
        Services services1 = new Services(1l, "Спортзал", "Какой-то зал", 1200f);
        Services services2 = new Services(2l, "Бассейн", "Какой-то зал", 1200f);
        Services services3 = new Services(3l, "Сауна", "Какой-то зал", 1200f);
        Services services4 = new Services(4l, "Массаж", "Какой-то зал", 1200f);
        Services services5 = new Services(5l, "Мастер-классы", "Какой-то зал", 1200f);
        services.add(services1);
        services.add(services2);
        services.add(services3);
        services.add(services4);
        services.add(services5);
    }

    public List<Services> getAllServices(){
        return services;
    }

}
