import com.training.weatherservice.WeatherServiceApplication;
import org.junit.Test;
import org.modelmapper.internal.util.Assert;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class WeatherServiceApplicationTests {

  @Test
  public void contextLoads() {
    WeatherServiceApplication application = new WeatherServiceApplication();
    Assert.notNull(application);
  }
}