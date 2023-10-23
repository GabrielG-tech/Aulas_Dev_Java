package org.example;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Crie uma série de dados XY para a função f(x) = x
            XYSeries series = new XYSeries("f(x) = -f(x)");
            for (double x = 1; x <= 10; x += 0.1) {
                double y;
                y = Math.sin(x); // Math.pow((x - 2), 2) + Math.pow((y - 2), 2) = 1 -> circulo
                series.add(x, y);
            }

            // Crie um conjunto de dados com a série XY
            XYSeriesCollection dataset = new XYSeriesCollection((series));

            // Crie o gráfico
            JFreeChart chart = ChartFactory.createXYLineChart(
                    "Gráfico da Função f(x) = -f(x)", // Título
                    "x", // Rótulo do eixo X
                    "y", // Rótulo do eixo Y
                    dataset, // Conjunto de dados
                    PlotOrientation.VERTICAL,
                    true, // Mostrar legenda
                    true, // Usar tooltips
                    false // Usar URLs
            );

            // Crie uma janela para exibir o gráfico
            JFrame frame = new JFrame("Gráfico da Função");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(new ChartPanel(chart));
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}