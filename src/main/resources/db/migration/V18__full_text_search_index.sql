-- Alter post table for full text search index 

-- for 2 column 
ALTER TABLE post
ADD FULLTEXT INDEX `FullText` 
(`title` ASC, 
 `summary` ASC);

--  FULLTEXT(blog_title,blog_description)
-- ) ENGINE=InnoDB;