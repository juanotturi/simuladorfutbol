package com.project.simuladorfutbol.factory;

import com.project.simuladorfutbol.model.ProbabilityMatrix;

import java.util.HashMap;
import java.util.Map;

public class ProbabilityMatrixFactory {

    public static ProbabilityMatrix createMatrix() {
        // Mapa externo: equipo A (fila)
        // Mapa interno: equipo B (columna)
        Map<Integer, Map<Integer, Integer>> matrix = new HashMap<>();

        // ------------------------------------------------------
        // Fila: 100-84 (Bucket del equipo A)
        // Columnas: Buckets del equipo B
        Map<Integer, Integer> rowA100 = new HashMap<>();
        rowA100.put(100, 0);
        rowA100.put(83, 2);
        rowA100.put(78, 4);
        rowA100.put(76, 6);
        rowA100.put(74, 8);
        matrix.put(100, rowA100);

        // ------------------------------------------------------
        // Fila: 83-79 (Bucket del equipo A)
        Map<Integer, Integer> rowA83 = new HashMap<>();
        rowA83.put(100, -2);
        rowA83.put(83, 0);
        rowA83.put(78, 2);
        rowA83.put(76, 4);
        rowA83.put(74, 6);
        matrix.put(83, rowA83);

        // ------------------------------------------------------
        // Fila: 78-77 (Bucket del equipo A)
        Map<Integer, Integer> rowA78 = new HashMap<>();
        rowA78.put(100, -4);
        rowA78.put(83, -2);
        rowA78.put(78, 0);
        rowA78.put(76, 2);
        rowA78.put(74, 4);
        matrix.put(78, rowA78);

        // ------------------------------------------------------
        // Fila: 76-75 (Bucket del equipo A)
        Map<Integer, Integer> rowA76 = new HashMap<>();
        rowA76.put(100, -6);
        rowA76.put(83, -4);
        rowA76.put(78, -2);
        rowA76.put(76, 0);
        rowA76.put(74, 2);
        matrix.put(76, rowA76);

        // ------------------------------------------------------
        // Fila: 74-73 (Bucket del equipo A)
        Map<Integer, Integer> rowA74 = new HashMap<>();
        rowA74.put(100, -8);
        rowA74.put(83, -6);
        rowA74.put(78, -4);
        rowA74.put(76, -2);
        rowA74.put(74, 0);
        matrix.put(74, rowA74);

        // ------------------------------------------------------
        // Nota: para la versión completa seguirías con las demás filas

        return new ProbabilityMatrix(matrix);
    }
}
