package TipoCola;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Main implements Constants {
    public static void main(String... args) {
        List<Cashier> cashiers = new ArrayList<>();
        ColaLineal controller = new ColaLineal();

        for (int i = 0; i < CASHIERS; i++) {
            cashiers.add(new Cashier(i + 1));
        }

        while (true) {
            int option = 0;
            try {
                option = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción\n" +
                        "1 - Solicitar Turno\n" +
                        "2 - Atender\n" +
                        "3 - Resumen de atención\n" +
                        "4 - Salir\n"
                ));
            } catch (NumberFormatException ignore) {

            }

            switch (option) {
                case 1:
                    try {
                        int length = controller.fin;
                        if (length < TURNS - 1) {
                            String turn = "A" + (length + 2);
                            JOptionPane.showMessageDialog(null, "Su turno es " + turn);
                            System.out.println("Debe esperar los siguientes turnos:");
                            Object[] x = controller.listaCola;
                            for (int i = controller.frente; i <= controller.fin; i++) {
                                System.out.println(x[i]);
                            }
                            controller.insertar(turn);
                            System.out.println();
                        } else {
                            JOptionPane.showMessageDialog(null, "Solo había " + TURNS + " turnos el día de hoy");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    try {
                        Object turn = controller.quitar();
                        int cashier = Integer.parseInt(JOptionPane.showInputDialog("Ingrese número de cagero, hay " + cashiers.size() + " disponibles"));
                        JOptionPane.showMessageDialog(null, "Atenderá al turno " + turn);
                        cashiers.get(cashier - 1).setAttended(String.valueOf(turn));
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "No hay turnos para atender");
                    }
                    break;

                case 3:
                    System.out.println("Resumen");
                    for (Cashier x : cashiers) {
                        System.out.println("Cajero " + x.getNumber() + " atendió");
                        for (String y : x.getAttended()) {
                            System.out.println("     " + y);
                        }
                    }
                    break;

                case 4:
                    System.exit(1000);
            }
        }
    }
}
