package ru.myproject.simpleapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.myproject.simpleapi.dao.BoardGameRepository;
import ru.myproject.simpleapi.model.BoardGame;

import java.util.List;
import java.util.Optional;

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
        return boardGameRepository.findAll();
    }

    @Override
    public BoardGame save(BoardGame boardGame) {
        return boardGameRepository.save(boardGame);
    }

    @Override
    public BoardGame update(Long id, BoardGame newBoardGame) {
        BoardGame updateBoard = boardGameRepository.findById(id).orElseThrow(() -> new RuntimeException("Board not found with id: " + id));
        updateBoard.setName(newBoardGame.getName());
        updateBoard.setPrice(newBoardGame.getPrice());
        updateBoard.setPublisher(newBoardGame.getPublisher());
        updateBoard.setQuantity(newBoardGame.getQuantity());
        return boardGameRepository.save(updateBoard);
    }

    @Override
    public BoardGame modified(Long id, BoardGame boardGame) {
        BoardGame modifiedBoard = boardGameRepository.findById(id).orElseThrow(() -> new RuntimeException("Board not found with id: " + id));
        modifiedBoard.setName(boardGame.getName());
        modifiedBoard.setPrice(boardGame.getPrice());
        modifiedBoard.setPublisher(boardGame.getPublisher());
        modifiedBoard.setQuantity(boardGame.getQuantity());
        return boardGameRepository.save(modifiedBoard);
    }

    @Override
    public void delete(Long id) {
        boardGameRepository.delete(id);
    }
}
