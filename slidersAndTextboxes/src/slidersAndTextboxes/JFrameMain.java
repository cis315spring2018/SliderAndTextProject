/**
 *   file: JFrameMain.java
 */
package slidersAndTextboxes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * @author atmanning - atmanning@dbq.edu
 *
 *  Demonstrate use of sliders interacting with textFields and visa-versa
 */
public class JFrameMain extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldV;
	private JTextField textFieldH;
	private JSlider sliderH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMain frame = new JFrameMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameMain() {
		setTitle("sliders and textfields");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 474);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldH = new JTextField();
		textFieldH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JTextField me = (JTextField)e.getSource();
				
				// update slider to match value here
				sliderH.setValue(Integer.parseInt(me.getText()));
				
			}
		});
		textFieldH.setText("50");
		textFieldH.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldH.setColumns(10);
		textFieldH.setBounds(465, 31, 53, 22);
		contentPane.add(textFieldH);
		
		sliderH = new JSlider();
		sliderH.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				
				// update textFieldH
				JSlider me = (JSlider)e.getSource();
				
				// now update the textfield
				textFieldH.setText("" + me.getValue());
			}
		});
		sliderH.setMajorTickSpacing(10);
		sliderH.setMinorTickSpacing(5);
		sliderH.setPaintTicks(true);
		sliderH.setPaintLabels(true);
		sliderH.setBounds(75, 46, 457, 70);
		contentPane.add(sliderH);
		
		textFieldV = new JTextField();
		textFieldV.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldV.setText("50");
		textFieldV.setBounds(61, 392, 53, 22);
		contentPane.add(textFieldV);
		textFieldV.setColumns(10);
		
		JSlider sliderV = new JSlider();
		sliderV.setMinorTickSpacing(2);
		sliderV.setMajorTickSpacing(20);
		sliderV.setPaintTicks(true);
		sliderV.setPaintLabels(true);
		sliderV.setOrientation(SwingConstants.VERTICAL);
		sliderV.setBounds(29, 129, 103, 261);
		contentPane.add(sliderV);
	}
}
