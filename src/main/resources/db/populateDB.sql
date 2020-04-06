DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM meals;
ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password) VALUES
  ('User', 'user@yandex.ru', 'password'),
  ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id) VALUES
  ('ROLE_USER', 100000),
  ('ROLE_ADMIN', 100001);

INSERT INTO meals(datetime, description, calories) VALUES
  ('30-12-20', 'Завтрак', 500),
  ('12-12-20', 'Обед', 100),
  ('12-12-20', 'Ужин', 500),
  ('31-12-20', 'Еда на граничное значение', 100),
  ('30-12-20', 'Обед', 410);


