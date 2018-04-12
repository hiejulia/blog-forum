CREATE OR REPLACE VIEW post_view1 AS SELECT post.title AS title,
                                                       post.id AS id
                                                FROM post
                                                GROUP BY post.category;