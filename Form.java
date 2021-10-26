import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Form extends Frame implements ActionListener {

	// Declarando variáveis componentes e paineis
	private GridLayout layoutPainelSuperior = new GridLayout(3, 2);
	private GridLayout layoutPainelInferior = new GridLayout(1, 4);

	private TextField txtNome = new TextField(), txtIdade = new TextField(), txtEndereco = new TextField();
	private Button btnOk = new Button("ok"), btnLimpar = new Button("Limpar"), btnMostrar = new Button("Mostrar"),
			btnSair = new Button("Sair");

	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();

	private Label label = new Label("Nome");

	Form(String titulo, int largura, int altura) {
		super(titulo);
		setSize(largura, altura);
		setLayout(new BorderLayout());

		addWindowListener(new FechaJanela());

		// Definindo componentes painel superior
		Panel painelSuperior = new Panel(layoutPainelSuperior);
		layoutPainelSuperior.setHgap(10);
		layoutPainelSuperior.setVgap(10);

		painelSuperior.add(label);
		painelSuperior.add(txtNome);

		painelSuperior.add(new Label("Idade:"));
		painelSuperior.add(txtIdade);

		painelSuperior.add(new Label("Endereço:"));
		painelSuperior.add(txtEndereco);

		// Definindo componentes painel inferior
		Panel painelInferior = new Panel(layoutPainelInferior);

		btnOk.addActionListener(this);
		painelInferior.add(btnOk);

		btnLimpar.addActionListener(this);
		painelInferior.add(btnLimpar);

		btnMostrar.addActionListener(this);
		painelInferior.add(btnMostrar);

		btnSair.addActionListener(this);
		painelInferior.add(btnSair);

		add(painelSuperior, BorderLayout.CENTER);
		add(painelInferior, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnOk) {
			String nome = txtNome.getText();
			String endereco = txtEndereco.getText();
			int idade = Integer.parseInt(txtIdade.getText());

			alunos.add(new Aluno(endereco, idade, nome));
		}

		else if (e.getSource() == btnLimpar) {
			txtEndereco.setText("");
			txtNome.setText("");
			txtIdade.setText("");
		}

		else if (e.getSource() == btnMostrar) {
			String mensagem = "";

			for (Aluno aluno : alunos) {
				mensagem += aluno.toString();
			}

			JOptionPane.showMessageDialog(this, mensagem);
		}

		else if (e.getSource() == btnSair) {
			setVisible(false);
		}
	}
}
