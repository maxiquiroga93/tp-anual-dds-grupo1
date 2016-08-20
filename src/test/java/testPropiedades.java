
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Helpers.LeerProperties;

public class testPropiedades {
	
	LeerProperties instance;

	@Before
	public void init() {

		instance = new LeerProperties();

	}

		@Test
		public void testLeer() {
			LeerProperties.getInstance().printThemAll();
			System.out.println(LeerProperties.prop.getProperty("distanciaLeveinstein"));
			Assert.assertEquals(LeerProperties.prop.getProperty("distanciaLeveinstein"),"2");
		}

}
