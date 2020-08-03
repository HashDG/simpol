package fr.hash.simpol.entities.pol;

import fr.hash.simpol.entities.eco.Household;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Statistics {

    /*
    
    Made by HashDG on 28/07/2020
    
    */


    private static File file;
    private static FileWriter writer;
    static {
        try {
            file = new File("src/fr/hash/simpol/entities/pol/stats.csv");
            writer = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Statistics() {}

    public static void reboot() {
        try {
            writer.write("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(List<Household> households) {
        try {
            for (Household household: households) {
                writer.write(household.getMoney() + ";");
            }
            writer.write("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
