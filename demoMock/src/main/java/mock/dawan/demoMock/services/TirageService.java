package mock.dawan.demoMock.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TirageService {
	
	@Autowired
	RandomService randomService;
	
	public  String donneResultat(int min) {
		return "J'ai trouvé " + randomService.getNumber(min);
	}
	
}
