package com.mania.zerosheet;

import com.mania.zerosheet.Items.Item;
import com.mania.zerosheet.Items.ItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ZerosheetApplication {
	public static void main(String[] args) {
		SpringApplication.run(ZerosheetApplication.class, args);
	}
	@Bean
	public CommandLineRunner dataSeederDemo(ItemRepository itemrepo) {
		return args -> {
			Item item = new Item("Name1", "PCS", 22.0, 15, 12.9);
			itemrepo.save(item);
		};
	}
}
