package com.example.BetterButter;

public class Classiccupcakesclass {
    String id = "";
    String cakename = "";
    String cakeid = "";
    String cakeweight = "";
    String cakecolors  = "";
    String cakenote = "";
    String cakeprice = "";
    String cakeqty = "";

    public Classiccupcakesclass(String id, String cakename, String cakeid, String cakeweight, String cakecolors, String cakenote, String cakeprice, String cakeqty, String created_at) {
        this.id = id;
        this.cakename = cakename;
        this.cakeid = cakeid;
        this.cakeweight = cakeweight;
        this.cakecolors = cakecolors;
        this.cakenote = cakenote;
        this.cakeprice = cakeprice;
        this.cakeqty = cakeqty;
        this.created_at = created_at;
    }

    public Classiccupcakesclass (){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCakename() {
        return cakename;
    }

    public void setCakename(String cakename) {
        this.cakename = cakename;
    }

    public String getCakeid() {
        return cakeid;
    }

    public void setCakeid(String cakeid) {
        this.cakeid = cakeid;
    }

    public String getCakeweight() {
        return cakeweight;
    }

    public void setCakeweight(String cakeweight) {
        this.cakeweight = cakeweight;
    }

    public String getCakecolors() {
        return cakecolors;
    }

    public void setCakecolors(String cakecolors) {
        this.cakecolors = cakecolors;
    }

    public String getCakenote() {
        return cakenote;
    }

    public void setCakenote(String cakenote) {
        this.cakenote = cakenote;
    }


    public String getCakeprice() {
        return cakeprice;
    }

    public void setCakeprice(String cakeprice) {
        this.cakeprice = cakeprice;
    }

    public String getCakeqty() {
        return cakeqty;
    }

    public void setCakeqty(String cakeqty) {
        this.cakeqty = cakeqty;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    String created_at = "";


}
