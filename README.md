# Du

Вариант 7 - Du
Вывод на консоль размера указанного файла(-ов) или каталога(-ов) из файловой системы:
* fileN задает имя файла, размер которого нужно вывести. Таких параметров может быть несколько.
* Флаг -h указывает, что размер следует выдавать в человеко-читаемом формате: в зависимости от размера файла резльтатвыдается в батах,
килобайтах, мегабайтах или гигабайтах и дополняется соответствующей единицей измерения (B, КВ, МВ, GB). Если данный флаг не указан, размер
должен печататься в килобайтах и без единицы измерения.
* Флаг -с означает, что для всех переданных на вход файлов нужно вывести суммарный размер.
* Флаг -si означает, что для всех используемых едениц измерения следует брать основание 1000, а не 1024.

Command Line: du [-h] [-c] [-si] file1 file2 file3...

На вход может быть передано любое количество имен файлов. Все флаги совместимы друг с другом. Размер каталога равен сумме размеров всех 
входящих в него файлов и каталогов. Если на вход подается им, не соответствующее существующему файлу, следует вместо результата выдать 
ошибку. Возвращаемое значение в случае успеха равняется 0, в случае ошибки 1.

Кроме самой программы, нужно написать автоматические тесты к ней.