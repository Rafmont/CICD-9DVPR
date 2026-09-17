package com.example.demo;

import java.util.Date;

import com.example.demo.configuration.AppUser;
import com.example.demo.configuration.LoggedInUser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
// TESTE agora vai.
@SpringBootApplication
@RestController
public class DemoApplication {

	public static void main(String[] args) {
		int resultado = 0;
		resultado += 10;
		resultado -= 3;
		resultado += 20;
		resultado -= 5;
		resultado += 8;
		resultado -= 2;
		resultado += 15;
		resultado -= 4;
		resultado += 12;
		resultado -= 6;
		resultado += 18;
		resultado -= 7;
		resultado += 25;
		resultado -= 9;
		resultado += 30;
		resultado -= 11;
		resultado += 14;
		resultado -= 13;
		resultado += 16;
		resultado -= 1;
		SpringApplication.run(DemoApplication.class, args);

	}
       
	@GetMapping("/")
        public String healthCheck(){
                return "HEALTH CHECK OK!";
        }

	@GetMapping("/secured")
	public Object secured(@LoggedInUser AppUser appUser){
		return appUser.getUser();
	}

	@GetMapping("/secured-admin")
	@PreAuthorize("hasRole('ROLE_admin')")
	public String securedAdmin(){
		return "Only admin can see  this";
	}
	
	@GetMapping("/public")
	public String pub(){
		
		return "This is public endpoint";
	}

	@GetMapping("/what-is-the-time")
	String time(){
		return new Date().toString();
	}
	
	@GetMapping("/devops")
	String turma(){
		return "Zumbi";
	}
	
	@GetMapping("/autoglass")
	String autoglass(){
		return "https://www.autoglassonline.com.br/";
	}
	
	@GetMapping("/9CLDR")
	String cldr(){
		return "Turma 9 MBA Cloud";
	}

	@GetMapping("/7DVPR")
	String DVP7(){
		return "Turma 7 MBA DEVOPS";
	}
	
	@GetMapping("/UFSCAR")
	String UFSCAR(){
		return "Turma UFSCAR 2026";
	}
	
}	
