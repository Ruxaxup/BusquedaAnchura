/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package TreeClasses;

import GraphClasses.Nodo;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Ruxaxup
 */
public class NodoArbol extends Nodo{

    private NodoArbol parent;
    private List<NodoArbol> hijos;
    
    public NodoArbol(char c) {
        super(c);
        parent = null;
        hijos = new LinkedList<>();
    }
    
    public void setParent(NodoArbol p){
        parent = p;
    }
    
    public NodoArbol getParent(){
        return parent;
    }
    
    public void addHijo(NodoArbol na){
        hijos.add(na);
    }
    
    public List<NodoArbol> getHijos(){
        return hijos;
    }
    
    public NodoArbol getChidlren(char c){
        for (NodoArbol nodoArbol : hijos) {
            if(nodoArbol.getC() == c) return nodoArbol;
        }
        return null;
    }
    
}
