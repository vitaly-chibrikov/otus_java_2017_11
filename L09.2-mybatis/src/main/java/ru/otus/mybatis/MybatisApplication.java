package ru.otus.mybatis;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MybatisApplication implements CommandLineRunner {

	private final CityMapper cityMapper;

	public MybatisApplication(CityMapper cityMapper) {
		this.cityMapper = cityMapper;
	}

	public static void main(String[] args) {
		System.out.println("------ before init");
		SpringApplication.run(MybatisApplication.class, args);
		System.out.println("------ after init");
	}

	@Override
	public void run(String... strings) throws Exception {
		System.out.println("-------HELLO!!!!");
		System.out.println(cityMapper.findCityByState("CA"));
		System.out.println(cityMapper.findCityByCountry("Россия"));
		System.out.println(cityMapper.findCityByCountry(null));
	}
}
