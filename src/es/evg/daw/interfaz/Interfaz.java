package es.evg.daw.interfaz;

import java.awt.Color;
import java.awt.Font;

import javax.swing.border.LineBorder;

/**
 * Interfaz creada para los Visuales principales y repetidos en la clase Visual
 */
public interface Interfaz {

	final static Color colorfondo = new Color(1,185,255,255);
	final static Font imaginFuente = new Font("Tahoma", Font.BOLD, 20);
	final static Font imaginFuente2 = new Font("Tahoma", Font.PLAIN, 20);
	final static Font imaginFuente3 = new Font("Tahoma", Font.PLAIN, 15);
	final static LineBorder imaginBorde = new LineBorder(Color.black);
	
}
