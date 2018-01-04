# kadai-task-list

## 概要
ScalaとPlayフレームワークで作ったタスク管理アプリケーションです。

## バージョン
- Play: 2.5.4
- Scala:2.11.11
- sbt: 0.13
- MySQL: 5.7.20

## 動かす上での前提条件
- sbtがインストールされていること。
- MySQLがインストールされていること。
- `/create-local-mysql-db.sh`を実行。もしくは`/create-mysql-db.sql`の内容に従ってデータベースを作成すること。
- `/env`ディレクトリを作成し下記を参考に`dev.conf`を作成すること。

```dev.conf
flywayLocationNames = ["common", "mysql"]
flywayLocations = ["filesystem:conf/db/migration/default/common", "filesystem:conf/db/migration/default/mysql"]
jdbcDriver = "com.mysql.cj.jdbc.Driver"
jdbcUrl = "jdbc:mysql://localhost:3306/task_list?autoReconnect=true&useSSL=false"
jdbcUserName = "task_list"
jdbcPassword = "CHANGE ME!"
```

- `env/dev.conf`の`jdbcPassword`を適切な値に修正すること。



## 実行方法
```bash
sbt flywayMigrate
sbt run
```

```bash
# sbt flywayMigrateが失敗してやり直す場合
sbt flywayClean
sbt flywayMigrate
sbt run
```


