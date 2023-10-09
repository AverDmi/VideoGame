fun main() {

    /*
    Создаем Игрока и Монстра
    1. Если параметр атаки или защиты будет меньше допустимого значения, он установится в минимально допустимое,
     а если будет больше допустимого значения, он установится в максимально допустимое
    2. Если параметр здоровья будет меньше 1, он установится равным 1, так как если здаровье равно 0,
     то Существо умирает
    3. Так как параметр Урон - это диапазон натуральных чисел M-N, то он не числа не могут быть меньше 1
     и начало диапазона не может быть меньше его конца. В таком случае диапазон будет равет M-(M+1)
     */
    val player = Player(20, 10, 15, 1, 3)
    val monster = Monster(20, 10, 15, 1, 3)

    /*
    Пробуем атаковать Монстром Игрока и смотрим на его показатель здоровья
    Модификатор атаки равен разности Атаки атакующего и Защиты защищающегося плюс 1. Но он не может быть меньше 1,
    так как он равен броску кубиков, который бросается хотя бы 1 раз
     */
    monster.attackTheEnemy(player)
    player.getInfo()
    println()
    monster.attackTheEnemy(player)
    player.getInfo()
    println()
    monster.attackTheEnemy(player)
    player.getInfo()
    println()

    /*
    Пробуем полечить Игрока. Игрок может себя исцелить до 4-х раз на 30% от максимального Здоровья.
     */
    player.heal()
    player.getInfo()
    println()
    player.heal()
    player.getInfo()
    println()
    player.heal()
    player.getInfo()
    println()
    player.heal()
    player.getInfo()
    println()
    player.heal()
    player.getInfo()
    println()

    /*
    Убиваем Игрока :(
     */
    while (player.health > 0) {
        monster.attackTheEnemy(player)
        player.getInfo()
        println()
    }
}