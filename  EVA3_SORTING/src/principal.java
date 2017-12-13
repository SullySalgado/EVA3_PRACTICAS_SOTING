
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author saul_
 */
public class principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int iArraySs[] = new int[10];
        int iArrayIs[] = new int[10];
        int iArrayBs[] = new int[10];
        int iArrayQs[] = new int[10];
        for (int i = 0; i < iArraySs.length; i++) {
            iArraySs[i] = ((int) (Math.random() * 100) + 1);
            iArrayIs[i] = iArraySs[i];
            iArrayBs[i] = iArraySs[i];
            iArrayQs[i] = iArraySs[i];
        }

        for (int i : iArraySs) {
            System.out.print("[" + i + "]");
        }

        System.out.println(" " + "\n Selection Sort");
        selectionSort(iArraySs);

        System.out.println("" + "\n insertion Sort");

        insertionSort(iArrayIs);

        System.out.println(" " + " \n bubbleSort");

        bubbleSort(iArrayBs);
        
        System.out.println(" " + " \n QuickSort");
        principal.quickSort(iArrayQs, 0, iArrayQs.length - 1);
        for (int k : iArrayQs) {
            System.out.print("[" + k + "]");
        }

        System.out.println(" " + "\nSearch Binary");
        Scanner ScBuscar = new Scanner(System.in);
        System.out.println("VALOR A BUSCAR");
        int iVal = ScBuscar.nextInt();
        int iResu = binarySearch(iArraySs, iVal);
        System.out.println(iResu);
        System.out.println("Busqueda Secuencial");
        iResu = Serch(iArraySs, iVal);
        System.out.println(iResu);

    }

    public static void selectionSort(int[] iArraySs) {
        for (int i = 0; i < iArraySs.length; i++) {
            int iMin = i;
            for (int j = i + 1; j < iArraySs.length; j++) {
                if (iArraySs[j] < iArraySs[iMin]) {
                    iMin = j;
                }

            }
            int iTemp = iArraySs[iMin];
            iArraySs[iMin] = iArraySs[i];
            iArraySs[i] = iTemp;

        }

        for (int i : iArraySs) {
            System.out.print("[" + i + "]");
        }
    }

    public static void insertionSort(int[] iArrayIs) {
        for (int i = 1; i < iArrayIs.length; i++) {
            int iTemp = iArrayIs[i];
            int j = i - 1;
            while (j >= 0 && iArrayIs[j] < iArrayIs[i]) {
                iTemp = iArrayIs[i];
                iArrayIs[i] = iArrayIs[j];
                iArrayIs[j] = iTemp;
                i=j;
                j--;
            }
        }
        for (int k : iArrayIs) {
            System.out.print("[" + k + "]");

        }
    }

    public static void bubbleSort(int[] iArrayBs) {
        boolean swapped = true;
        int j = 0;
        int tmp;
        while (swapped) {
            swapped = false;
            j++;
            for (int i = 0; i < iArrayBs.length - j; i++) {
                if (iArrayBs[i] > iArrayBs[i + 1]) {
                    tmp = iArrayBs[i];
                    iArrayBs[i] = iArrayBs[i + 1];
                    iArrayBs[i + 1] = tmp;
                    swapped = true;
                }
            }
        }

        for (int i : iArrayBs) {
            System.out.print("[" + i + "]");
        }

    }
    

    public static void quickSort(int[] iArrayQs, int izquierda, int derecha) {
        int pivote = iArrayQs[izquierda];
        int i = izquierda;
        int j = derecha;
        int auxIntercambio;
        while (i < j) {
            while (iArrayQs[i] <= pivote && i < j) {
                i++;
            }
            while (iArrayQs[j] > pivote) {
                j--;
            }
            if (i < j) {
                auxIntercambio = iArrayQs[i];
                iArrayQs[i] = iArrayQs[j];
                iArrayQs[j] = auxIntercambio;
            }
        }
        iArrayQs[izquierda] = iArrayQs[j];
        iArrayQs[j] = pivote;
        if (izquierda < j - 1) {
            quickSort(iArrayQs, izquierda, j - 1);
        }
        if (j + 1 < derecha) {
            quickSort(iArrayQs, j + 1, derecha);
        }
    }

    public static int binarySearch(int[] iArraySs, int iValorBuscar) {
        return binSearchRec(iArraySs, iValorBuscar, 0, iArraySs.length - 1);
    }

    public static int binSearchRec(int[] iArraySs, int iValorBuscar, int iLow, int iHigh) {
        int iPos = -1;
        int iMid = iLow + ((iHigh - iLow) / 2);

        if (iLow <= iHigh) {

            if (iValorBuscar == iArraySs[iMid]) {
                iPos = iMid;
            } else if (iValorBuscar < iArraySs[iMid]) {
                iPos = binSearchRec(iArraySs, iValorBuscar, iLow, iMid - 1);
            } else if (iValorBuscar > iArraySs[iMid]) {
                iPos = binSearchRec(iArraySs, iValorBuscar, iMid + 1, iHigh);
            }

        }
        return iPos;
    }

    public static int Serch(int[] iArraySs, int iValorBuscar) {
        int iPos = -1;
        for (int i = 0; i < 10; i++) {
            if (iArraySs[i] == iValorBuscar) {
                iPos = i;
            }
        }
        return iPos;
    }

}
