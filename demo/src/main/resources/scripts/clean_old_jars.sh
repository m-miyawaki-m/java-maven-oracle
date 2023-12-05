#!/bin/bash
JAR_DIR=/workspaces/java-oracle/demo/work
JAR_COUNT=$(ls -t $JAR_DIR/*.jar | wc -l)
if [ $JAR_COUNT -gt 5 ]; then
  # 古い順に削除
  ls -tr $JAR_DIR/*.jar | head -n $(($JAR_COUNT-5)) | xargs rm
fi