Требования:
1. Браузер - Chrome
2. Размер окна браузера - Максимальный
3. Не должно быть захардкоженных тестовых данных
4. Все пользователи должны храниться в файлах пропертей
5. Все asserts должны быть сохранены на уровне тестов
6. Действия в PageObjects должны быть параметризованы
7. Драйвер должен создаваться и настраиваться в корректных местах
8. Все утилитные методы должны находиться в отдельном утилитном классе
9. По необходимости должны быть использованы явные и неявные ожидания


Задание

1. Add User
Steps
1 Open test site by URL	--> Test site is opened
2 Assert Browser title --> Browser title equals "MantisBT"
3 Perform login -->	User is logged
4 Assert User name in the right-top side of screen that user is loggined --> Name is displayed and equals to expected result
5 Assert left side menu --> Left side menu is exist
6 Click "Manage" button at the left side menu --> "Manage ManitsBT" page opened
7 Click "Manage Users" button at the top menu on the "Manage MantisBT" page --> "Manage Users - ManitsBT" page opened
8 Check "Create New Account" button --> "Create New Account" button exits
9 Click "Create New Account" button --> "Create New Account" view is opened
10 Check fields on the "Create New Account" view -->
   Fields should exist: Username, Real Name, E-Mail, Password , Verify Password, Access Level, Enabled, Protected
11 Fill user information:
   Username: any
   Real Name: any
   E-Mail: any
   Password: any
   Verify Password: any
   Access Level: reporter
   Enabled: true
   Protected: false
   --> Information added
12 Click "Create User" button --> Project created. All information added to the table according test data
13 Logout
14 Login under created user --> User is logged
16 Assert User name in the right-top side of screen that user is loggined
17 Logout
18 Close browser

2. Issue filter
Создать вручную 5 issues
Step
1 Open test site by URL --> Test site is opened
2 Assert Browser title --> Browser title equals "MantisBT"
3 Perform login
4 Assert User name in the right-top side of screen that user is loggined --> Name is displayed and equals to expected result
5 Assert left side menu --> Left side menu is exist
6 Click "View Issues" button at the left side menu --> "View Issues - ManitsBT" page opened
7 Set filter values:
  Priority: high
  Severity: tweak
  Status: assigned
  Filter by Date Submitted: Start Date: 03/27/2019; End Date: 04/01/2019
8 Click Apply Filter
9 Check results --> Should have at least one record
10 Logout
