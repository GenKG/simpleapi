package ru.myproject.simpleapi.service;

import ru.myproject.simpleapi.model.BoardGame;

import java.util.List;

public interface BoardGameService {
    BoardGame get(Long id);

    List<BoardGame> getAll();

    BoardGame save(BoardGame boardGame);

    void delete(Long id);
}
