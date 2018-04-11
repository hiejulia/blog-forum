-- Add column summary

# ALTER TABLE Post
#   ADD summary VARCHAR(255);

create index summary_post
ON Post (summary);