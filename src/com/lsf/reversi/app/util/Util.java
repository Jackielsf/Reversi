package com.lsf.reversi.app.util;

import com.lsf.reversi.app.game.Constant;

public class Util {

	//拷贝棋盘二维数组
	public static void copyBinaryArray(byte[][] src, byte[][] dest) {
		for (int i = 0; i < 8; i++) {
			System.arraycopy(src[i], 0, dest[i], 0, 8);
		}
	}
	
	public static byte[][] initChessBoard(){
		byte[][] chessBoard;
		chessBoard = new byte[8][8];
		chessBoard[3][3] = Constant.WHITE;
		chessBoard[3][4] = Constant.BLACK;
		chessBoard[4][3] = Constant.BLACK;
		chessBoard[4][4] = Constant.WHITE;
		return chessBoard;
	}
}
