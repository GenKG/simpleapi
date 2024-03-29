DROP TABLE IF EXISTS board_game CASCADE;
DROP SEQUENCE IF EXISTS global_seq;
CREATE SEQUENCE global_seq START WITH 1;
CREATE TABLE board_game(
    id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name        VARCHAR         NOT NULL,
    publisher   VARCHAR         NOT NULL,
    price       INTEGER         NOT NULL,
    quantity    INTEGER         NOT NULL
);