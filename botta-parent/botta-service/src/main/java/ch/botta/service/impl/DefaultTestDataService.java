package ch.botta.service.impl;

import org.springframework.stereotype.Service;

import ch.botta.service.TestDataService;
import ch.botta.service.dto.TestData;

@Service
public class DefaultTestDataService implements TestDataService{

	@Override
	public TestData getTestData(int number, String name) {
		return new TestData(number, name);
	}

}
