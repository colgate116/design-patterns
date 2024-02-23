abstract class UnitConfigs {
    abstract val health: Int
    abstract val power: Int
    abstract val stamina: Int
}

class FirstLevelUnitConfig: UnitConfigs() {
    override val health: Int
        get() = 10
    override val power: Int
        get() = 10
    override val stamina: Int
        get() = 10
}

class SecondLevelUnitConfig: UnitConfigs() {
    override val health: Int
        get() = 20
    override val power: Int
        get() = 20
    override val stamina: Int
        get() = 20
}

class ThirdLevelUnitConfig: UnitConfigs() {
    override val health: Int
        get() = 30
    override val power: Int
        get() = 30
    override val stamina: Int
        get() = 30
}

