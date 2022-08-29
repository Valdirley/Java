/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author Alessandra Mendes
 */
public class Pedido {
    private int horaCompra;
    private String endEntrega;
    private int qtdBotijoes;
    private float totalCompra;
    private int horaEntrega;
    private String cartaoCredito;
    private String status;
    private int codigo;
    
    public void setHoraCompra(int h){
        horaCompra = h;
    }
    public void setEndEntrega(String e){
        endEntrega = e;
    }
    public int getHoraCompra(){
        return horaCompra;
    }
    public String getEndEntrega(){
        return endEntrega;
    }
    public void setQtdBotijoes(int q){
        qtdBotijoes = q;
    }
    public void calcular(){
        totalCompra = 60 * qtdBotijoes;
        horaEntrega = horaCompra + 6;
        if(horaEntrega>24){
            horaEntrega = horaEntrega - 24;
        }
    }
    public float getTotalCompra(){
        return totalCompra;
    }
    public int getHoraEntrega(){
        return horaEntrega;
    }
    public void setCartaoCredito(String c){
        cartaoCredito = c;
    }
    public void confirmarPedido(){
        status = "confirmado";
    }
    public void setCodigo(int c){
        codigo = c;
    }
    public int getCodigo(){
        return codigo;
    }
    public void entregarPedido(){
        status = "entregue";
    }
    public String getStatus(){
        return status;
    }
    public int getQtdBotijoes(){
        return qtdBotijoes;
    }
    public String getCartaoCredito(){
        return cartaoCredito;
    }
}
