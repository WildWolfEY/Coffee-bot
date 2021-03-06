# Кофебот

Хакатон ФК «Открытие» 09.11.2019 - 11.11.2019. Команда: Wild Wolf

**Общее описание**

Приложение «Кофебот» позволяет находить случайные пары для общения в соответствии с ТЗ. Бот представляет собой Web-приложение, доступное по ссылке в браузере на компьютере. Любой сотрудник ФК «Открытие» может зайти на сайт бота, зарегистрироваться и подобрать случайную пару для встречи. Серверная часть приложения написана на Java.

**Как запустить**

Во внутренней сети перейти по URL в браузере (желательно браузер Chrome) компьютера: 10.80.62.175:8080/coffee-bot

**Алгоритм подбора пары**

Пользователь регистрируется на сайте. Сразу после этого он попадает в список свободных собеседников.

Любой свободный собеседник может быть приглашен на встречу, инициированную другим собеседником, либо может сам инициировать встречу. Для инициирования встречи пользователь нажимает кнопку «Старт». Приложение выбирает одного другого свободного собеседника из указанного офиса случайным образом.

Оба собеседника становятся занятыми. Обоим собеседникам приходят письма e-mail с указанием имени и электронной почты противоположного собеседника, с помощью которых собеседники самостоятельно связываются друг с другом и договариваются о встрече. У занятого собеседника на сайте бота отображается стикер с сообщением, что встреча назначена.

Любой из собеседников пары может отменить (завершить) встречу нажатием кнопки «Стоп» на сайте. В этом случае противоположный собеседник получает письмо на e-mail с сообщением об отмене и занятость обоих собеседников сбрасывается (они становятся свободными). Занятость каждого собеседника автоматически сбрасывается через одну неделю.

Пользователь может временно деактивировать себя в системе («выйти из игры»). В этом случае он не будет назначаться на встречи. Для этого он нажимает на сайте кнопку «Выход». Для возвращения в систему нужно нажать на сайте кнопку «Вход».

Если нет свободных собеседников для данного пользователя, то пользователь встает в «ожидание»: система делает периодические повторные запросы, пока не произойдет успешное создание встречи.

**Основной сценарий для демонстрации**

1. Пользователь заходит на сайт. Если пользователь не авторизован или не зарегистрирован, то он попадает на страницу входа.
2. На странице входа (с изображением двери) пользователь регистрируется. Для этого он нажимает на значок «журнал», затем в открывшемся окне вводит свои регистрационные данные и нажимает «Ок».
3. Для входа на сайт зарегистрированный пользователь нажимает на значок «ключ» на странице входа, затем в открывшемся окне вводит логин и пароль и нажимает «Ок».
4. После этого пользователь попадает на основную страницу сайта с изображением кофе-машины.
5. На основной странице сайта пользователь может указать свои предпочтения к предстоящему разговору, нажав соответствующие кнопки в верхней части изображения кофе-машины. Эти данные позже (при назначении встречи) будут переданы собеседнику в письме на e-mail.
6. Пользователь инициирует встречу, нажатием кнопки в правой части кофе-машины с изображением треугольника («Старт»).
7. Система подбирает пару и отправляет пользователю письмо на e-mail с данными подобранного собеседника. На основной странице сайта появляется желтый стикер с сообщением, что встреча назначена.
8. Чтобы завершить или отменить встречу и чтобы вновь стать свободным собеседником, пользователь нажимает на кнопку в левой части кофе-машины с изображением квадрата («Стоп»).

**Комментарии (в т. ч. о выполнении ТЗ)**

- Пользователь указывает свое имя (имя и фамилию), контакты и локацию при регистрации. Имя и контакты сообщаются по e-mail подобранному собеседнику.
- Пользоваться кофеботом могут только авторизованные пользователи.
- Пользователь активен сразу после регистрации, то есть может стать приглашенным или может сам инициировать встречу. Пользователь может отклонить приглашение, а также может отключать и вновь включать свою активность.
- Пары формируются для пользователей только одной локации.
- Пользователи оповещаются о встрече по e-mail.
- Допфича: реализовано ожидание, если отсутствуют свободные активные собеседники.
- Допфича: пользователь, инициирующий встречу, может указать свои предпочтения по предстоящему разговору (текст электронного письма-приглашения составляется на основе выбранных опций).
- Кофебот размещен во внутренней сети.
- Кофебот доступен каждому сотруднику, регистрация осуществляется по внутренней электронной почте. Кофебот проверяет вводимую электронную почту на принадлежность к ФК «Открытие» (домен @open.ru).
- Некоторые элементы интерфейса имеют подсказки, которые отображаются в нижней части экрана


PS: Пожалуйста, вводите данные при авторизации максимально правильно, так как пока нет админки и никак не исправить косяки, только вычищать всё хранилище (оно пока только в оперативной памяти.)
