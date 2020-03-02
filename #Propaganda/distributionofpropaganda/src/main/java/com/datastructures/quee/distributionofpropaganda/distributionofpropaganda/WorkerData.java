package com.datastructures.quee.distributionofpropaganda.distributionofpropaganda;

public class WorkerData {
    String social_security;
    String entity_anounced;
    String name;
    int total_days_worked;


    WorkerData(String social_security, String entity_anounced, String name, int total_days_worked) {
        this.social_security = social_security;
        this.entity_anounced = entity_anounced;
        this.name = name;
        this.total_days_worked = total_days_worked;
    }

    public String getEntity_anounced() {
        return entity_anounced;
    }

    public String getSocial_security() {
        return social_security;
    }

    public int getTotal_days_worked() {
        return total_days_worked;
    }

    public String getName() {
        return name;
    }
}
