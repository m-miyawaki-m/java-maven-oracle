-- DB作成
CREATE DATABASE IF NOT EXISTS mysql;

-- ユーザー作成
CREATE USER 'dev_user' IDENTIFIED BY 'devuser';

-- ユーザーに権限付与
GRANT ALL ON mysql.* TO 'dev_user';

-- ユーザー一覧
SELECT user, host FROM mysql.user;