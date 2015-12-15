# Проект "stadium"

Функции:
1) Аутентификация в приложение через Spring Security LDAP. /login
2) Представление с пользователями и группами /index.html

Структура проекта:
 Application- @SpringBootApplication, также импортирует файлы из /config.
// для запуска прокта использовать этот класс.
resources
application.properties - настройки приложения и системных переменных
wro - настройки для плагина управления зависемостями JS (импортится на страницы <script src="js/angular-bootstrap.js" type="text/javascript"></script>)
public/js - модули AngularJS (необходимо делать для каждой функциональности свой модуль, а не записывать всё в один файл js)
подключаются к страницам перед </body> (для общего подхода и удобства поиска зависемых скриптов).
<script src="js/angular-bootstrap.js" type="text/javascript"></script>
<script src="js/storeModule.js"></script>
public/*.html - страницы сайта, доступны только после аутентификации
controller - REST Контролеры для взаимодействия с серверной частью приложения со страниц сайта.
GroupController
IndexController - переименую в UserController
config - Java Configuration.
LdapConfiguration - подключение к Spring LDAP
SecurityConfiguration extends WebSecurityConfigurerAdapter
service - абстракция над DAO
dao - классы для работы с сервером LDAP
AbstractLdapDao
- LdapTemplate - подключение к серверу LDAP
GroupDao - запросы групп через LdapTemplate
UserDao - запросы пользователей через LdapTemplate
mapper - ипользуется для маппинга структуры LDAP в объектную модель
CnAttributesMapper - если необходимо мапить cn - имена объектов
GroupAttributesMapper - маппинг групп
UserAttributesMapper - маппинг пользователей
model - модели из LDAP
Group - группы
User - пользователи
In 3 branches:
 HEAD, master, origin/master
