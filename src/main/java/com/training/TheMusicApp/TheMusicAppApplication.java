package com.training.TheMusicApp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
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

//	@Bean
//	CommandLineRunner runner(SongService songService){
//		return args -> {
//			// read JSON and load json
//			ObjectMapper mapper = new ObjectMapper();
//
//			TypeReference<List<Song>> typeReference = new TypeReference<List<Song>>(){};
//
//			InputStream inputStreamJson = TypeReference.class.getResourceAsStream("/input/spotify-top100-2018.json");
//
//			try {
//				List<Song> users = mapper.readValue(inputStreamJson,typeReference);
//				songService.save(users);
//				System.out.println("Songs saved");
//			} catch (IOException e){
//				System.out.println("Unable to save songs: " + e.getMessage());
//			}
//		};
//	}
}
