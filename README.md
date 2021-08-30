##### Gatlingのデモをするリポジトリです

1. 構成
    - /stress_test -> Gatlingのテストをするディレクトリです
    - /test_server -> Gatlingでテストする際に使うローカルサーバー

1. 環境
    - stress_test
        - java 8がインストールされていること
            - Gatlingにjava8が必須
            
    - test_server
        - python3.6
        - pipenv
            - bottle
            
1. 動作方法
    1. test_serverのディレクトリに移動し、pipenv installを実行する     
    1. test_server/src/main.pyを実行する
    1. stress_testに移動する
    1. bin/gatling.shを実行し、gatlingを実行する
    1. TestSimulation.scalaを実行する     