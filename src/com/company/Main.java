package com.company;

import java.util.Scanner;

public class Main { // 1-D Array

    public static double getAverage() {
        Scanner input = new Scanner(System.in);
        double average = 0;
        int sum = 0, count = 0;
        System.out.println("Enter grade of satisfaction:");
        int grade = input.nextInt();
        while (grade != 0) {
            count++;
            sum += grade;
            System.out.println("Enter grade of satisfaction:");
            grade = input.nextInt();
        }
        if (count < 100) {
            return average;
        } else {
            return sum / count;
        }
    }

    public static boolean goodDay(double[] a) {
        boolean month1 = false;
        for (int i=0; i<12; i++) {
            if (a[i] > 8) {
                if (!month1) {
                    month1 = true;
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    public static void Q2() {
        double[] months = new double[12];
        for (int i=0; i<12; i++) {
            months[i] = getAverage();
        }
        if (goodDay(months)) {
            System.out.println("The workers are eligible for a fun day !");
        } else {
            System.out.println("The workers are not eligible for a fun day");
        }
    }

    public static int[] allowed(double age) {
        int[] allow = new int[3];
        int level;
        if (age < 12) {
            level = 0;
        } else if (age < 16) {
            level = 1;
        } else if (age < 18) {
            level = 2;
        } else {
            level = 3;
        }
        for (int i=0; i<3; i++) {
            if (i+1 <= level) {
                allow[i] = 1;
            } else {
                allow[i] = 0;
            }
        }
        return allow;
    }

    public static void Q3() {
        Scanner input = new Scanner(System.in);
        int[] visitor;
        int[] total = new int[3];
        for (int i=0; i<3; i++) {
            total[i] = 0;
        }
        System.out.println("Enter age of visitor:");
        double age = input.nextDouble();
        while (age != 0) {
            visitor = allowed(age);
            for (int i=0; i<3; i++) {
                total[i] += visitor[i];
            }
            System.out.println("Enter age of visitor:");
            age = input.nextDouble();
        }
        System.out.println("Visitors that eligible to use sauna: "+ total[2]);
        System.out.println("Visitors that eligible to use jacuzzi: "+ total[1]);
        System.out.println("Visitors that eligible to use springboard: "+ total[0]);
    }

    public static int firstNeg(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }

    public static int negSequance(int[] arr) {
        int neglen = 0;
        int place = firstNeg(arr);
        if (place < 0) {
            return neglen;
        } else {
            for (int i=place; i<arr.length; i++) {
                if (arr[i] < 0) {
                    neglen++;
                } else {
                    return neglen;
                }
            }
        }
        return neglen;
    }

    public static void Q4() {
        Scanner input = new Scanner(System.in);
        int NUM_OF_ARRAYS = 672;
        int LENGTH_OF_ARRAY = 83;
        int[] arr = new int[LENGTH_OF_ARRAY];
        int[] count = new int[LENGTH_OF_ARRAY+1];
        for (int i=0; i<LENGTH_OF_ARRAY+1; i++) {
            count[i] = 0;
        }
        for (int j=0; j<NUM_OF_ARRAYS; j++) {
            for (int i=0; i<LENGTH_OF_ARRAY; i++) {
                System.out.println("Enter number:");
                arr[i] = input.nextInt();
            }
            count[negSequance(arr)]++;
        }
        for (int i=1; i<LENGTH_OF_ARRAY+1; i++) {
            System.out.println("There are "+ count[i] + " arrays with negative sequence of " + i);
        }
        System.out.println("There are "+ count[0] + " arrays with no negative sequence at all!");
    }

    public static int reduction (int num, int students) {
        int red1 = 0, red2;
        if (num > 6) {
            red1 = 100;
        }
        red2 = 40 * students;
        if (red2 > red1) {
            return red2;
        } else {
            return red1;
        }
    }

    public static int sumReductions (int n) {
        Scanner input = new Scanner(System.in);
        int sum = 0, num, students;
        for (int i=0; i<n; i++) {
            System.out.println("Enter number of persons in family:");
            num = input.nextInt();
            System.out.println("Enter number of students in family:");
            students = input.nextInt();
            sum += reduction(num, students);
        }
        return sum;
    }

    public static void Q5() {
        Scanner input = new Scanner(System.in);
        int CITIES = 10;
        int[] rdc = new int[CITIES];
        for (int i=0; i<CITIES; i++) {
            rdc[i] = 500;
        }
        int families;
        for (int i=0; i<CITIES; i++) {
            System.out.println("Enter number of families in city "+i+":");
            families = input.nextInt();
            if (sumReductions(families) > rdc[i]) {
                System.out.println("In city "+i+" the reduction is higher then allowance");
            }
        }
    }

    public static int above(int[] arr, int num) {
        int sum = 0;
        for (int i=0; i<arr.length; i++) {
            sum += arr[i];
            if (sum > num) {
                return i;
            }
        }
        return -1;
    }

    public static void Q8() {
        int[] arr1 = {3,-2,6,2,1,3};
        System.out.println(above(arr1,9));
        int[] arr2 = {1,2,-2,0,7,3};
        System.out.println(above(arr2,11));
    }

    public static void main(String[] args) {
        Q2();
        Q3();
        Q4();
        Q5();
        Q8();
    }
}
