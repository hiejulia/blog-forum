--- Native query for select post with full text search index 
SELECT * FROM blog WHERE MATCH (blog_title, blog_description) AGAINST ("initial" IN NATURAL LANGUAGE MODE);