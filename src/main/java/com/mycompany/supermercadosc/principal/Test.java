/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.supermercadosc.principal;

import com.mycompany.supermercadosc.controladores.ProductoJpaController;
import com.mycompany.supermercadosc.controladores.exceptions.NonexistentEntityException;
import com.mycompany.supermercadosc.entidades.Producto;
import java.math.BigDecimal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author xavxg
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         //TOMA LOS PARAMETROS ESTABLECIDOS DE LA CADENA DE CONEXIÓN 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("practicabdd");
        
        // LA CLASE CONTROLADORA RECIBE DE PARAMETRO UNA CADENA DE CONEXIÓN
        ProductoJpaController pjc = new ProductoJpaController(emf);
        
        //CREAR PRODUCTO
        Producto p = new Producto();
        p.setNombre("AUDIFONOS");
        Double d1 = 10.99;
        BigDecimal bd1 = BigDecimal.valueOf(d1.doubleValue());
        p.setPrecio(bd1);
        pjc.create(p);
        
        
        
        //EDITAR PRODUCTO
        Producto ep = new Producto();
        ep.setCodigo(1);
        ep.setNombre("CARTUCHERA");
        Double epl = 12.50;
        BigDecimal bdepl = BigDecimal.valueOf(epl.doubleValue());
        ep.setPrecio(bdepl);        
        try {
            //pjc.edit(ep);
        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        //ELIMINAR PRODUCTO
        /*try {
            pjc.destroy(1);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        
        //MOSTRAR PRODUCTO
        Producto np = pjc.findProducto(3);
        System.out.println(np.getNombre());
        
    }
    
}
