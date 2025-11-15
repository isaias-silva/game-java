package engine.containers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import engine.phases.Phase;

public class Container extends JFrame {

	private final List<Phase> phases = new ArrayList<>();


	public Container(String title, int width, int height) {

		setTitle(title);
		setSize(width, height);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}


	public void load() {
		phases.forEach(this::add);
		setLocationRelativeTo(null);

		phases.getFirst().start();

		setResizable(false);

		setVisible(true);

	}


	public void addPhase(Phase phase) {
		phases.add(phase);
	}

}