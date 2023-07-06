package com.objective;

import javax.swing.JOptionPane;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.objective.service.Service;
import com.objective.service.ServiceImpl;

@SpringBootApplication
public class JogoGourmetApplication {

	public static void main(String[] args) {
		int i;

		Service question = new Service("massa");
		question.setPositiveQuestion(new ServiceImpl("Lasanha"));
		question.setNegativeQuestion(new ServiceImpl("Bolo de Chocolate"));

		do {
			i = startPane(question);
		} while (i > -1 && i < 2);

	}

	private static int startPane(Service question) {

		JOptionPane.showOptionDialog(null, "Pense em um prato que gosta", "Jogo Gourmet", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, null, null);

		return question.ask();

	}
}
