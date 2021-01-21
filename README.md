# HA環境でのセッション管理を確認するサンプル

- アプリケーションコンテナを冗長化するときのセッション管理にRedisでキャッシュしてみる
  
- ロードバランサーのパーシステンス機能 (Sticky Session) も設定して Redisとの比較も行う

- ついでにSSL対応とDatabaseも追加してローカルの開発環境のベースにできるDocker-Compose を作る

## 構成

- Load Balancer: HAProxy
- Application: SpringBoot
- Cache: Redis
  
- SSL: mkcert
- Database: PostgreSQL

