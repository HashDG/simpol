package fr.hash.simpol;

import fr.hash.simpol.config.Configuration;
import fr.hash.simpol.entities.eco.EcoEntity;
import fr.hash.simpol.entities.eco.Household;
import fr.hash.simpol.entities.pol.Statistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Market {

    /*
    
    Made by HashDG on 28/07/2020
    
    */

    List<Household> households = new ArrayList<>();

    public Market() {
        for (int i = 0; i < Configuration.HOUSEHOLD_AMOUNT; i++) {
            households.add(new Household(i, Configuration.BASIC_MONEY_AMOUNT));
        }
    }

    public void launch(int turnAmount) {
        debug("[START ANALYSIS]");
        for (int i = 0; i < turnAmount; i++) {
            Household first = households.get(new Random().nextInt(Configuration.HOUSEHOLD_AMOUNT));
            Household second = households.get(new Random().nextInt(Configuration.HOUSEHOLD_AMOUNT));

            while (first == second || second.getMoney() <= 0 || first.getMoney() <= 0) {                second = households.get(new Random().nextInt(Configuration.HOUSEHOLD_AMOUNT));
                first = households.get(new Random().nextInt(Configuration.HOUSEHOLD_AMOUNT));
                second = households.get(new Random().nextInt(Configuration.HOUSEHOLD_AMOUNT));
            }

            exchange(first, second);
            Statistics.write(households);
        }
        debug("[END ANALYSIS]");
    }

    private void exchange(Household first, Household second) {
        float moneyToExchange;

        if (first.getMoney() > second.getMoney()) {
            moneyToExchange = (second.getMoney() * 10F) / 100F;

            if (new Random().nextBoolean()) {
                first.addMoney(moneyToExchange);
                second.subMoney(moneyToExchange);
            } else {
                first.subMoney(moneyToExchange);
                second.addMoney(moneyToExchange);
            }

        } else {
            moneyToExchange = (first.getMoney() * 10F) / 100F;

            if (new Random().nextBoolean()) {
                first.addMoney(moneyToExchange);
                second.subMoney(moneyToExchange);
            } else {
                first.subMoney(moneyToExchange);
                second.addMoney(moneyToExchange);
            }
        }
    }

    private void debug(String name) {
        System.out.println(name);
        for (int i = 0; i < households.size(); i++) {
            System.out.println("Id: " + households.get(i).getId() + ", Money: " + (int) households.get(i).getMoney());
        }
    }
}
