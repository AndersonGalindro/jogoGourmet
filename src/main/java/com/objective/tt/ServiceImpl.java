package com.objective.tt;

import javax.swing.JOptionPane;

public class ServiceImpl extends Service {

	public ServiceImpl(String dish) {
		super(dish);
	}

	@Override
	public int ask() {
		int response = confirmDish();

		if (response == 0) {
			JOptionPane.showMessageDialog(null, "Acertei de novo!", "Jogo Gourmet", 1);
		}
		if (response == 1) {

			String newDish = JOptionPane.showInputDialog(null, "Qual prato você pensou?", "Desisto", 3);
			if (newDish == null) {
				System.exit(0);
			}

			String newTip = JOptionPane.showInputDialog(null, newDish + " é _______ mas " + this.getDish() + " não.",
					"Complete", 3);

			Service newQuestion = new Service(newTip);

			ServiceImpl newFinalQuestion = new ServiceImpl(newDish);

			this.getParentQuestion().setChildQuestion(newQuestion, this.isPositiveQuestion());

			newQuestion.setPositiveQuestion(newFinalQuestion);
			newQuestion.setNegativeQuestion(this);

		}
		return response;
	}
}
