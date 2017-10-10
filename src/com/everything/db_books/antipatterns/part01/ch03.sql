CREATE TABLE CH_3_2_Comments (
comment_id SERIAL PRIMARY KEY,
parent_id BIGINT ,
bug_id BIGINT  NOT NULL,
author BIGINT NOT NULL,
comment_date DATETIME NOT NULL,
comment TEXT NOT NULL,
FOREIGN KEY (parent_id) REFERENCES Comments(comment_id),
FOREIGN KEY (bug_id) REFERENCES Bugs(bug_id),
FOREIGN KEY (author) REFERENCES Accounts(account_id)
);