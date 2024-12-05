package LR2_pkg;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SalaryCalculator {

	public static void main(String[] args) {

		JTextField rateField; // Поле для часовой ставки
		JTextField timeField; // Поле для количества часов
		JTextField bonusField; // Поле для премии
		JTextField fineField; // Поле для штрафов
		JTextArea resultArea; // Поле для вывода результата
		JButton calculateButton; // Кнопка вычисления
		
		JFrame frame = new JFrame(); // Новый экран
		frame.setTitle("Калькулятор расчета зарплаты");
		frame.setLocation(600, 400);
		frame.setSize(800, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());

		// Создание и добавление компонентов
		frame.add(new JLabel("Часовая ставка:"));
		rateField = new JTextField(10);
		frame.add(rateField);

		frame.add(new JLabel("Часов работы:"));
		timeField = new JTextField(10);
		frame.add(timeField);

		frame.add(new JLabel("Премия:"));
		bonusField = new JTextField(10);
		frame.add(bonusField);

		frame.add(new JLabel("Штраф:"));
		fineField = new JTextField(10);
		frame.add(fineField);

		calculateButton = new JButton("Рассчитать");
		frame.add(calculateButton);

		resultArea = new JTextArea(5, 30);
		resultArea.setEditable(false);
		frame.add(new JScrollPane(resultArea));

		
		
		// Обработчик кнопки
		calculateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double rate = Double.parseDouble(rateField.getText());
					double bonus = Double.parseDouble(bonusField.getText());
					double time = Double.parseDouble(timeField.getText());
					double fine = Double.parseDouble(fineField.getText());

					// Формула расчета заработной платы
					double total = rate * time + bonus - fine;

					// Вывод результата
					resultArea.setText("Заработная плата: " + String.format("%.2f", total));
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Ошибка ввода. Пожалуйста, введите корректные значения ");
				}
			}
		});
		
		frame.setVisible(true);// Отображение объектов
	}
}
