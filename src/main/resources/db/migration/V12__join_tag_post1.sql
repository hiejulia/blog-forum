SELECT
    *
FROM
    post AS post
JOIN tag AS tag
    ON post.id = tag.post_id;

