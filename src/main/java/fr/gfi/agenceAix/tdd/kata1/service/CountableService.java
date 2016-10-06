package fr.gfi.agenceAix.tdd.kata1.service;

import fr.gfi.agenceAix.tdd.kata1.model.Countable;

public interface CountableService {
	
	Countable createCountable(int number);
	
	Countable[] createCountableRange(int start, int end);

}
