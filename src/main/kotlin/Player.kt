import kotlin.math.max

class Player(
    attack: Int,
    protection: Int,
    maxHealth: Int,
    startOfRangeDamage: Int,
    endOfRangeDamage: Int
) : Creature(attack, protection, maxHealth, startOfRangeDamage, endOfRangeDamage,
) {

    private var countOfHeal:Int = 4

    fun heal() {
        if (!isAlive) {
            println("Вы умерли и не можете больше лечить себя!")
            return
        } else if (countOfHeal > 0) {
            val healthGain = (maxHealth * 0.3).toInt()
            if ((health + health) > maxHealth) {
                _health = maxHealth
                println("Вы применили лечение")
            } else {
                _health += healthGain
                println("Вы применили лечение")
            }
            countOfHeal -= 1
        } else {
            println("У вас закончилось лечение!")
        }

    }

    override fun getInfo() {
        if (!isAlive) {
            println("Вы мертвы")
        } else {
            println("У Вас осталось $health здоровья и $countOfHeal раз исцеления")
        }
    }
}