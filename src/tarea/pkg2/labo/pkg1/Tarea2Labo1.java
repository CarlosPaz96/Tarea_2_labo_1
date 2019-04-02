/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea.pkg2.labo.pkg1;


import java.util.Scanner;
import java.util.Date;
import java.util.LinkedList;



//import java.util.Date;

/**
 *
 * @author Hp
 */
public class Tarea2Labo1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner op=new Scanner(System.in);
        Scanner op2=new Scanner(System.in);
        LinkedList<Producto> Listaa=new LinkedList<Producto>();//guardara todos los objetos de tipo producto
        Cliente cliente=new Cliente();//objeto tipo cliente
        float total=0;
        float subT=0;
        Date fecha=new Date();//recibe la fecha actual con la hora
        int opcion;
        boolean flag=true;//bandera para parar bucle del menu
        
        while(flag==true){
        System.out.println("----------------------------------------------------");
        System.out.println("|                       Menu                       |");
        System.out.println("----------------------------------------------------");
        System.out.println("|           1. Ingresar Producto                   |");
        System.out.println("|           2. Lista de productos vendidos         |");
        System.out.println("|           3. Calcular total a pagar              |");
        System.out.println("|           4. Generar Factura                     |");
        System.out.println("|           5. Salir                               |");
        System.out.println("----------------------------------------------------");
        System.out.println("->  Ingrese opcion:");
        opcion=op.nextInt();
        if (opcion>0&&opcion<6) {
                switch (opcion){
                    case 1: System.out.println("opcion 1");
                            System.out.println("-------------------------------------------------------");
                            System.out.println("->      Cuantos productos decea ingresar?:");
                            int opciones=op.nextInt();
                            System.out.println("-------------------------------------------------------");
                            for (int i = 0; i < opciones; i++) {
                                Listaa=Pedir(op,op2,cliente,Listaa);//pide y guarda los objetos de tipo producto en la lista
                            }
                           pedirCliente(cliente,op,op2);//pide la informacion del cliente
                           break;
                    case 2: System.out.println("opcion 2");
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                            System.out.println("|            Lista Productos Seleccionados           |");
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                            if (Listaa.size()==0) {
                                System.out.println("             No a escogido productos aun              ");
                            }else{
                            for (int i = 0; i < Listaa.size(); i++) {//imprime los elementos de la lista
                            System.out.println("Producto: "+Listaa.get(i).getNombre()+"   Cantidad: "+Listaa.get(i).getCantidad()+"     Precio: $"+Listaa.get(i).getPrecio()+"      Tipo: "+Listaa.get(i).getTipo());
                            }//for
                            }//else
                            System.out.println("------------------------------------------------------");
                            break;
                    case 3: System.out.println("opcion 3");
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                            System.out.println("|                   Calculo del Total                 |");
                            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
                            for (int i = 0; i < Listaa.size(); i++) {
                                subT=Listaa.get(i).getCantidad()*Listaa.get(i).getPrecio();//formula:Cantidad por el precio del producto= subtotal
                                total=total+subT;//Total es la suma de los subtotales
                            }
                            System.out.println("                      $"+total);
                            System.out.println("******************************************************");
                            break;
                    case 4: System.out.println("opcion 4");
                            subT=0;
                            System.out.println("------------------------FACTURA-------------------------");
                            System.out.println("                    "+cliente.getNombre()+" "+cliente.getApellido());
                            System.out.println("                "+fecha);//genera la fecha usando java.util.Date
                            System.out.println("--------------------------------------------------------");
                            for (int i = 0; i < Listaa.size(); i++) {
                                subT=subT+Listaa.get(i).getCantidad()*Listaa.get(i).getPrecio();//genera desde 0 el subTotal, no se ocupa el anterior porque ya viene ocupado, por eso se reinicia
                                System.out.println("    "+Listaa.get(i).getNombre()+"         "+Listaa.get(i).getCantidad()+"           $"+Listaa.get(i).getPrecio()+"         $"+subT);
                                subT=0;
                            }
                            System.out.println("-------------------------------------------------------");
                            System.out.println("                                TOTAL: $"+total);
                            System.out.println("                   Telefono:"+cliente.getTelefono());
                            System.out.println("-------------------------------------------------------");
                            break;
                    case 5: System.out.println("opcion 5");flag=false;break;
            }//cierra el switch
            }//cierra el if
        else{System.out.println("*************************Opcion invalida*************************");}//si se escoje una opcion distinta imprime esto
        }//Cierra el while   
    }//cierra el main
    
    public static LinkedList Pedir(Scanner op,Scanner op2,Cliente c,LinkedList Lista){
            Producto producto=new Producto();
            /*el producto se crea desde adentro de la funcion para evitar que ingrese el mismo numero de memoria,
             si se imprime desde afuera envia un mismo # de memoria y todos los elementos de la lista se hacen el mismo*/
            System.out.println("------------------------------------------------");
            System.out.println("->  Ingrese producto:");
            String Pro=op2.nextLine();
            producto.setNombre(Pro);
            System.out.println("->  Precio: ");
            producto.setPrecio(op.nextFloat());
            System.out.println("->  Tipo: ");
            producto.setTipo(op2.nextLine());
            System.out.println("->  Cantidad:");
            producto.setCantidad(op.nextInt());
            op.nextLine();
            Lista.add(producto);
            return Lista;
        }//funcion
    private static void pedirCliente(Cliente c, Scanner op,Scanner op2){
        System.out.println("*****************************************************");
        System.out.println("->  Nombre del cliente:");
        c.setNombre(op2.nextLine());
        System.out.println("->  Apellido: ");
        c.setApellido(op2.nextLine());
        System.out.println("->  Telefono:");
        c.setTelefono(op.nextLine());
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("|          Informacion Guardada con Exito           |");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");  
    }
}
