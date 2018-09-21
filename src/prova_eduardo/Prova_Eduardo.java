/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prova_eduardo;

import prova_eduardo.Telas.Selecao;

/**
 *
 * @author eduar
 */
public class Prova_Eduardo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Selecao dialog = new Selecao(new javax.swing.JFrame(), true);
        dialog.setVisible(true);
        if (!dialog.isActive()) {
            System.exit(0);
        }
    }
}
