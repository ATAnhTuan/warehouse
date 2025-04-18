package com.simsys.warehouse;
import com.simsys.warehouse.service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WarehouseApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(WarehouseApplication.class, args);

	}
}
