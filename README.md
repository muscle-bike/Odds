# Odds
Spring Bootで開発した金銭管理アプリです。
競馬・競輪・競艇等等のレース情報を入力して管理します。
非常にシンプルな見た目なので視認性に優れています。
## Description
### ホーム画面
登録したレースの情報が確認できます。
全レース、月毎にレース情報を表示、月でのトータル、年のトータルが確認できます。
新規登録画面、編集画面へとアクセスができます。　　
### 新規登録画面
以下の項目を入力しDBに保存します。
・　レース日
・　レース名
・　レース会場
・　支出額
・　収入額　　
### 編集画面
登録してあるレース情報を編集・削除できます。
## DEMO
![新規登録](https://user-images.githubusercontent.com/83861906/137480079-74b82beb-7089-430e-bfce-7fc1d7067ce2.gif)
## Dependency
・　Java SE Development Kit 11　
・　Spring Tool 4.11.0.RELEASE　　　
・　Apache Maven 4　　　
・　Spring Boot 2.4.5「Thymeleaf、Spring Data JPA、Spring Security、　Spring validation」　　　
・　Bootstrap 4.5.3　　　
・　Lombok 1.18.20　
## Setup
1.git　clone
```
git clone https://github.com/muscle-bike/Odds.git
```
2.下記のURLにアクセスしてログイン画面を表示
```
http://localhost:8080/login　
```
## License
MIT License