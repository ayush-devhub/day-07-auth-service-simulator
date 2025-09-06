# Auth Service Simulator

A simple Java console application that simulates authentication with password, hashing, tokens and sessions.

## Overview

This project is a learning simulator for understanding Authentication.
It demonstrates concepts like:

- User registration and login
- Password hashing with salt
- Token based authentication
- Role Assignment (e.g., UESR, ADMIN)
- File persistence for users

## Setup

Clone the repository
```bash
  git clone https://github.com/your-username/AuthServiceSimulator.git
  cd AuthServiceSimulator
```

Compile and Run
```bash
  javac -d out src/dev/ayush/authServiceSimulator/**/*.java
  java -cp out dev.ayush.authServiceSimulator.AuthSimulatorApp
```

## Future Improvements
- Integrate Role Based Authorization 
- Replace custom hasher with BCrypt or PBKDF2
- Replace in-memory token store with database-backed sessions
- Add unit tests
- Build REST API instead of CLI
