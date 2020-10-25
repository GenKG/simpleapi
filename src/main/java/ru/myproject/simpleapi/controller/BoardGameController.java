package ru.myproject.simpleapi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    public BoardGame get(@PathVariable("id") Long id){
        log.info("get" + id);
        return boardGameService.get(id);
    }

    @GetMapping
    public List<BoardGame> getAll(){
        log.info("getAll");
        return boardGameService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public BoardGame save(@RequestBody BoardGame boardGame){
        log.info("save" + boardGame);
        return boardGameService.save(boardGame);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        log.info("delete" + id);
        boardGameService.delete(id);
    }
}
