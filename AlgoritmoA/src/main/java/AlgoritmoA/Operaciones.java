/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgoritmoA;

import java.util.LinkedList;
import java.lang.String;

/**
 *
 * @author oswaldo
 */
public class Operaciones {

    private Nodo matriz[][];
    private LinkedList<Coordenadas> listaAbierta;
    private LinkedList<Coordenadas> listaCerrada;
    private int pesoHo = 10;
    private int pesoVer = 10;
    private int pesoDiag = 14;
    private int turno;
    private int dimA;
    private int dimB;
    private boolean ganador = false;
    private int o;
    private int xIni ;
    private int xFin ;
    private int yIni ;
    private int yFin ;

    public void realizarRecorrido() {
        
        Coordenadas e;
        e = new Coordenadas(xIni, yIni);
        while (!ganador) {
            this.meterAbiertos(e.getX(), e.getY());
            e = seleccionaSig();
            ganador = esGanador(e.getX(), e.getY());
            System.out.println("(" + e.getX() + "," + e.getY() + ")");
        }

    }

    public Operaciones(int dimA, int dimB) {
        this.dimA = dimA;
        this.dimB = dimB;
        matriz = new Nodo[dimA][dimB];
        listaAbierta = new LinkedList<Coordenadas>();
        listaCerrada = new LinkedList<Coordenadas>();
//        listaV = new LinkedList<Coordenadas>();
//        pilaW = new Pila();

    }

    public void meterAbiertos(int i, int j) {
        if (j + 1 >= 0 && j + 1 < this.dimB && i >= 0 && i < this.dimA && matriz[i][j + 1].getA() == 'O') {
            Coordenadas cor = new Coordenadas(i, j + 1);
            int g = pesoHo;
            int h = (Math.abs(i - (this.xFin)) * pesoHo) + (Math.abs((j + 1) - (this.yFin)) * pesoVer);
            this.matriz[i][j + 1].setH(h);
            this.matriz[i][j + 1].setG(g);
            this.matriz[i][j + 1].setF(h + g);
            this.matriz[i][j + 1].setA('#');
            this.listaAbierta.add(cor);
        }
        if (j - 1 >= 0 && j - 1 < this.dimB && i >= 0 && i < this.dimA && matriz[i][j - 1].getA() == 'O') {
            Coordenadas cor = new Coordenadas(i, j - 1);
            int g = pesoHo;
            int h = (Math.abs(i - (this.xFin)) * pesoHo) + (Math.abs((j - 1) - (this.yFin)) * pesoVer);
            this.matriz[i][j - 1].setH(h);
            this.matriz[i][j - 1].setG(g);
            this.matriz[i][j - 1].setF(h + g);
            this.matriz[i][j - 1].setA('#');
            this.listaAbierta.add(cor);
        }
        if (j >= 0 && j < this.dimB && i + 1 >= 0 && i + 1 < this.dimA && matriz[i + 1][j].getA() == 'O') {
            Coordenadas cor = new Coordenadas(i + 1, j);
            int g = pesoVer;
            int h = (Math.abs((i + 1) - (this.xFin)) * pesoHo) + (Math.abs((j) - (this.yFin)) * pesoVer);
            this.matriz[i + 1][j].setH(h);
            this.matriz[i + 1][j].setG(g);
            this.matriz[i + 1][j].setF(h + g);
            this.matriz[i + 1][j].setA('#');
            this.listaAbierta.add(cor);
        }
        if (j >= 0 && j < this.dimB && i - 1 >= 0 && i - 1 < this.dimA && matriz[i - 1][j].getA() == 'O') {
            Coordenadas cor = new Coordenadas(i - 1, j);
            int g = pesoVer;
            int h = (Math.abs((i - 1) - (this.xFin)) * pesoHo) + (Math.abs((j) - (this.yFin)) * pesoVer);
            this.matriz[i - 1][j].setH(h);
            this.matriz[i - 1][j].setG(g);
            this.matriz[i - 1][j].setF(h + g);
            this.matriz[i - 1][j].setA('#');
            this.listaAbierta.add(cor);
        }
        if (j + 1 >= 0 && j + 1 < this.dimB && i - 1 >= 0 && i - 1 < this.dimA && matriz[i - 1][j + 1].getA() == 'O') {
            Coordenadas cor = new Coordenadas(i - 1, j + 1);
            int g = pesoDiag;
            int h = (Math.abs((i - 1) - (this.xFin)) * pesoHo) + (Math.abs((j + 1) - (this.yFin)) * pesoVer);
            this.matriz[i - 1][j + 1].setH(h);
            this.matriz[i - 1][j + 1].setG(g);
            this.matriz[i - 1][j + 1].setF(h + g);
            this.matriz[i - 1][j + 1].setA('#');
            this.listaAbierta.add(cor);
        }
        if (j + 1 >= 0 && j + 1 < this.dimB && i + 1 >= 0 && i + 1 < this.dimA && matriz[i + 1][j + 1].getA() == 'O') {
            Coordenadas cor = new Coordenadas(i + 1, j + 1);
            int g = pesoDiag;
            int h = (Math.abs((i + 1) - (this.xFin)) * pesoHo) + (Math.abs((j + 1) - (this.yFin)) * pesoVer);
            this.matriz[i + 1][j + 1].setH(h);
            this.matriz[i + 1][j + 1].setG(g);
            this.matriz[i + 1][j + 1].setF(h + g);
            this.matriz[i + 1][j + 1].setA('#');
            this.listaAbierta.add(cor);
        }
        if (j - 1 >= 0 && j - 1 < this.dimB && i - 1 >= 0 && i - 1 < this.dimA && matriz[i - 1][j - 1].getA() == 'O') {
            Coordenadas cor = new Coordenadas(i - 1, j - 1);
            int g = pesoDiag;
            int h = (Math.abs((i - 1) - (this.xFin)) * pesoHo) + (Math.abs((j - 1) - (this.yFin)) * pesoVer);
            this.matriz[i - 1][j - 1].setH(h);
            this.matriz[i - 1][j - 1].setG(g);
            this.matriz[i - 1][j - 1].setF(h + g);
            this.matriz[i - 1][j - 1].setA('#');
            this.listaAbierta.add(cor);
        }
        if (j - 1 >= 0 && j - 1 < this.dimB && i + 1 >= 0 && i + 1 < this.dimA && matriz[i + 1][j - 1].getA() == 'O') {
            Coordenadas cor = new Coordenadas(i + 1, j - 1);
            int g = pesoDiag;
            int h = (Math.abs((i + 1) - (this.xFin)) * pesoHo) + (Math.abs((j - 1) - (this.yFin)) * pesoVer);
            this.matriz[i + 1][j - 1].setH(h);
            this.matriz[i + 1][j - 1].setG(g);
            this.matriz[i + 1][j - 1].setF(h + g);
            this.matriz[i + 1][j - 1].setA('#');
            this.listaAbierta.add(cor);
        }
    }
     
