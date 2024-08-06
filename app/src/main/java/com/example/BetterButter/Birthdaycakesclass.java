package com.example.BetterButter;

public class Birthdaycakesclass {
    String bid = "";
    String bcakename = "";
    String bcakeid = "";
    String bcakeweight = "";
    String bcakecolors = "";
    String bcakenote = "";
    String bcakeprice = "";
    String bcakeqty = "";
    String bcreated_at = "";


    public Birthdaycakesclass(String bid, String bcakename, String bcakeid, String bcakeweight, String bcakecolors, String bcakenote, String bcakeprice, String bcakeqty, String bcreated_at) {
        this.bid = bid;
        this.bcakename = bcakename;
        this.bcakeid = bcakeid;
        this.bcakeweight = bcakeweight;
        this.bcakecolors = bcakecolors;
        this.bcakenote = bcakenote;
        this.bcakeprice = bcakeprice;
        this.bcakeqty = bcakeqty;
        this.bcreated_at = bcreated_at;
    }

    public Birthdaycakesclass() {
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBcakename() {
        return bcakename;
    }

    public void setBcakename(String bcakename) {
        this.bcakename = bcakename;
    }

    public String getBcakeid() {
        return bcakeid;
    }

    public void setBcakeid(String bcakeid) {
        this.bcakeid = bcakeid;
    }

    public String getBcakeweight() {
        return bcakeweight;
    }

    public void setBcakeweight(String bcakeweight) {
        this.bcakeweight = bcakeweight;
    }

    public String getBcakecolors() {
        return bcakecolors;
    }

    public void setBcakecolors(String bcakecolors) {
        this.bcakecolors = bcakecolors;
    }

    public String getBcakenote() {
        return bcakenote;
    }

    public void setBcakenote(String bcakenote) {
        this.bcakenote = bcakenote;
    }

    public String getBcakeprice() {
        return bcakeprice;
    }

    public void setBcakeprice(String bcakeprice) {
        this.bcakeprice = bcakeprice;
    }

    public String getBcakeqty() {
        return bcakeqty;
    }

    public void setBcakeqty(String bcakeqty) {
        this.bcakeqty = bcakeqty;
    }

    public String getBCreated_at() {
        return bcreated_at;
    }

    public void setBCreated_at(String bcreated_at) {
        this.bcreated_at = bcreated_at;
    }


}

