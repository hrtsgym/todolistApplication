#!/bin/bash
# この行はシェバン（shebang）で、スクリプトがbashで実行されることを示します。

MD_DIR=../../../sugiyama_ha/diary
SAMPLE_DIR=../sample
PULL_CMD="git pull origin master"

#todolistプロジェクトをpullする
$PULL_CMD

#sampleプロジェクトに移動する
cd $SAMPLE_DIR
#sampleプロジェクトをpullする
$PULL_CMD

#diaryプロジェクトに移動する
cd $MD_DIR
#diaryプロジェクトをpullする
$PULL_CMD