    public boolean esGanador(int i, int j) {
        Boolean ganador = false;
        if (j + 1 >= 0 && j + 1 < this.dimB && i >= 0 && i < this.dimA && matriz[i][j + 1].getA() == 'S') {
            ganador=true;
            Coordenadas cor = new Coordenadas(i , j + 1);
            listaCerrada.add(cor);
        }
        if (j - 1 >= 0 && j - 1 < this.dimB && i >= 0 && i < this.dimA && matriz[i][j - 1].getA() == 'S') {
           ganador=true;
           Coordenadas cor = new Coordenadas(i , j - 1);
           listaCerrada.add(cor);
        }
        if (j >= 0 && j < this.dimB && i + 1 >= 0 && i + 1 < this.dimA && matriz[i + 1][j].getA() == 'S') {
            ganador=true;
            Coordenadas cor = new Coordenadas(i + 1, j);
            listaCerrada.add(cor);
        }
        if (j >= 0 && j < this.dimB && i - 1 >= 0 && i - 1 < this.dimA && matriz[i - 1][j].getA() == 'S') {
            ganador=true;
            Coordenadas cor = new Coordenadas(i - 1, j);
            listaCerrada.add(cor);
        }
        if (j + 1 >= 0 && j + 1 < this.dimB && i - 1 >= 0 && i - 1 < this.dimA && matriz[i - 1][j + 1].getA() == 'S') {
            ganador=true;
            Coordenadas cor = new Coordenadas(i - 1, j + 1);
            listaCerrada.add(cor);
        }
        if (j + 1 >= 0 && j + 1 < this.dimB && i + 1 >= 0 && i + 1 < this.dimA && matriz[i + 1][j + 1].getA() == 'S') {
            ganador=true;
            Coordenadas cor = new Coordenadas(i + 1, j + 1);
            listaCerrada.add(cor);
        }
        if (j - 1 >= 0 && j - 1 < this.dimB && i - 1 >= 0 && i - 1 < this.dimA && matriz[i - 1][j - 1].getA() == 'S') {
           ganador=true;
           Coordenadas cor = new Coordenadas(i - 1, j - 1);
           listaCerrada.add(cor);
        }
        if (j - 1 >= 0 && j - 1 < this.dimB && i + 1 >= 0 && i + 1 < this.dimA && matriz[i + 1][j - 1].getA() == 'S') {
            ganador=true;
            Coordenadas cor = new Coordenadas(i + 1, j - 1);
            listaCerrada.add(cor);
        }
        return ganador;
    }

