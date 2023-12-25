-- hrユーザーで実行する場合
-- テーブルが存在するか確認してから実行してください

-- シーケンスを作成（必要に応じて）
-- CREATE SEQUENCE dev_history_seq START WITH 1 INCREMENT BY 1;

-- データを挿入
INSERT INTO hr.dev_history (No, sampleinput) VALUES (1, 'Sample Data 1');
INSERT INTO hr.dev_history (No, sampleinput) VALUES (2, 'Sample Data 2');
INSERT INTO hr.dev_history (No, sampleinput) VALUES (3, 'Sample Data 3');
INSERT INTO hr.dev_history (No, sampleinput) VALUES (4, 'Sample Data 4');
INSERT INTO hr.dev_history (No, sampleinput) VALUES (5, 'Sample Data 5');