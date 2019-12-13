package mock.dawan.demoMock;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import mock.dawan.demoMock.services.RandomService;
import mock.dawan.demoMock.services.TirageService;

@RunWith(SpringRunner.class)   
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ActiveProfiles("TEST")
public class DemoMockApplicationTests {
	
	@Autowired
	TirageService tirageService;
	
	@Autowired
	RandomService randomService;
	

	@Test
	public void test0() {
		System.out.println(tirageService.donneResultat(32));
		System.out.println(tirageService.donneResultat(32));
		System.out.println(tirageService.donneResultat(32));
		System.out.println(tirageService.donneResultat(32));
		System.out.println(tirageService.donneResultat(32));
	}
	
	@Test
	public void ConceptTest() {
		//On demande à Mockito de mocker ce service
		RandomService random = Mockito.mock(RandomService.class);
		Mockito.when(random.getNumber(32)).thenReturn(17);
		Mockito.when(random.getNumber(56)).thenReturn(33);

		
		Assert.assertEquals(17, random.getNumber(32));
		Assert.assertEquals(33, random.getNumber(56));
		Assert.assertEquals(0, random.getNumber(100));
		Assert.assertEquals(0, random.getNumber(42));
	}
	
//	@Test
//	public void TirageTestFail() {
//		RandomService random = Mockito.mock(RandomService.class);
//		Mockito.when(random.getNumber(32)).thenReturn(17);
//		Assert.assertEquals("J'ai trouvé 14",  tirageService.donneResultat(32));
//	}
	
	@Test
	public void TirageTest() {
		Mockito.when(randomService.getNumber(32)).thenReturn(17);
		Assert.assertEquals("J'ai trouvé 17",  tirageService.donneResultat(32));
		//Assert.assertEquals("J'ai trouvé 28",  tirageService.donneResultat(32));

	}

}
