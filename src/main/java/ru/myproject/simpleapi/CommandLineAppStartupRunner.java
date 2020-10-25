package ru.myproject.simpleapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.myproject.simpleapi.dao.BoardGameRepository;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final BoardGameRepository boardGameRepository;

    @Autowired
    public CommandLineAppStartupRunner(BoardGameRepository boardGameRepository) {
        this.boardGameRepository = boardGameRepository;
    }



    @Override
    public void run(String... args) throws Exception {
        System.out.println(boardGameRepository.findById(1L).get());
    }
}
