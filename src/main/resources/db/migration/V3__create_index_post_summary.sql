-- Add column summary

# ALTER TABLE Post
#   ADD summary VARCHAR(255);

-- Create index for Post table

create index summary_post
ON Post (summary);