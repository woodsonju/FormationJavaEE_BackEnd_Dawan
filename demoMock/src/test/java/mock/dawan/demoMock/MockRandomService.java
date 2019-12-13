package mock.dawan.demoMock;

import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import mock.dawan.demoMock.services.RandomService;

@Profile("TEST")
@Configuration
public class MockRandomService {
	
	@Bean
	public RandomService randomService() {
		return Mockito.mock(RandomService.class);
	}
	
}
