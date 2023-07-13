package hr_manager.HRManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class HrManagerApplication {

	public static void main(String[] args)
	{
		SpringApplication.run(HrManagerApplication.class, args);
	}


}
