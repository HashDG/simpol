package fr.hash.simpol.entities.eco;

import fr.hash.simpol.entities.Entity;

public abstract class EcoEntity extends Entity {
    /*
    
    Made by HashDG on 28/07/2020
    
    */

    float money;

    public EcoEntity(int id, float money) {
        super(id);
        this.money = money;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public void addMoney(float money) {
        this.money += money;
    }

    public void subMoney(float money) {
        this.money -= money;
    }
}
