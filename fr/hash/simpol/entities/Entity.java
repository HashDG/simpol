package fr.hash.simpol.entities;

public abstract class Entity {
    /*
    
    Made by HashDG on 28/07/2020
    
    */

    int id;

    public Entity(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
