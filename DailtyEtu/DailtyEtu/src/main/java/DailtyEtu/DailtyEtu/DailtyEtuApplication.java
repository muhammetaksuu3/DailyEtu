package DailtyEtu.DailtyEtu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "DailtyEtu.DailtyEtu")
public class DailtyEtuApplication {

	public static void main(String[] args) {
		SpringApplication.run(DailtyEtuApplication.class, args);
	}

}
