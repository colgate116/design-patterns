import figures.Figure

class SideController {
    companion object {
        private var currentSide = Side.ATTACK
    }
    fun getCurrentSide(): Side {
        return currentSide
    }

    //todo переворот доски
    //todo подумать куда положить графическую и пользовательскую логику переключения стороны
    fun sideControl(){
        when (currentSide){
            Side.ATTACK -> {
                currentSide = Side.PROTECTION
            }
            Side.PROTECTION -> {
                currentSide = Side.ATTACK
            }
        }

    }

    fun sidePermissionToInteractionWithFigure(figure: Figure){
        if (figure.getFigureSide()!=currentSide)
            throw Exception("Сейчас ход другой стороны")
    }
}
