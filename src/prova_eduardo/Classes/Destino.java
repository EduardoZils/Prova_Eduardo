/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova_eduardo.Classes;

import java.sql.Date;

/**
 *
 * @author eduar
 */
public class Destino {
    int Codigo;
    String Destino;
    Date DataInicial;
    Date DataTermino;
    double ValorTotal;

    public Destino(int Codigo, String Destino, Date DataInicial, Date DataTermino, double ValorTotal) {
        this.Codigo = Codigo;
        this.Destino = Destino;
        this.DataInicial = DataInicial;
        this.DataTermino = DataTermino;
        this.ValorTotal = ValorTotal;
    }

    public Destino() {
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public String getDestino() {
        return Destino;
    }

    public void setDestino(String Destino) {
        this.Destino = Destino;
    }

    public Date getDataInicial() {
        return DataInicial;
    }

    public void setDataInicial(Date DataInicial) {
        this.DataInicial = DataInicial;
    }

    public Date getDataTermino() {
        return DataTermino;
    }

    public void setDataTermino(Date DataTermino) {
        this.DataTermino = DataTermino;
    }

    public double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(double ValorTotal) {
        this.ValorTotal = ValorTotal;
    }

    @Override
    public String toString() {
        return "Destino{" + "Codigo=" + Codigo + ", Destino=" + Destino + ", DataInicial=" + DataInicial + ", DataTermino=" + DataTermino + ", ValorTotal=" + ValorTotal + '}';
    }
    
    
}
