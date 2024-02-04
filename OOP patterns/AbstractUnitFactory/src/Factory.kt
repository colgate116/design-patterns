interface Factory {
    fun createMage(): Mage
    fun createBeast(): Beast
    fun createKnight(): Knight
}

class BlueUnitsFactory(): Factory {
    override fun createMage(): Mage {
        return BlueMage()
    }

    override fun createBeast(): Beast {
        return BlueBeast()
    }

    override fun createKnight(): Knight {
        return BlueKnight()
    }
}

class RedUnitsFactory(): Factory{
    override fun createMage(): Mage {
        return RedMage()
    }

    override fun createBeast(): Beast {
        return RedBeast()
    }

    override fun createKnight(): Knight {
        return RedKnight()
    }

}

class GreenUnitsFactory(): Factory {
    override fun createMage(): Mage {
        return GreenMage()
    }

    override fun createBeast(): Beast {
        return GreenBeast()
    }

    override fun createKnight(): Knight {
        return GreenKnight()
    }
}