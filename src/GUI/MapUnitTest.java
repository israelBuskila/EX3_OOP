package GUI;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Geom.Point3D;

class MapUnitTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testPixelToCoords() {
		Point3D coords=new Point3D(32.10245968847597,35.207503970664895);
		Point3D PixelTOCoords=new Point3D(GUI.Map.PixelToCoords(1433,642,735,542));
		if(!coords.equals(PixelTOCoords))
		{
			fail("The convert is not match");
		}
	}

	@Test
	void testCoordsToPixel() {
		Point3D ansOnGUi=new Point3D(735,542);
		Point3D p=new Point3D(GUI.Map.coordsToPixel(1433,642,32.10245968847423,35.20750397067172));
		if(!ansOnGUi.equals(p))
		{
			fail("The convert is not match");
		}
	}

}
