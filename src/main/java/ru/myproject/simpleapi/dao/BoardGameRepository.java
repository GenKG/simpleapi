package ru.myproject.simpleapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.myproject.simpleapi.model.BoardGame;

@Transactional(readOnly = true)
public interface BoardGameRepository extends JpaRepository<BoardGame,Long> {

    @Transactional
    @Modifying
    @Query("DELETE FROM BoardGame bg WHERE bg.id=:id")
    int delete(@Param("id") Long id);
}
