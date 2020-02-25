nablarch-example-web
===========================

| master | develop |
|:-----------|:------------|
|[![Build Status](https://travis-ci.org/nablarch/nablarch-example-web.svg?branch=master)](https://travis-ci.org/nablarch/nablarch-example-web)|[![Build Status](https://travis-ci.org/nablarch/nablarch-example-web.svg?branch=develop)](https://travis-ci.org/nablarch/nablarch-example-web)|

Nablarchアプリケーションフレームワークを利用して作成したウェブExampleアプリケーションです。

## 実行手順

### 1.動作環境
実行環境に以下のソフトウェアがインストールされている事を前提とします。
* Java Version : 8
* Maven 3.0.5以降

以下は、本手順では事前準備不要です。

|ソフトウェア|説明|
|:---|:---|
|APサーバ|このアプリケーションはTomcat8を使用しています。waitt-maven-pluginはTomcat8へのアプリケーションのデプロイ、起動を行います。（起動前にエンティティクラスの作成とアプリケーションのコンパイルを別途行う必要があります。）|
|DBサーバ|このアプリケーションはH2 Database Engine(以下H2)を組み込んであるため、別途インストールの必要はありません。|

### 2. プロジェクトリポジトリの取得
Gitを使用している場合、アプリケーションを配置したいディレクトリにて「git clone」コマンドを実行してください。
以下、コマンドの例です。

    $mkdir c:\example
    $cd c:\example
    $git clone https://github.com/nablarch/nablarch-example-web.git

Gitを使用しない場合、最新のタグからzipをダウンロードし、任意のディレクトリへ展開してください。

### 3. アプリケーションのビルド
#### 3.1. データベースのセットアップ及びエンティティクラスの作成
まず、データベースのセットアップ及びエンティティクラスの作成を行います。以下のコマンドを実行してください。

    $cd nablarch-example-web
    $mvn generate-resources
  
実行に成功すると、以下のようなログがコンソールに出力され、nablarch-example-webディレクトリの下にtargetディレクトリが作成されます。

    (中略)
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    (中略)

#### 3.2. アプリケーションのビルド

次に、アプリケーションをビルドします。以下のコマンドを実行してください。

    $mvn compile
    
実行に成功すると、以下のようなログがコンソールに出力されます。

    (中略)
    [INFO] ------------------------------------------------------------------------
    [INFO] BUILD SUCCESS
    [INFO] ------------------------------------------------------------------------
    (中略)


### 4. アプリケーションの起動
最後にwaitt-maven-pluginを実行し、組み込みTomcatを起動させます。以下のコマンドを実行してください。

    $mvn waitt:run

起動に成功すると、自動的にアプリケーションのログイン画面が表示されます。
以下のログインID、パスワードでログインできます。

| ログインID | パスワード |
|:------|:--------|
| 10000001 | pass123-|

### 5. DBの確認方法

1. http://www.h2database.com/html/cheatSheet.html からH2をインストールしてください。

2. {インストールフォルダ}/bin/h2.bat を実行してください(コマンドプロンプトが開く)。  
  ※h2.bat実行中はExampleアプリケーションからDBへアクセスすることができないため、Exampleアプリケーションを停止しておいてください。

3. ブラウザから http://localhost:8082 を開き、以下の情報でH2コンソールにログインしてください。
   JDBC URLの{dbファイルのパス}には、`nablarch_example.mv.db`ファイルの格納ディレクトリまでのパスを指定してください。  
  JDBC URL：jdbc:h2:{dbファイルのパス}/nablarch_example  
  ユーザ名：NABLARCH_EXAMPLE  
  パスワード：NABLARCH_EXAMPLE

### 6. OS環境変数上書きの検証

事前に、以下の要領で環境変数を設定する。

**Linux**

```bash
$ ENV_VALUE_THIRD=ENV

$ ENV_VALUE_FOURTH=ENV

$ ENV_VALUE_SEVENTH=ENV

$ ENV_VALUE_EIGHTH=ENV
```

**Windows**

```
> set ENV_VALUE_THIRD=ENV

> set ENV_VALUE_FOURTH=ENV

> set ENV_VALUE_SEVENTH=ENV

> set ENV_VALUE_EIGHTH=ENV
```

`waitt:run` を実行するときに、以下の要領でシステムプロパティを設定する。

```bash
$ mvn -Denv-value.fifth=SYSPROP -Denv-value.sixth=SYSPROP -Denv-value.seventh=SYSPROP -Denv-value.eighth=SYSPROP waitt:run
```

アプリケーションが起動したら、メニューに存在する「検証画面」のリンクをクリックし、検証用画面に遷移する。  
そして、検証画面に存在する「実行」ボタンをクリックする。

検証結果がログ（標準出力）に出力されるので、以下の期待される結果と比較する。

**期待される結果**

|キー               |設定ファイル       |環境変数     |システムプロパティ|期待値            |
|-------------------|-------------------|-------------|------------------|------------------|
|`env-value.first`  |                   |             |                  |`null`            |
|`env-value.second` |`CONF`             |             |                  |`CONF`            |
|`env-value.third`  |                   |`ENV`        |                  |`null`            |
|`env-value.fourth` |`CONF`             |`ENV`        |                  |`ENV`             |
|`env-value.fifth`  |                   |             |`SYSPROP`         |`SYSPROP`         |
|`env-value.sixth`  |`CONF`             |             |`SYSPROP`         |`SYSPROP`         |
|`env-value.seventh`|                   | `ENV`       |`SYSPROP`         |`SYSPROP`         |
|`env-value.eighth` |`CONF`             | `ENV`       |`SYSPROP`         |`SYSPROP`         |

