/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova_eduardo.Classes;

/**
 *
 * @author eduar
 */
public class Custos {
    int Codigo;
    int CodigoDestino;
    String Descricao;
    int Tipo;
    double Valor;

    public Custos() {
    }

    public Custos(int Codigo, int CodigoDestino, String Descricao, int Tipo, double Valor) {
        this.Codigo = Codigo;
        this.CodigoDestino = CodigoDestino;
        this.Descricao = Descricao;
        this.Tipo = Tipo;
        this.Valor = Valor;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public int getCodigoDestino() {
        return CodigoDestino;
    }

    public void setCodigoDestino(int CodigoDestino) {
        this.CodigoDestino = CodigoDestino;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String Descricao) {
        this.Descricao = Descricao;
    }

    public int getTipo() {
        return Tipo;
    }

    public void setTipo(int Tipo) {
        this.Tipo = Tipo;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

    @Override
    public String toString() {
        return "Custos{" + "Codigo=" + Codigo + ", CodigoDestino=" + CodigoDestino + ", Descricao=" + Descricao + ", Tipo=" + Tipo + ", Valor=" + Valor + '}';
    }
    
    
}
