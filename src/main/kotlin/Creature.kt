import kotlin.random.Random

abstract class Creature(
    attack: Int,
    protection: Int,
    val maxHealth: Int,
    private val startOfRangeDamage: Int,
    private val endOfRangeDamage: Int
) {

    var isAlive = true

    private var attackParam: Int = 0
        set(value) {
            field = if (value < 1) {
                1
            } else if (value > 30) {
                30
            } else {
                value
            }
        }

    private var protectionParam: Int = 0
        set(value) {
            field = if (value < 1) {
                1
            } else if (value > 30) {
                30
            } else {
                value
            }
        }

    protected var _health: Int = 0
        set(value) {
            field = if (value < 1 && isAlive) {
                1
            } else {
                value
            }
        }
    val health: Int
        get() = _health

    private var startOfRange: Int = 0
        set(value) {
            field = if (value < 1) {
                1
            } else {
                value
            }
        }

    private var endOfRange: Int = 0
        set(value) {
            field = if (startOfRangeDamage > endOfRangeDamage) {
                startOfRange + 1
            } else  {
                value
            }
        }

    init {
        _health = maxHealth
        attackParam = attack
        protectionParam = protection
        startOfRange = startOfRangeDamage
        endOfRange = endOfRangeDamage
    }

    private val damage = (startOfRange..endOfRange).toList().toIntArray()


    abstract fun getInfo()


    fun attackTheEnemy(defendingCreature: Creature) {
        if (!isAlive) {
            println("Вы умерли и не можете больше атаковать врага!")
            return
        }
        val attackMod = if ((attackParam - defendingCreature.protectionParam) < 1) {
            1
        } else {
            attackParam - defendingCreature.protectionParam + 1
        }
        val listOfAttempts = mutableListOf<Int>()
        repeat(attackMod) {
            listOfAttempts.add(Random.nextInt(1, 7))
        }
        if (listOfAttempts.max() >= 5) {
            val randomChoice = damage[Random.nextInt(0, damage.size)]
            if (defendingCreature.health < randomChoice) {
                defendingCreature.isAlive = false
                defendingCreature._health = 0
            } else {
                defendingCreature._health -= randomChoice
            }
        } else {
            println("Промах!")
        }
    }

}