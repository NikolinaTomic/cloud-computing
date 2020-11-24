package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Counter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int count;

    public int getCount(){
        return count;
    }

    public void setCount(int count){
        this.count = count;
    }
}
