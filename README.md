# 負荷試験のデモリポジトリです

## 構成

- /stress_test -> Gatlingのテストをするディレクトリです
   
- /mock_api_server -> Gatlingでテストする際に使うローカルサーバー

## 環境

- stress_test
  - java 8がインストールされていること
    - Gatlingにjava8が必須
            
- test_server
  - python3.11
  - pipenv 
  - fastapi
  - fastapi-jwt-auth

## 動作方法

### テスト用APIサーバー

1. dockerのapiサーバーを起動する
``` $shell
docker compose up -d mock_server
```

### Gatlingの実行

1. stress_testに移動する 
2. bin/gatling.shを実行し、gatlingを実行する 
3. TestSimulation.scalaを実行する

### Taurusの実行

1. taurus_testのディレクトリに移動
2. pipenv install
3. 以下実行コマンドを行う
```shell
docker compose run --rm taurus bzt simulations/sample.yaml
```