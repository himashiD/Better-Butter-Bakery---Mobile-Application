package com.example.BetterButter;

public class Orderproductclass {

    String orid = "";
    String orproductname = "";
    String orproductid = "";
    String orproductflavour = "";
    String orproductqty = "";
    String orcusname = "";
    String orcuscontact = "";
    String orstatus = "";
    String orcreated_at = "";


    public Orderproductclass(String orid, String orproductname, String orproductid, String orproductflavour, String orproductqty, String orcusname, String orcuscontact, String orstatus, String orcreated_at) {
        this.orid = orid;
        this.orproductname = orproductname;
        this.orproductid = orproductid;
        this.orproductflavour = orproductflavour;
        this.orproductqty = orproductqty;
        this.orcusname = orcusname;
        this.orcuscontact = orcuscontact;
        this.orstatus = orstatus;
        this.orcreated_at = orcreated_at;
    }

    public Orderproductclass() {
    }

    public String getOrid() {
        return orid;
    }

    public void setOrid(String orid) {
        this.orid = orid;
    }

    public String getOrproductname() {
        return orproductname;
    }

    public void setOrproductname(String orproductname) {
        this.orproductname = orproductname;
    }

    public String getOrproductid() {
        return orproductid;
    }

    public void setOrproductid(String orproductid) {
        this.orproductid = orproductid;
    }

    public String getOrproductflavour() {
        return orproductflavour;
    }

    public void setOrproductflavour(String orproductflavour) {
        this.orproductflavour = orproductflavour;
    }

    public String getOrproductqty() {
        return orproductqty;
    }

    public void setOrproductqty(String orproductqty) {
        this.orproductqty = orproductqty;
    }

    public String getOrcusname() {
        return orcusname;
    }

    public void setOrcusname(String orcusname) {
        this.orcusname = orcusname;
    }

    public String getOrcuscontact() {
        return orcuscontact;
    }

    public void setOrcuscontact(String orcuscontact) {
        this.orcuscontact = orcuscontact;
    }

    public String getOrstatus() {
        return orstatus;
    }

    public void setOrstatus(String orstatus) {
        this.orstatus = orstatus;
    }

    public String getOrcreated_at() {
        return orcreated_at;
    }

    public void setOrcreated_at(String orcreated_at) {
        this.orcreated_at = orcreated_at;
    }


}
