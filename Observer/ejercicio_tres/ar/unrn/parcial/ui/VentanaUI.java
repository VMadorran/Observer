package ar.unrn.parcial.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import ar.unrn.parcial.modelo.Calculador;
import ar.unrn.parcial.modelo.Fecha;
import ar.unrn.parcial.modelo.UI;

public class VentanaUI extends JFrame implements UI {
	private JPanel contentPane;
	private JLabel lblCantidadRemeras;
	private JTextField txtCantidadRemeras;
	private JLabel lblCorreo;
	private JTextField txtCorreo;
	private JComboBox<String> comboBox;
	private JButton btnConfirmar;
	private JButton btnConsultar;
	private Calculador calculador;
	private Fecha fecha;

	public VentanaUI(Calculador calculador, Fecha fecha) {

		this.calculador = calculador;
		this.fecha = fecha;
		var frame = new JFrame("Pedido de remeras");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 451, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		formarElementos();
		layout();
		frame.setVisible(true);

	}

	@Override
	public void formarElementos() {
		// TODO Auto-generated method stub
		lblCantidadRemeras = new JLabel("Cantidad de remeras:");
		txtCantidadRemeras = new JTextField();
		txtCantidadRemeras.setColumns(10);
		lblCorreo = new JLabel("Correo:");
		txtCorreo = new JTextField();
		txtCorreo.setColumns(10);
		btnConfirmar = new JButton("Confirmar");

		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicion = comboBox.getSelectedIndex();
				btnConfirmar.setEnabled(false);
				btnConfirmar.setEnabled(true);
				guardarVenta(posicion);
			}
		});
		comboBox = new JComboBox<String>();
		comboBox.addItem("");
		comboBox.addItem("Lisa");
		comboBox.addItem("Estampada");

		btnConsultar = new JButton("Consultar monto");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int posicion = comboBox.getSelectedIndex();
				consultarPrecio(posicion);
			}
		});
	}

	@Override
	public void guardarVenta(int posicion) {
		// TODO Auto-generated method stub

		int cantidad = Integer.parseInt(txtCantidadRemeras.getText());

		try {

			calculador.registrarVenta(posicion, cantidad, txtCorreo.getText(), fecha.now());
			JFrame jFrame = new JFrame();
			JOptionPane.showMessageDialog(jFrame, "¡La compra se ha realizado con éxito!");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	@Override
	public void consultarPrecio(int posicion) {

		int cantidad = Integer.parseInt(txtCantidadRemeras.getText());
		double monto;

		try {
			monto = calculador.consultarMonto(posicion, cantidad, fecha.now());
			JFrame jFrame = new JFrame();
			JOptionPane.showMessageDialog(jFrame, "El monto de la compra es de: $" + monto);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	@Override
	public void layout() {

		// TODO Auto-generated method stub
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
														.addComponent(lblCorreo).addComponent(lblCantidadRemeras,
																GroupLayout.PREFERRED_SIZE, 89, Short.MAX_VALUE))
												.addPreferredGap(ComponentPlacement.RELATED, 18,
														GroupLayout.PREFERRED_SIZE)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
														.addComponent(txtCorreo, Alignment.TRAILING)
														.addComponent(txtCantidadRemeras, Alignment.TRAILING,
																GroupLayout.PREFERRED_SIZE, 242,
																GroupLayout.PREFERRED_SIZE)))
										.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
												.addComponent(btnConsultar).addGap(76).addComponent(btnConfirmar,
														GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE))))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup().addGap(173)
								.addComponent(comboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtCantidadRemeras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCantidadRemeras))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblCorreo).addComponent(
						txtCorreo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
						GroupLayout.PREFERRED_SIZE)
				.addGap(72).addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(btnConfirmar)
						.addComponent(btnConsultar))
				.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		contentPane.setLayout(gl_contentPane);
	}
}
