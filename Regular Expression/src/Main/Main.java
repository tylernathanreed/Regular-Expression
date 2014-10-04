//* Description *//
// Title: Main
// Author: Tyler Reed
// Runs the Program

//* Package *//

package Main;

//* Libraries *//
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.ListSelectionModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.table.TableModel;
import javax.swing.JTable;

//* Main Class *//
public class Main extends JFrame
{
	private static final long serialVersionUID = -1595166773115412267L;
	private JPanel contents;
	private JTextField txt_input;
	private JTextField txt_pattern;
	private JTable tbl_tokens;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Main frame = new Main();
					frame.setVisible(true);
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main()
	{
		setTitle("Regex Pattern Matcher");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 324);
		contents = new JPanel();
		contents.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contents);
		GridBagLayout gbl_contents = new GridBagLayout();
		gbl_contents.rowHeights = new int[] {40, 40, 0};
		gbl_contents.columnWidths = new int[] {320};
		gbl_contents.columnWeights = new double[] {1.0};
		gbl_contents.rowWeights = new double[] {0.0, 0.0, 1.0};
		contents.setLayout(gbl_contents);

		JPanel pan_input = new JPanel();
		pan_input.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Regex Information", TitledBorder.LEFT, TitledBorder.TOP, null, null), new EmptyBorder(0, 5, 2, 5)));
		GridBagConstraints gbc_pan_input = new GridBagConstraints();
		gbc_pan_input.fill = GridBagConstraints.BOTH;
		gbc_pan_input.insets = new Insets(0, 0, 5, 0);
		gbc_pan_input.gridx = 0;
		gbc_pan_input.gridy = 0;
		contents.add(pan_input, gbc_pan_input);
		GridBagLayout gbl_pan_input = new GridBagLayout();
		gbl_pan_input.columnWidths = new int[] {40, 60};
		gbl_pan_input.rowHeights = new int[] {20, 20};
		gbl_pan_input.columnWeights = new double[] {0.0, 0.0};
		gbl_pan_input.rowWeights = new double[] {0.0, 0.0};
		pan_input.setLayout(gbl_pan_input);

		JLabel lbl_pattern = new JLabel("Pattern: ");
		lbl_pattern.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lbl_pattern = new GridBagConstraints();
		gbc_lbl_pattern.anchor = GridBagConstraints.WEST;
		gbc_lbl_pattern.fill = GridBagConstraints.VERTICAL;
		gbc_lbl_pattern.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_pattern.gridx = 0;
		gbc_lbl_pattern.gridy = 0;
		pan_input.add(lbl_pattern, gbc_lbl_pattern);

		txt_pattern = new JTextField();
		txt_pattern.setHorizontalAlignment(SwingConstants.LEFT);
		txt_pattern.setColumns(32);
		GridBagConstraints gbc_txt_pattern = new GridBagConstraints();
		gbc_txt_pattern.fill = GridBagConstraints.BOTH;
		gbc_txt_pattern.insets = new Insets(0, 0, 5, 0);
		gbc_txt_pattern.gridx = 1;
		gbc_txt_pattern.gridy = 0;
		pan_input.add(txt_pattern, gbc_txt_pattern);

		JLabel lbl_input = new JLabel("Input: ");
		GridBagConstraints gbc_lbl_input = new GridBagConstraints();
		gbc_lbl_input.anchor = GridBagConstraints.WEST;
		gbc_lbl_input.fill = GridBagConstraints.VERTICAL;
		gbc_lbl_input.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_input.gridx = 0;
		gbc_lbl_input.gridy = 1;
		pan_input.add(lbl_input, gbc_lbl_input);
		lbl_input.setHorizontalAlignment(SwingConstants.LEFT);

		txt_input = new JTextField();
		GridBagConstraints gbc_txt_input = new GridBagConstraints();
		gbc_txt_input.fill = GridBagConstraints.BOTH;
		gbc_txt_input.gridx = 1;
		gbc_txt_input.gridy = 1;
		pan_input.add(txt_input, gbc_txt_input);
		txt_input.setHorizontalAlignment(SwingConstants.LEFT);
		txt_input.setColumns(32);

		JPanel pan_tokenize = new JPanel();
		pan_tokenize.setBorder(new EmptyBorder(0, 2, 0, 2));
		GridBagConstraints gbc_pan_tokenize = new GridBagConstraints();
		gbc_pan_tokenize.fill = GridBagConstraints.BOTH;
		gbc_pan_tokenize.insets = new Insets(0, 0, 5, 0);
		gbc_pan_tokenize.gridx = 0;
		gbc_pan_tokenize.gridy = 1;
		contents.add(pan_tokenize, gbc_pan_tokenize);
		final TableModel model_tokens = new TableModel();
		JButton btn_tokenize = new JButton("Tokenize");

		pan_tokenize.setLayout(new BorderLayout(0, 0));
		pan_tokenize.add(btn_tokenize);

		JPanel pan_tokens = new JPanel();
		pan_tokens.setBorder(new TitledBorder(null, "Tokens", TitledBorder.LEFT, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_pan_tokens = new GridBagConstraints();
		gbc_pan_tokens.fill = GridBagConstraints.BOTH;
		gbc_pan_tokens.gridx = 0;
		gbc_pan_tokens.gridy = 2;
		contents.add(pan_tokens, gbc_pan_tokens);
		pan_tokens.setLayout(new BorderLayout(0, 0));

		final JScrollPane scr_tokens = new JScrollPane();
		scr_tokens.setViewportBorder(new EmptyBorder(1, 1, 1, 1));
		pan_tokens.add(scr_tokens, BorderLayout.CENTER);
		scr_tokens.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scr_tokens.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		tbl_tokens = new JTable(model_tokens);
		scr_tokens.setViewportView(tbl_tokens);

		btn_tokenize.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				// Clear Model
				model_tokens.clear();

				// Determine new Tokens
				List<Regex.Token> tokens = Regex.match(txt_input.getText(), txt_pattern.getText());
				System.out.println("Found Tokens: " + tokens);

				// Add Tokens to Model
				for(Regex.Token token : tokens)
					model_tokens.addElement(token);

				System.out.println("List Model: " + model_tokens);
				list_tokens.setSize(scr_tokens.getViewport().getWidth(), list_tokens.getFixedCellHeight() * tokens.size());
			}
		});
	}
}
