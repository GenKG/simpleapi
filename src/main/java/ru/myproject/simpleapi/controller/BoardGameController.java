package ru.myproject.simpleapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.myproject.simpleapi.model.BoardGame;
import ru.myproject.simpleapi.service.BoardGameService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = BoardGameController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class BoardGameController {
    public static final String REST_URL = "/api/v1/boardGames";

    private final BoardGameService boardGameService;

    @Autowired
    public BoardGameController(BoardGameService boardGameService) {
        this.boardGameService = boardGameService;
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get board game by id")
    public BoardGame get(@PathVariable("id") Long id) {
        log.info("get" + id);
        return boardGameService.get(id);
    }

    @GetMapping
    @Operation(summary = "All get boards games in database")
    public List<BoardGame> getAll() {
        log.info("getAll");
        return boardGameService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Save board game")
    public BoardGame save(@RequestBody BoardGame boardGame) {
        log.info("save" + boardGame);
        return boardGameService.save(boardGame);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete board game by id")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        log.info("delete" + id);
        boardGameService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(String.format("board in id: %s was deleted", id));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Update all info by board game")
    public ResponseEntity<BoardGame> update(@PathVariable("id") Long id, @RequestBody BoardGame boardGame) {
        log.info("update board game with id: " + id);
        BoardGame updateBoardGame = boardGameService.update(id, boardGame);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(updateBoardGame);
    }

    @PatchMapping("/{id}")
    @Operation(summary = "Update part of info by board game")
    public ResponseEntity<BoardGame> modified(@PathVariable("id") Long id, @RequestBody BoardGame boardGame) {
        log.info("modified board game with id: " + id);
        BoardGame modifiedBoardGame = boardGameService.modified(id, boardGame);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(modifiedBoardGame);
    }
}
