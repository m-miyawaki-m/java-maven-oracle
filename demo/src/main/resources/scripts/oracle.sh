#!/bin/bash

# ORACLE_HOME と PATH の設定
export ORACLE_HOME=/opt/oracle/product/23c/dbhomeFree
export PATH=$ORACLE_HOME/bin:$PATH

# データベース設定
USERNAME="hr"
PASSWORD="oracle"
HOST="localhost"
PORT="1521"
SERVICE_NAME="freepdb1"

# CSVファイルとSQLスクリプトのディレクトリ
CSV_DIR="/home/oracle/work/sql"
SCRIPT_DIR="/home/oracle/work/shells"
FILE="CREATE_TABLE_SALES.sql"

# SQL*Plusを使用してOracleに接続し、salesテーブルが存在する場合にのみTRUNCATE
sqlplus -s $USERNAME/$PASSWORD@$HOST:$PORT/$SERVICE_NAME <<EOF
DECLARE
   v_count NUMBER;
BEGIN
   SELECT COUNT(*) INTO v_count FROM user_tables WHERE table_name = 'SALES';
   IF v_count > 0 THEN
      -- テーブルが存在する場合、TRUNCATEを実行
      EXECUTE IMMEDIATE 'TRUNCATE TABLE sales';
   END IF;
END;
/

-- テーブルが存在しない場合、SQLファイルを実行
@${CSV_DIR}/${FILE}
EXIT;
EOF

# tar.gzファイルの解凍
tar -xzvf ${CSV_DIR}/sales_data.tar.gz -C ${CSV_DIR}

# SQL*Loaderを使用してCSVファイルをインポート
# 注: control_file.ctlは、CSVファイルのデータをsalesテーブルにマッピングするためのSQL*Loaderコントロールファイルです。
sqlldr $USERNAME/$PASSWORD@$HOST:$PORT/$SERVICE_NAME control=$SCRIPT_DIR/control_file.ctl data=$CSV_DIR/sales_data.csv

# CSVファイルの削除
rm ${CSV_DIR}/sales_data.csv

echo "処理が完了しました。"