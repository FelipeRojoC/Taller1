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
        crearLinea(minimo,maximo);
    }

    private static double crearLinea(double minimo, double maximo) {

        /**
         *Generar velocidad al azar
         *la velocidad al azar va muy rapido por eso lo configure
         *para que fuera mas lento pero el codigo lo dejo comentado
         */
        double x0Velocidad = 0.005;//minimo + (maximo-minimo) * Math.random();
        double y0Velocidad = 0.005;//minimo + (maximo-minimo) * Math.random();
        double x1Velocidad = 0.005;//minimo + (maximo-minimo) * Math.random();
        double y1Velocidad = 0.005;//minimo + (maximo-minimo) * Math.random();

        //Definir seis colores
        Color[] colores = {Color.BLACK, Color.RED, Color.BLUE, Color.ORANGE, Color.GREEN, Color.PINK};

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
            StdDraw.setPenColor(colores[(int) (Math.random()*colores.length)]);

            StdDraw.line(x0,y0,x1,y1);
            StdDraw.line(x0,y0+0.015,x1,y1+0.015);
            StdDraw.line(x0,y0+0.030,x1,y1+0.030);
            StdDraw.line(x0,y0+0.045,x1,y1+0.045);
            StdDraw.line(x0,y0+0.060,x1,y1+0.060);
            StdDraw.line(x0,y0+0.075,x1,y1+0.075);

            StdDraw.show();
        }
    }
}