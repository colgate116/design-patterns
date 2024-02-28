class PlayerActionController {
    private fun getAction(): Triple<Pair<Char, Int>, Pair<Char, Int>, Action> {
        val actionType: Action
        val oldPosition: Pair<Char, Int>
        val newPosition: Pair<Char, Int>
        val action = readln().trim()
        try {
            oldPosition = action[0] to action[1].digitToInt()
            newPosition = action[3] to action[4].digitToInt()
            actionType = when (action[2]) {
                '-' -> Action.MOVE
                ':' -> Action.ATTACK
                else -> throw Exception("Неизвестное действие")
            }
            return Triple(oldPosition, newPosition, actionType)
        } catch (_: Exception) {
            throw Exception("Неправильно оформлена запись действия")
        }
    }

    fun runAction(){
        val action = getAction()
        val figure = ChessBoardLogic.getCellCondition(action.first)
        if (figure!=null)
            SideController().sidePermissionToInteractionWithFigure(figure)
        ChessBoardLogic.interactionWithFigure(action.first, action.second, action.third)
    }
}

enum class Action{MOVE, ATTACK}