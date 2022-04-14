# AtonProject
## Eats
Представим на время, что вы black hat, и у вас в распоряжении оказались данные ~30 млн. заказов некоторого сервиса доставки еды за некоторый
период 2021 и 2022 года. Поверхностный анализ показал, что данные содержат 18 758 328 уникальных телефонов с полным именем клиента, а средняя
длина полного имени - 20 символов (латинских или кириллических).
Допустим, вы хотите развернуть веб-сервис, который позволит по номеру телефона найти полное имя клиента. Но вы не хотите оставлять следы на
диске или в базе данных - придется все держать в памяти.
Но еще вы не хотите зря тратить крипту на слишком большой сервер. Поэтому давайте оценим,сколько памяти займут эти данные:
если мы хотим реализовать поиск за постоянное время, т.е. O(1)?
если мы хотим занять как можно меньше памяти?
Самое главное - объяснить, как вы пришли к той или иной числовой оценке. Можно выбрать любой язык программирования/платформу.


## I got you
Два треда, Sonny и Cher, исполняют в консоли дуэтом хит 1965 года "I Got You Babe" (https://youtu.be/BERd61bDY7k). Каждый тред выводит своем имя,
двоеточие и слова песни, например так:
Cher: They say we're young and we don't know
We won't find out until we grow
Необходимо написать программу, в которой треды работают согласованно, так, чтобы строчки, исполняемые в один голос, выводились в консоль в
правильном порядке. Строчки припева (в 2 голоса, отмечены "Sonny, Cher") должны выводиться каждым тредом, но в любом порядке.
Весь текст задан структурой:

String[][] lyrics = {  
{"Cher", "They say we're young and we don't know \nWe won't find out until we grow"},  
{"Sonny", "Well I don't know if all that's true \n'Cause you got me, and baby I got you"},  
{"Sonny", "Babe"},  
{"Sonny, Cher", "I got you babe \nI got you babe"},  
{"Cher", "They say our love won't pay the rent \nBefore it's earned, our money's all been spent"},  
{"Sonny", "I guess that's so, we don't have a pot \nBut at least I'm sure of all the things we got"},  
{"Sonny", "Babe"},  
{"Sonny, Cher", "I got you babe \nI got you babe"},  
{"Sonny", "I got flowers in the spring \nI got you to wear my ring"},  
{"Cher", "And when I'm sad, you're a clown \nAnd if I get scared, you're always around"},  
{"Cher", "So let them say your hair's too long \n'Cause I don't care, with you I can't go wrong"},  
{"Sonny", "Then put your little hand in mine \nThere ain't no hill or mountain we can't climb"},  
{"Sonny", "Babe"},  
{"Sonny, Cher", "I got you babe \nI got you babe"},  
{"Sonny", "I got you to hold my hand"},  
{"Cher", "I got you to understand"},  
{"Sonny", "I got you to walk with me"},  
{"Cher", "I got you to talk with me"},  
{"Sonny", "I got you to kiss goodnight"},  
{"Cher", "I got you to hold me tight"},  
{"Sonny", "I got you, I won't let go"},  
{"Cher", "I got you to love me so"},  
{"Sonny, Cher", "I got you babe \nI got you babe \nI got you babe \nI got you babe \nI got you babe"}  
};  
