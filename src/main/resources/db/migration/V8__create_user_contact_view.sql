create view user_contact_view as (
  select
    u.id,u.admin,u.login,u.password,u.username,u.group_id,c.email,c.name,c.phone
  from USER u join Contact c on u.id = c.user_id
);
