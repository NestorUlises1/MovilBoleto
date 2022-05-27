package com.example.boleto;

import java.util.Date;

public class Boleto {
    private int id;
    private String nombre;
    private String destino;
    private int tipoViaje;
    private int precio;
    private Date fecha;
    private static final int IMPUESTO=16;
    private static int contador;

    public Boleto() {
        this.id=++Boleto.contador;

    }


    public Boleto(String nombre, String destino,int precio, int tipoViaje, Date fecha) {
        this();
        this.nombre = nombre;
        this.destino = destino;
        this.precio = precio;
        this.tipoViaje = tipoViaje;
        this.fecha = fecha;
    }

    public Boleto(Boleto boleto){
        System.out.println("Id: "+boleto.getId());
        System.out.println("Nombre: "+boleto.getNombre());
        System.out.println("Destino: "+boleto.getDestino());
        System.out.println("Tipo de viaje: "+boleto.getTipoViaje());
        System.out.println("Precio: "+boleto.getPrecio());
        System.out.println("Fecha: "+boleto.getFecha());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public int getTipoViaje() {
        return tipoViaje;
    }

    public void setTipoViaje(int tipoViaje) {
        this.tipoViaje = tipoViaje;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public int calcularTotal(int descuento){
        int total=descuento+calcularImpuesto()+calcularSubtotal();
        return total;
    }
    public int calcularDescuento(int edad){
        if(edad>60){
            return calcularSubtotal()*50/100;
        }
        return 0;
    }
    public int calcularImpuesto(){
        return calcularSubtotal()*Boleto.IMPUESTO/100;
    }
    public int calcularSubtotal(){
        if(this.tipoViaje==1){
            this.precio=this.precio+950;
        }
        else if(this.tipoViaje==2){
            this.precio=this.precio+(950*80/100+950);
        }
        return this.precio;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", \nnombre='" + nombre + '\'' +
                ", \ndestino='" + destino + '\'' +
                ", \ntipoViaje=" + tipoViaje +
                ", \nprecio=" + precio +
                ", \nfecha=" + fecha;
    }
}
