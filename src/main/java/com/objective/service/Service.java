package com.objective.service;

import java.text.MessageFormat;

import javax.swing.JOptionPane;

public class Service {
	private int confirm = -1;
	private Service parentQuestion;
	private Service positiveQuestion;
	private Service negativeQuestion;

	private String questionDescription = "O prato que você pensou é {0}?";
	private String dish;
	private boolean isPositiveQuestion;

	public Service(String dish) {
		this.dish = dish;
		this.questionDescription = MessageFormat.format(this.questionDescription, dish);
	}

	public int ask() {
		int retorno = confirmDish();

		if (retorno == 0) {
			confirm = this.positiveQuestion.ask();
		}
		if (retorno == 1) {
			confirm = this.negativeQuestion.ask();
		}
		return confirm;

	}

	protected int confirmDish() {
		confirm = JOptionPane.showOptionDialog(null, this.questionDescription, "Confirm",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
		if (confirm == 2) {
			System.exit(0);
		}
		return confirm;

	}

	public void setChildQuestion(Service question, boolean isPositiveQuestion) {
		if (isPositiveQuestion) {
			this.setPositiveQuestion(question);
		} else {
			this.setNegativeQuestion(question);
		}
	}

	public void setPositiveQuestion(Service positiveQuestion) {
		this.positiveQuestion = positiveQuestion;
		this.positiveQuestion.setParentQuestion(this);
		this.positiveQuestion.setPositiveQuestion(true);
	}

	public void setNegativeQuestion(Service negativeQuestion) {
		this.negativeQuestion = negativeQuestion;
		this.negativeQuestion.setParentQuestion(this);
		this.negativeQuestion.setPositiveQuestion(false);
	}

	public Service getParentQuestion() {
		return parentQuestion;
	}

	public void setParentQuestion(Service parentQuestion) {
		this.parentQuestion = parentQuestion;
	}

	public boolean isPositiveQuestion() {
		return isPositiveQuestion;
	}

	public void setPositiveQuestion(boolean isPositiveQuestion) {
		this.isPositiveQuestion = isPositiveQuestion;
	}

	public Service getPositiveQuestion() {
		return positiveQuestion;
	}

	public Service getNegativeQuestion() {
		return negativeQuestion;
	}

	public String getDish() {
		return dish;
	}

}
