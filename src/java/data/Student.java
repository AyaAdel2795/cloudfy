/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

/**
 *
 * @author ZAS
 */
public class Student {
    private int ID;
    private String NAME;
    private String GPA;
    private int clas;
    private String USR;
    private String PAS;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getGPA() {
        return GPA;
    }

    public void setGPA(String GPA) {
        this.GPA = GPA;
    }

    public int getClas() {
        return clas;
    }

    public void setClas(int clas) {
        this.clas = clas;
    }

    public String getUSR() {
        return USR;
    }

    public void setUSR(String USR) {
        this.USR = USR;
    }

    public String getPAS() {
        return PAS;
    }

    public void setPAS(String PAS) {
        this.PAS = PAS;
    }
    
}
