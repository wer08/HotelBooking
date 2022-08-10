package pl.wer08.HotelBooking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.Scanner;

@SpringBootApplication
@Component
public class HotelBookingApplication implements CommandLineRunner
{
	@Autowired
	Client client;
	@Autowired
	ClientHandler clientHandler;


	public static void main(String[] args) {
		SpringApplicationBuilder builder = new SpringApplicationBuilder(HotelBookingApplication.class);

		builder.headless(false);

		ConfigurableApplicationContext context = builder.run(args);
	}

	@Override
	public void run(String... args) throws Exception
	{
		JFrame frame = new JFrame("LogIn");
		frame.setContentPane(new LogIn(client,clientHandler).LogIn);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}