    public void crearMatriz() {
        for (int i = 0; i < dimA; i++) {
            for (int j = 0; j < dimB; j++) {
                Nodo n = new Nodo(i, j, 'O', false);
                n.setF(0);
                n.setG(0);
                n.setH(0);
                matriz[i][j] = n;

            }
        }
    }

    public void asigIniFin() {
        matriz[this.xIni][this.yIni].setA('I');
        matriz[this.xFin][this.yFin].setA('S');
    }
    public void asigIniFinClass() {
        matriz[2][0].setA('I');
        matriz[2][4].setA('S');
    }

    public Coordenadas seleccionaSig() {
        Coordenadas cor;
        int menor, posx = listaAbierta.get(0).getX(), posy = listaAbierta.get(0).getY(), eli = 0;
        menor = matriz[listaAbierta.get(0).getX()][listaAbierta.get(0).getY()].getF();
        for (int i = 0; i < listaAbierta.size(); i++) {
            if (menor > matriz[listaAbierta.get(i).getX()][listaAbierta.get(i).getY()].getF()) {
                menor = matriz[listaAbierta.get(i).getX()][listaAbierta.get(i).getY()].getF();
                posx = listaAbierta.get(i).getX();
                posy = listaAbierta.get(i).getY();
                eli = i;
            }
        }
        listaAbierta.remove(eli);
        cor = new Coordenadas(posx, posy);
        listaCerrada.add(cor);
        return cor;
    }

    public void asigParedesClass() {
        matriz[1][2].setA('#');
        matriz[2][2].setA('#');
        matriz[3][2].setA('#');
    }

    public void imprimirMatriz() {
        for (int i = 0; i < dimA; i++) {
            for (int j = 0; j < dimB; j++) {
                System.out.print("" + matriz[i][j].getX());
                System.out.print("  " + matriz[i][j].getY());
                System.out.print("  " + matriz[i][j].getA());
                System.out.print("  " + matriz[i][j].getF());
                System.out.print("  " + matriz[i][j].getG());
                System.out.print("  " + matriz[i][j].getH());
                System.out.print("  " + matriz[i][j].isVisita() + "    ");
            }
            System.out.println("");
        }
    }

    public void imprimirAbiertos() {
        for (int i = 0; i < listaAbierta.size(); i++) {
            System.out.print("(" + listaAbierta.get(i).getX());
            System.out.println("," + listaAbierta.get(i).getY() + ")");
        }
    }
    public void imprimirCerrados() {
        for (int i = 0; i < listaCerrada.size(); i++) {
            System.out.print("(" + listaCerrada.get(i).getX());
            System.out.println("," + listaCerrada.get(i).getY() + ")");
        }
    }

    //Getter and Setter
    public Nodo[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(Nodo[][] matriz) {
        this.matriz = matriz;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getDimA() {
        return dimA;
    }

    public void setDimA(int dimA) {
        this.dimA = dimA;
    }

    public int getDimB() {
        return dimB;
    }

    public void setDimB(int dimB) {
        this.dimB = dimB;
    }

    public int getO() {
        return o;
    }

    public void setO(int o) {
        this.o = o;
    }

    public int getxIni() {
        return xIni;
    }

    public void setxIni(int xIni) {
        this.xIni = xIni;
    }

    public int getxFin() {
        return xFin;
    }

    public void setxFin(int xFin) {
        this.xFin = xFin;
    }

    public int getyIni() {
        return yIni;
    }

    public void setyIni(int yIni) {
        this.yIni = yIni;
    }

    public int getyFin() {
        return yFin;
    }

    public void setyFin(int yFin) {
        this.yFin = yFin;
    }

}
