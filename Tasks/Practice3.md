# Практическое задание №3

С помощью *Eclipse IDE* разработать консольное *Java*-приложение.

## Требования

:one: **Проект** должен называться `Practice3`, корневой пакет - `ua.nure.your_last_name.practice3`.

:two: **Использовать** указанные
    - имена классов и методов;
    - имена файлов со входной информацией.
    
:three: **Кириллица** (буквы русского и украинского языков) во входной информации может быть всюду, где не оговорено специально.
Если приложение считывает информацию из файла, то необходимо указать кодировку, в которой она (информация) записана.
Использовать кодировку **Cp1251**, cм. [пример "Как получить входную информацию"](#%D0%BA%D0%B0%D0%BA-%D0%BF%D0%BE%D0%BB%D1%83%D1%87%D0%B8%D1%82%D1%8C-%D0%B2%D1%85%D0%BE%D0%B4%D0%BD%D1%83%D1%8E-%D0%B8%D0%BD%D1%84%D0%BE%D1%80%D0%BC%D0%B0%D1%86%D0%B8%D1%8E) в конце текста.

:four: **Демонстрировать** функциональность соответствующей подзадачи каждого класса `PartX` с помощью методов `PartX.main`.
В корневом пакете создать класс `Demo`, который демонстрирует работу всего разработанного функционала.

## Задание 1

**Название** класса**: `ua.nure.your_last_name.practice3.Part1`.

**Входную информацию** загружать из файла `part1.txt`.

Определить класс со статическими методами, которые преобразовывают входную информацию в выходную.
В качестве входной информации *(input data)* использовать текст следующей структуры (значения *Login/Name/Email* в общем случае могут быть любыми;
*Login* и *Name* могут содержать латиницу и кириллицу):

Пример *input data (part1.txt)*
```
Login;Name;Email
ivanov;Ivan Ivanov;ivanov@mail.com
петров;Петр Петров;petrov@google.com
obama;Barack Obama;obama@google.com
bush;Джордж Буш;bush@mail.com
```

Методы, которые нужно написать, имеют следующий вид (N - цифра: 3, 4):

```java
public static String convertN(String input) {
    ...
}
```

### 1.1. Метод *convert3*

Должен преобразовывать *input data* в строку следующего вида (почтовый домен ==> список логинов через запятую тех пользователей, чьи почтовые ящики зарегестрированны в данном домене):

Пример *output of convert3*
```
mail.com ==> ivanov, bush
google.com ==> петров, obama
```

### 1.2. Метод *convert4*

Должен преобразовывать *input data* в строку следующего вида (должна быть добавлена колонка *Password*, сам пароль должен состоять ровно из 4 цифр, которые генерируются случайным образом):

Пример *output of convert4*
```
Login;Name;Email;Password
ivanov;Ivan Ivanov;ivanov@mail.com;1707
петров;Петр Петров;petrov@google.com;9321
obama;Barack Obama;obama@google.com;4623
bush;Джордж Буш;bush@mail.com;7514
```

## Задание 2

**Название класса**: `ua.nure.your_last_name.practice3.Part2`.

**Входную информацию** загружать из файла `part2.txt`.

**Вход**: текст (может состоять из латиницы и кириллицы).

**Выход**: слова минимальной длины в формате, который дан ниже (в единственном числе, в порядке их появления в тексте). 
Словом считать последовательность содержащую только буквы (все остальные символы в состав слова не входят).

Создать статический метод `convert`, который преобразовывает вход в выход.

Заглушка метода
```java
public static String convert(String input) {
    ...
}
```

Пример *input data (part2.txt)*
```
When I was younger, so much younger than today
I never needed anybody's help in any way
But now these days are gone, I'm not so self-assured
Now I find I've changed my mind
I've opened up the doors
```

Пример *output*
```
Min: I, s, m
```

## Задание 3

**Название класса**: `ua.nure.your_last_name.practice3.Part3`.

**Входную информацию** загружать из файла `part3.txt`.

**Вход**: текст (может состоять из латиницы и кириллицы).

**Выход**: исходный текст, но регистр первого символа каждого слова, которое состоит из трех и более символов, должен быть интвертирован.
Словом считать последовательность содержащую только буквы (все остальные символы в состав слова не входят).

Создать статический метод convert, который преобразовывает вход в выход.

Заглушка метода
```java
public static String convert(String input) {
    ...
}
```

Пример **input data**
```
When I was younger
I never needed
```

Пример **output**
```
when I Was Younger
I Never Needed
```

## Задание 4

**Название класса**: `ua.nure.your_last_name.practice3.Part4`.

Для хеширования информации (например, паролей) используют метод `MessageDigest#digest`, который возвращает хеш в виде массива байт.

Пример хеширования пароля с помощью алгоритма хеширования *MD5* (другие алгоритмы - *SHA-256*; *SHA-512* и пр.)

```java
import java.security.*;
import java.util.Arrays;
 
public class HashExample {      
    public static void main(String[] args) 
            throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update("password to hash".getBytes());
        byte[] hash = digest.digest();
        System.out.println(Arrays.toString(hash));
        // output: [56, 55, 83, 50, 113, -114, -54, 115, -125, 86, 79, -109, 17, -65, 107, 84]
    }   
}
```

Написать статический метод `hash`, который на вход принимает два параметра: 

- строку, хеш которой нужно получить; 
- названия алгоритма хеширования.

**Выход** должен представлять из себя строку из шестнадцатеричных цифр: 
каждому байту соответствует две шестнадцатеричные цифры. 

Например, если некоторый элемент массива байт равен `-29`, то в двоичном разложении он имеет вид `1110_0011` и ему соответствует пара `E3`.


Заглушка класса `Part4`
```java
import java.security.*;
 
public class Part4 {
    public static String hash(String input, String algorithm) throws NoSuchAlgorithmException {
        // place yhour code here
        return null;
    }
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(hash("password", "SHA-256"));
        System.out.println(hash("passwort", "SHA-256"));
    }
}
```


Если код метода `Part4.main` такой:
```java
System.out.println(hash("asdf", "MD5"));
System.out.println(hash("asdf", "SHA-256"));
```

то результат должен быть таким:
```
912EC803B2CE49E4A541068D495AB570
F0E4C2F76C58916EC258F246851BEA091D14D4247A2FC3E18694461B1816E13B
```

## Задание 5

**Название класса**: `ua.nure.your_last_name.practice3.Part5`.

Создать класс со статическим методом перевода из римской системы счисления в десятичную.

```java
public static int roman2Decimal(String s) { ... }
```

Рабочий диапазон метода - от 1 до 100 включительно.

Работу метода продемонстрировать так `ROMAN -roman2Decimal-> DECIMAL`:
```
I --> 1
II --> 2
III --> 3
IV --> 4
V --> 5
XCIV --> 94
XCV --> 95
XCVI --> 96
XCVII --> 97
XCVIII --> 98
XCIX --> 99
C --> 100
```
	
Брут-форс (полный перебор) **не допускается!** Продумать алгоритм и запрограммировать.

Решение которое использует массив из ста элементов **исключить** из рассмотрения:
```java
String[] numbers = {"I", "II", "III", "IV", "V", ..., "XCV", "XCVI", "XCVII", ..., "C"}
```

## Как получить входную информацию

Файл должен находится в корне проекта, кодировка файла - *Cp1251*
```java
package ua.nure.your_last_name.practice3;
 
import java.io.IOException;
import java.nio.file.*;
 
public class Util {
     
    private static final String ENCODING = "Cp1251";
 
    public static String readFile(String path) {
        String res = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
            res = new String(bytes, ENCODING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return res;
    }
 
    public static void main(String[] args) {
        System.out.println(readFile("part1.txt"));
    }
 
}
```
