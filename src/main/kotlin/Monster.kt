class Monster(
    attack: Int,
    protection: Int,
    maxHealth: Int,
    startOfRangeDamage: Int,
    endOfRangeDamage: Int
) : Creature(attack, protection, maxHealth, startOfRangeDamage, endOfRangeDamage,
) {
    override fun getInfo() {
        if (!isAlive) {
            println("Вы мертвы")
        } else {
            println("У Вас осталось $health здоровья")
        }
    }

}