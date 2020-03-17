### Project status [![Build status](https://ci.appveyor.com/api/projects/status/dx9mfbtjgb7573ut?svg=true)](https://ci.appveyor.com/project/marinagagarina/pageobjecttest1)

## Домашнее задание к занятию «2.4. BDD»

### Задача №1 - Page Object's

Необходимо "добить" тестирование функции перевода с карты на карту. 
Разработчики пока реализовали возможность перевода только между своими 
картами, но уже хотят, чтобы вы всё протестировали.

Для этого они не поленились и захардкодили целого одного пользователя:
````
* login: 'vasya'
* password: 'qwerty123'
* verification code (hardcoded): '12345'
* cards:
    * first:
        * number: '5559 0000 0000 0001'
        * balance: 10 000 RUB
    * second:
        * number: '5559 0000 0000 0002'
        * balance: 10 000 RUB
````
После логина мы получаем список карт.
Нажав на кнопку "Пополнить" переходим на страницу перевода средств.
При успешном переводе, возвращаемся назад на страницу со списком карт.

Нужно через Page Object'ы добавить доменные методы:

* Перевода с определённой карты на другую карту n'ой суммы
* Проверки баланса по карте (со страницы списка карт).