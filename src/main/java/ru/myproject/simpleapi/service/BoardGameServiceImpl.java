package ru.myproject.simpleapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myproject.simpleapi.dao.BoardGameRepository;
import ru.myproject.simpleapi.model.BoardGame;

import java.util.List;

@Service
public class BoardGameServiceImpl implements BoardGameService {

    private final BoardGameRepository boardGameRepository;

    @Autowired
    public BoardGameServiceImpl(BoardGameRepository boardGameRepository) {
        this.boardGameRepository = boardGameRepository;
    }

    @Override
    public BoardGame get(Long id) {
        return boardGameRepository.findById(id).orElse(null);
    }

    @Override
    public List<BoardGame> getAll() {
        return boardGameRepository.findAll() ;
    }

    @Override
    public BoardGame save(BoardGame boardGame) {
        return boardGameRepository.save(boardGame);
    }

    @Override
    public void delete(Long id) {
        boardGameRepository.delete(id);
    }
}
