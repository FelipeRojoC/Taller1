//Importar Libreria StdLib
import edu.princeton.cs.stdlib.StdDraw;

import java.awt.*;

public class Main {
    public static void main(String[] args) {

        //Rango del lienzo
        double minimo = -1.0;
        double maximo = 1.0;

        //Establecer tamaño del lienzo
        StdDraw.setXscale(minimo,maximo);
        StdDraw.setYscale(minimo,maximo);

        //Buffering
        StdDraw.enableDoubleBuffering();

        //Generar un numero random entre 0 y 0.05 para la velocidad
        double minimoVelocidad = 0;
        double maximoVelocidad = 0.05;
        double randomVelocidad = minimoVelocidad + (maximoVelocidad-minimoVelocidad) * Math.random();

        //Crear lineas
        crearLinea(minimo,maximo,randomVelocidad);
    }

    private static double crearLinea(double minimo, double maximo, double randomVelocidad) {

        //Asignar velocidad de las lineas
        double x0Velocidad = randomVelocidad;
        double y0Velocidad = randomVelocidad;
        double x1Velocidad = randomVelocidad;
        double y1Velocidad = randomVelocidad;

        //Definir seis colores
        Color[] colores = {Color.BLACK, Color.RED, Color.BLUE, Color.ORANGE, Color.GREEN, Color.CYAN};

        //Definir una linea al azar
        double x0 = minimo + (maximo-minimo) * Math.random();
        double y0 = minimo + (maximo-minimo) * Math.random();

        double x1 = minimo + (maximo-minimo) * Math.random();
        double y1 = minimo + (maximo-minimo) * Math.random();


        while (true){

            //Condiciones para colision
            if (Math.abs(x0+x0Velocidad)>1){
                x0Velocidad = -x0Velocidad;
            }
            if (Math.abs(x1+x1Velocidad)>1){
                x1Velocidad = -x1Velocidad;
            }
            if (Math.abs(y0+y0Velocidad)>1){
                y0Velocidad = -y0Velocidad;
            }
            if (Math.abs(y1+y1Velocidad)>1){
                y1Velocidad = -y1Velocidad;
            }

            //Actualizacion de posicion
            x0 += x0Velocidad;
            x1 += x1Velocidad;
            y0 += y0Velocidad;
            y1 += y1Velocidad;

            //Limpiar Fondo
            StdDraw.clear();

            //Setear color, dibujar linea y mostrar linea
            StdDraw.setPenColor(colores[0]);
            StdDraw.line(x0,y0,x1,y1);
            StdDraw.setPenColor(colores[1]);
            StdDraw.line(x0,y0+0.015,x1,y1+0.015);
            StdDraw.setPenColor(colores[2]);
            StdDraw.line(x0,y0+0.030,x1,y1+0.030);
            StdDraw.setPenColor(colores[3]);
            StdDraw.line(x0,y0+0.045,x1,y1+0.045);
            StdDraw.setPenColor(colores[4]);
            StdDraw.line(x0,y0+0.060,x1,y1+0.060);
            StdDraw.setPenColor(colores[5]);
            StdDraw.line(x0,y0+0.075,x1,y1+0.075);

            StdDraw.show();
        }
    }
}