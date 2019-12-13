package mock.dawan.demoMock.services;

import org.springframework.stereotype.Service;

@Service
public class RandomService {
	
	public int getNumber(int min) {
		return (int) (Math.random()*100) + min;
	}
	
}
