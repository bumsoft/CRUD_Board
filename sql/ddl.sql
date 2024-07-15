CREATE TABLE post (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         Writer VARCHAR(255) NOT NULL,
                         Password VARCHAR(255) NOT NULL,
                         Title VARCHAR(255) NOT NULL,
                         Content TEXT
);
