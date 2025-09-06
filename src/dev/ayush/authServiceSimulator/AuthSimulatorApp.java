package dev.ayush.authServiceSimulator;

import dev.ayush.authServiceSimulator.controller.AuthController;
import dev.ayush.authServiceSimulator.security.PasswordHasher;
import dev.ayush.authServiceSimulator.security.TokenStore;
import dev.ayush.authServiceSimulator.service.AuthService;
import dev.ayush.authServiceSimulator.persistence.FileService;

import java.time.Duration;
import java.util.Scanner;

/**
 * Console entry point for Auth Service Simulator.
 */
public class AuthSimulatorApp {
    public static void main(String[] args) {
        // entry point: wire dependencies, show prompt loop
        FileService fileService = new FileService();
        PasswordHasher hasher = new PasswordHasher();
        TokenStore tokenStore = new TokenStore(Duration.ofMinutes(30));

        AuthService authService = new AuthService(hasher, tokenStore);

        AuthController controller = new AuthController(authService);

        runLoop(controller);
    }

    /**
     * Show prompt & route lines to controller.
     */
    private static void runLoop(AuthController controller) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("""
                    ===== Auth Service Simulator =====
                    Type 'HELP' for commands. Type 'EXIT' to quit.
                    """);
        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine().trim();
            controller.handle(line);
        }
    }
}