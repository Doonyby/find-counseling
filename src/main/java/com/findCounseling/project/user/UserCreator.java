package com.findCounseling.project.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;
import java.util.UUID;

//Uncomment @Component to run this class and it's run method at the
//init of the application after the application context is fully started.
//@Component
public class UserCreator implements CommandLineRunner {
    @Override
    public void run(String... args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.nextLine();

        System.out.println("Enter password:");
        String password = scanner.nextLine();

        System.out.println("Enter email:");
        String email = scanner.nextLine();

        System.out.println("Enter role:");
        String role = scanner.nextLine();


        String id = UUID.randomUUID().toString();

        // Create a new User object with the inputted data
        User user = new User(id, username, password, email, role);

        System.out.println("User created: " + user);
    }
}
