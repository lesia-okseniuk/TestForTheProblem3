package main;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();

        double start = 0.0;
        double end = 2.0;
        double step = 0.002;
        double[] x = main.createX(start, end, step);
        double[] y = main.createY(x);
        System.out.println("Array x: " + Arrays.toString(x));
        System.out.println("Array y: " + Arrays.toString(y));
        System.out.println("Index of the maximum number in the x array: " + main.numOfMaxX(x));
        System.out.println("Index of the maximum number in the y array: " + main.numOfMaxY(y));
        System.out.println("Index of the minimum number in the x array: " + main.numOfMinX(x));
        System.out.println("Index of the minimum number in the y array: " + main.numOfMinY(y));
        System.out.println("Sum of array x: " + main.sumX(x));
        System.out.println("Sum of array y: " + main.sumY(y));
        System.out.println("Arithmetic mean of array x: " + main.arithmeticMeanX(x));
        System.out.println("Arithmetic mean of array y: " + main.arithmeticMeanY(y));
    }


    double a = 2.7;
    double b = -0.3;
    double c = 4;
    double EPS = 1e-9;


    public double calcF(double x) { // Обчислення значення y відповідно до зазначених умов

        if (x < 1.4) {
            return a * x * x + b * x + c;
        }
        if (Math.abs(x - 1.4) < EPS) { // Єдине, що в мене спрацювало для порівняння неточно обчисленого x з 1,4
            return a / x + Math.sqrt(x * x + 1);
        } else return (a + b * x) / Math.sqrt(x * x + 1);
        }

    public int calcSteps(double start, double end, double step) { // Підрахунок кількості кроків
    return (int) Math.round((end - start) / step) + 1;
    }

    public double[] createX (double start, double end, double step) { // Створення і заповнення масиву x-ів
        double[] x = new double[calcSteps(start, end, step)];
        for (int i = 0; i < x.length; i++) {
            x[i] = start + i * step;
        }
        return x;
    }

    public double[] createY (double[] x) { // Створення і заповнення масиву y-ів
        double[] y = new double[x.length];
        for (int i = 0; i < y.length; i++) {
            y[i] = calcF(x[i]);
        }
        return y;
    }

    public double numOfMaxX (double[] x) { // Індекс мaксимального числа в масиві x-ів
        double maxX = x[0];
        int numMaxX = 0;
        for (int i = 1; i < x.length; i++) {
            if (x[i] > maxX) {
                maxX = x[i];
                numMaxX = i;
            }
        }
        System.out.println("Maximum number in the x array: " + maxX + " with index " + numMaxX);
        return numMaxX;
    }

    public double numOfMaxY (double[] y) { // Індекс мaксимального числа в масиві y-ів
        double maxY = y[0];
        int numMaxY = 0;
        for (int i = 1; i < y.length; i++) {
            if (y[i] > maxY) {
                maxY = y[i];
                numMaxY = i;
            }
        }
        System.out.println("Maximum number in the y array: " + maxY + " with index " + numMaxY);
        return numMaxY;
    }

    public double numOfMinX (double[] x) { // Індекс мінімального числа в масиві x-ів
        double minX = x[0];
        int numMinX = 0;
        for (int i = 1; i < x.length; i++) {
            if (x[i] < minX) {
                minX = x[i];
                numMinX = i;
            }
        }
        System.out.println("Minimum number in the x array: " + minX + " with index " + numMinX);
        return numMinX;
    }

    public double numOfMinY (double [] y) { // Індекс мінімального числа в масиві y-ів
        double minY = y[0];
        int numMinY = 0;
        for (int i = 1; i < y.length; i++) {
            if (y[i] < minY) {
                minY = y[i];
                numMinY = i;
            }
        }
        System.out.println("Minimum number in the y array: " + minY + " with index " + numMinY);
        return numMinY;
    }

    public double sumX (double[] x) { // Сума елементів масиву x
        double sumX = 0;
        for (int i = 0; i < x.length; i++) {
            sumX += x[i];
        }
        return sumX;
    }

    public double sumY (double[] y) { // Сума елементів масиву y
        double sumY = 0;
        for (int i = 0; i < y.length; i++) {
            sumY += y[i];
        }
        return sumY;
    }

    public double arithmeticMeanX (double[] x) { // Середнє арифметичне елементів масиву x
        double arithmeticMeanX = sumX(x) / x.length;
        return arithmeticMeanX;
    }

    public double arithmeticMeanY (double[] y) { // Середнє арифметичне елементів масиву y
        double arithmeticMeanY = sumY(y) / y.length;
        return arithmeticMeanY;
    }


}

