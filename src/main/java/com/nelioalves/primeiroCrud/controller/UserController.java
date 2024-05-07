package com.nelioalves.primeiroCrud.controller;

import com.nelioalves.primeiroCrud.dto.request.UserRequestCreateDto;
import com.nelioalves.primeiroCrud.dto.request.UserRequestQueryDto;
import com.nelioalves.primeiroCrud.dto.response.UserResponseCreateDto;
import com.nelioalves.primeiroCrud.dto.response.UserResponseQueryDto;
import com.nelioalves.primeiroCrud.exceptions.dto.ErrorResponseDto;
import com.nelioalves.primeiroCrud.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//TODO: Atualizer Swagger após criar as exceptions erros;
@Slf4j
@RestController
@RequestMapping(value = "/users", produces = {"application/json"})
@AllArgsConstructor
@Tag(name = "Users")
public class UserController {

    private UserService userService; //injetar automaticamente minha service

    @Operation(summary = "Cadastro de usuários", method = "POST")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = ErrorResponseDto.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(deprecated = false)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserResponseCreateDto> createUsers(@RequestBody @Valid UserRequestCreateDto user){
        log.info("Post de usuários");
        UserResponseCreateDto userResponseCreateDto = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseCreateDto);
    }

    //TODO: estudar paginação e implementar.
    @Operation(summary = "Consultar lista usuários ou por parâmetros", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(deprecated = false)))
    })
    @GetMapping
    public ResponseEntity<List<UserResponseQueryDto>> findAll(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "email", required = false) String email
            ){
//TODO Alterar reqyestCreateDto dto para responseCrateDto;
        UserRequestQueryDto request = UserRequestQueryDto.builder()
                .name(name)
                .email(email)
                .build();

        List<UserResponseQueryDto> users = userService.queryUser(request);
        return ResponseEntity.status(HttpStatus.OK).body(users);
    }

    @Operation(summary = "Consultar usuário por ID", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(deprecated = false)))
    })
    @GetMapping(value="/{id}")
    public ResponseEntity<UserResponseCreateDto> findbyId(@PathVariable Long id) {
        UserResponseCreateDto SingleUser = userService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(SingleUser);
    }

    @Operation(summary = "Atualizar usuário", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(deprecated = false)))
    })
    @PutMapping(value = "/{id}")
    public ResponseEntity<UserResponseCreateDto> updateUser (@PathVariable Long id, @RequestBody UserRequestCreateDto user){
        UserResponseCreateDto updatedUser = userService.updateUser(id,user);
        return ResponseEntity.status(HttpStatus.OK).body(updatedUser);
    }

    @Operation(summary = "Excluir usuário", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(deprecated = false)))
    })

    @DeleteMapping(value = "/{id}")
    public void removeUser(@PathVariable Long id){
        userService.removeUser(id);
    }
}