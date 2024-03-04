fun main(){
    var answer = 64
    var chessBoard = listOf<String>()
    var arrayOfPosB = listOf<Pair<Int, Int>>()
    var arrayOfPosR = listOf<Pair<Int, Int>>()
    for (i in 0..7) {
        chessBoard += readln().trim()
        for (j in 0..7) {
            if (chessBoard[i][j] == 'B')
                arrayOfPosB += (i to j)
            if (chessBoard[i][j] == 'R')
                arrayOfPosR += (i to j)
        }
    }
    var chessBoardConverted = listOf<String>()
    for (i in 0..7) {
        var row = ""
        for (j in 0..7)
            row += chessBoard[j][i]
        chessBoardConverted+=row
    }

    for (pos in arrayOfPosR){
        answer -=1
        var row = chessBoard[pos.first]
        var column = chessBoardConverted[pos.second]
        while (("R*" in row)) {
            row = row.replace("R*", "R")
            answer -= 1
        }
        while (("*R" in row)) {
            row = row.replace("*R", "R")
            answer -= 1
        }
        while (("R*" in column)) {
            column = column.replace("R*", "R")
            answer -= 1
        }
        while (("*R" in column)) {
            column = column.replace("*R", "R")
            answer -= 1
        }
    }

    for (pos in arrayOfPosB){
        answer-=1
        var diagonal1 = charArrayOf('_','_','_','_','_','_','_','_')
        diagonal1[pos.second] = 'B'
        var rowPos = pos.first
        var columnPos = pos.second

        while (rowPos>0 && columnPos>0){
            rowPos-=1
            columnPos-=1
            diagonal1[columnPos] = chessBoard[rowPos][columnPos]
        }
        rowPos = pos.first
        columnPos = pos.second
        while (rowPos<7 && columnPos<7){
            rowPos+=1
            columnPos+=1
            diagonal1[columnPos] = chessBoard[rowPos][columnPos]
        }

        var diagonal2 = charArrayOf('_','_','_','_','_','_','_','_')
        diagonal2[pos.second] = 'B'
        rowPos = pos.first
        columnPos = pos.second

        while (rowPos>0 && columnPos<7){
            rowPos-=1
            columnPos+=1
            diagonal2[columnPos] = chessBoard[rowPos][columnPos]
        }
        rowPos = pos.first
        columnPos = pos.second
        while (rowPos<7 && columnPos>0){
            rowPos+=1
            columnPos-=1
            diagonal2[columnPos] = chessBoard[rowPos][columnPos]
        }

        var d1 = String(diagonal1)
        var d2 = String(diagonal2)

        while (("B*" in d1)) {
            d1 = d1.replace("B*", "B")
            answer -= 1
        }
        while (("*B" in d1)) {
            d1 = d1.replace("*B", "B")
            answer -= 1
        }
        while (("B*" in d2)) {
            d2 = d2.replace("B*", "B")
            answer -= 1
        }
        while (("*B" in d2)) {
            d2 = d2.replace("*B", "B")
            answer -= 1
        }
    }


    println(answer)
}