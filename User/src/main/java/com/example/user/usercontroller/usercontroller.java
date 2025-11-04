package com.example.user.usercontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.user.model.User;
import com.example.user.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping("/api")
@Tag(name = "User Management", description = "Complete user CRUD operations")
public class usercontroller {

    @Autowired
    UserService service;

    // Simple annotation
    @GetMapping("/users")
    @Operation(summary = "Get all users")
    public ResponseEntity<List<User>> getUsers() {
        return new ResponseEntity<>(service.getUser(), HttpStatus.OK);
    }

    // With parameter description
    @GetMapping("/user/{userId}")
    @Operation(summary = "Get user by ID", description = "Retrieves a single user by their unique ID")
    public ResponseEntity<User> getUserById(
            @Parameter(description = "User ID to search", required = true, example = "1")
            @PathVariable int userId) {
        return new ResponseEntity<>(service.getuserById(userId), HttpStatus.OK);
    }

    // With multiple response codes
    @PostMapping("/save")
    @Operation(summary = "Create new user", description = "Creates a new user in the database")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "201", description = "User created successfully",
                     content = @Content(schema = @Schema(implementation = User.class))),
        @ApiResponse(responseCode = "400", description = "Invalid input data"),
        @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<User> insertUser(@RequestBody User usr) {
        return new ResponseEntity<>(service.insertUser(usr), HttpStatus.CREATED);
    }

    // Update with parameter + responses
    @PutMapping("/update/{userId}")
    @Operation(summary = "Update existing user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User updated successfully"),
        @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<User> updateUser(
            @Parameter(description = "ID of user to update") @PathVariable int userId,
            @RequestBody User usr) {
        return new ResponseEntity<>(service.updateUser(userId, usr), HttpStatus.OK);
    }

    // Delete with responses
    @DeleteMapping("/delete/{userId}")
    @Operation(summary = "Delete user", description = "Permanently deletes a user from the system")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "202", description = "User deleted successfully"),
        @ApiResponse(responseCode = "404", description = "User not found")
    })
    public ResponseEntity<String> deleteUser(
            @Parameter(description = "ID of user to delete", required = true)
            @PathVariable int userId) {
        return new ResponseEntity<>(service.deleteUser(userId), HttpStatus.ACCEPTED);
    }
}