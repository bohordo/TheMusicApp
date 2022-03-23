package com.training.TheMusicApp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.training.TheMusicApp.repository.entity.SongEntity;
import com.training.TheMusicApp.service.domain.Song;
import com.training.TheMusicApp.service.SongService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class TheMusicAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheMusicAppApplication.class, args);
	}
}
