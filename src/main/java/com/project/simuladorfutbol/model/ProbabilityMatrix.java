package com.project.simuladorfutbol.model;

import java.util.Map;

public class ProbabilityMatrix {

    /**
     * Representa la tabla de probabilidades.
     * Clave externa: bucket del equipo A (fila)
     * Clave interna: bucket del equipo B (columna)
     * Valor: índice del vector (-17 a +17)
     */
    private final Map<Integer, Map<Integer, Integer>> matrix;

    public ProbabilityMatrix(Map<Integer, Map<Integer, Integer>> matrix) {
        this.matrix = matrix;
    }

    /**
     * Devuelve el valor del vector para un enfrentamiento dado.
     *
     * @param scoreA Puntaje del equipo A
     * @param scoreB Puntaje del equipo B
     * @return índice del vector (-17 a +17)
     */
    public int getVectorValue(int scoreA, int scoreB) {
        int bucketA = bucketize(scoreA);
        int bucketB = bucketize(scoreB);

        // Respetar filas = A, columnas = B
        Map<Integer, Integer> row = matrix.get(bucketA);
        if (row == null) {
            return 0;  // Default si no existe fila
        }
        return row.getOrDefault(bucketB, 0);
    }

    /**
     * Clasifica el score en su bucket correspondiente.
     *
     * @param score Puntaje bruto (0-100)
     * @return bucket (ejemplo 100, 83, 78, etc.)
     */
    private int bucketize(int score) {
        if (score >= 84) return 100;
        if (score >= 79) return 83;
        if (score >= 77) return 78;
        if (score >= 75) return 76;
        if (score >= 73) return 74;
        if (score >= 71) return 72;
        if (score >= 68) return 70;
        if (score >= 65) return 67;
        if (score >= 62) return 64;
        if (score >= 59) return 61;
        if (score >= 56) return 58;
        if (score >= 53) return 55;
        if (score >= 50) return 52;
        if (score >= 47) return 49;
        if (score >= 44) return 46;
        if (score >= 41) return 43;
        if (score >= 39) return 40;
        return 38;
    }
}
