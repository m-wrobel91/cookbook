DROP TABLE RECIPE IF EXISTS;
CREATE TABLE RECIPE (
    id LONG AUTO_INCREMENT PRIMARY KEY,
    timestamp TIMESTAMP,
    title VARCHAR(400) NOT NULL,
    preparation_time_in_minutes INT NOT NULL,
    cooking_time_in_minutes INT NOT NULL,
    content VARCHAR(2000) NULL,
    rating FLOAT,
    no_of_votes INTEGER,
    image_url VARCHAR(60) NOT NULL,
    author VARCHAR(40)  NULL
);

DROP TABLE COMMENT IF EXISTS;
CREATE TABLE COMMENT (
    id LONG AUTO_INCREMENT PRIMARY KEY,
    recipe_id LONG NOT NULL,
    timestamp TIMESTAMP,
    content VARCHAR(2000) NULL,
    author VARCHAR(40) NOT NULL
);

ALTER TABLE COMMENT
    ADD CONSTRAINT comment_recipe_id
    FOREIGN KEY (recipe_id) REFERENCES recipe(id)
