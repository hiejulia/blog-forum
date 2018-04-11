CREATE OR REPLACE VIEW tag_view AS SELECT tag.name AS name,
                                                       tag.id AS id
                                                FROM tag
                                                GROUP BY tag.post_id;