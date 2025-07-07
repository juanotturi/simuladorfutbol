CREATE TABLE team (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    code varchar(255) NOT NULL,
    score INT NOT NULL,
    confederation VARCHAR(255),
    league VARCHAR(255),
    team_type VARCHAR(255) NOT NULL
);
