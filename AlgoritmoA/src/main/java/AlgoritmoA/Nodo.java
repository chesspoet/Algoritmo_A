/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmoA;

/**
 *
 * @author oswaldo
 */
public class Nodo {
    private int x;
    private int y;
    private char a;
    private boolean visita;
    private int g;
    private int h;
    private int f;

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }
    public Nodo(int x, int y, char a, boolean visita){
        this.x=x;
        this.y=y;
        this.a=a;
        this.visita=visita;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getA() {
        return a;
    }

    public void setA(char a) {
        this.a = a;
    }

    public boolean isVisita() {
        return visita;
    }

    public void setVisita(boolean visita) {
        this.visita = visita;
    }
    
}
