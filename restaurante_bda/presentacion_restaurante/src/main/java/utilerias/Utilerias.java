/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilerias;

import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import modulo_productos.RegistrarProductoFrm;

/**
 *
 * @author rocha
 */
public class Utilerias {

    public static void actualizarListaBuscador(JList<String> list, DefaultListModel<String> listModel, List<String> elementos, JScrollPane scrollPane, JTextField buscador) {
        String filtro = buscador.getText().trim();
        
        listModel.clear(); // Limpiar la lista

        // Filtrar y agregar solo los elementos que coinciden con el texto de búsqueda
        if (filtro.isBlank()) {
            // Si el texto está vacío, mostrar todos los elementos
            elementos.forEach(listModel::addElement);
        } else {
            // Filtrar y agregar solo los que coinciden con el texto de búsqueda
            elementos.stream()
                    .filter(elemento -> elemento.toLowerCase().contains(filtro.toLowerCase()))
                    .forEach(listModel::addElement);
        }

        list.setModel(listModel); // Actualizar el modelo de la lista

        // Verificar si hay elementos en la lista
        if (listModel.getSize() > 0) {
            // Si hay resultados, mostrar el JScrollPane
            scrollPane.setVisible(true);
        } else {
            // Si no hay resultados, ocultar el JScrollPane
            scrollPane.setVisible(false);
        }
    }
    
    public static void agregarElementoDesdeLista(ListSelectionEvent evt, JList<String> lista, DefaultTableModel tableModel, Object caller) {
        if (evt.getValueIsAdjusting()) {
            return;
        }

        String elementoSeleccionado = lista.getSelectedValue();
        if (elementoSeleccionado == null || elementoSeleccionado.isEmpty()) {
            return;
        }

        // Buscar el elemento en la tabla y actualizar
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).equals(elementoSeleccionado)) {
                return;
            }
        }

        if (caller instanceof RegistrarProductoFrm) { // CAMBIENLO AL NOMBRE DE OTRO FORM
            // Comportamiento específico para registrar producto
            tableModel.addRow(new Object[]{elementoSeleccionado, "-", 1, "+"});
        } 
    }
    
    public static void agregarElementoDesdeBoton(JList<String> lista, JComboBox combobox, DefaultTableModel tableModel, Object caller) {
        String elementoSeleccionado = lista.getSelectedValue();
        
        if (elementoSeleccionado == null || elementoSeleccionado.isEmpty()) {
            return;
        }

        // Buscar el elemento en la tabla y actualizar
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            if (tableModel.getValueAt(i, 0).equals(elementoSeleccionado)) {
                return;
            }
        }

        if (caller instanceof RegistrarProductoFrm) {
            // Comportamiento específico para registrar producto
            tableModel.addRow(new Object[]{elementoSeleccionado, combobox.getSelectedItem(), "-", 1, "+"});
        }
    }
}
