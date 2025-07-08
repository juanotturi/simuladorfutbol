package com.project.simuladorfutbol.model;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

@Component
public class ExactResultMatrix {

    private final Map<Integer, Map<Integer, Integer>> matrix;

    public ExactResultMatrix() {
        this.matrix = new HashMap<>();
        loadMatrixFromCsv();
    }

    /**
     * Devuelve el resultadoCode correspondiente al vectorIndex y random1to100
     */
    public int getResultCode(int vectorIndex, int random1to100) {
        Map<Integer, Integer> row = matrix.get(vectorIndex);
        if (row == null) {
            return 0;
        }
        return row.getOrDefault(random1to100, 0);
    }

    /**
     * Lee el archivo CSV desde resources y llena la matriz.
     */
    private void loadMatrixFromCsv() {
        try {
            // Busca el archivo en el classpath (resources)
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream("result_matrix.csv");
            if (inputStream == null) {
                throw new IllegalStateException("No se encontró result_matrix.csv en resources");
            }

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            while ((line = reader.readLine()) != null) {
                // Split por coma
                String[] tokens = line.trim().split(",");

                // El primer valor es el vectorIndex
                int vectorIndex = Integer.parseInt(tokens[0]);

                // Los 100 valores siguientes
                Map<Integer, Integer> row = new HashMap<>();
                for (int i = 1; i <= 100; i++) {
                    row.put(i, Integer.parseInt(tokens[i]));
                }

                // Lo metemos en la matriz
                matrix.put(vectorIndex, row);
            }

            reader.close();
        } catch (Exception e) {
            throw new RuntimeException("Error al cargar result_matrix.csv", e);
        }
    }
}
