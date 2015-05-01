package timetable_mvc_package;

import timetable_mvc_client.TimetableMvcClientApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TimetableMvcClientApplication.class)
@WebAppConfiguration
public class TimetableMvcClientApplicationTests {

	@Test
	public void contextLoads() {
	}

}
