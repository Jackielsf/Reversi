package com.lsf.reversi.app.util;

import android.util.Log;

import com.lsf.reversi.app.game.Constant;

public class HistoryUtil {

	private static byte[][] chessBoard1 = new byte[8][8];
	private static byte[][] chessBoard2 = new byte[8][8];
	private static byte[][] chessBoard3 = new byte[8][8];

	public static void updateUtil(byte[][] src) {
		if (isNull(chessBoard1)) {
			Util.copyBinaryArray(src, chessBoard1);
		} else {
			if (isNull(chessBoard2)) {
				Util.copyBinaryArray(chessBoard1, chessBoard2);
				Util.copyBinaryArray(src, chessBoard1);
			} else {
				Util.copyBinaryArray(chessBoard2, chessBoard3);
				Util.copyBinaryArray(chessBoard1, chessBoard2);
				Util.copyBinaryArray(src, chessBoard1);
			}
		}
	}

	public static byte[][] regretUtil() {
		byte[][] temp = Util.initChessBoard();
		if (!isNull(chessBoard3)) {
			Util.copyBinaryArray(chessBoard1, temp);
			Util.copyBinaryArray(chessBoard2, chessBoard1);
			Util.copyBinaryArray(chessBoard3, chessBoard2);
			setNull(chessBoard3);
		} else {
			if (!isNull(chessBoard2)) {
				Util.copyBinaryArray(chessBoard1, temp);
				Util.copyBinaryArray(chessBoard2, chessBoard1);
				setNull(chessBoard2);
			} else {
				Util.copyBinaryArray(chessBoard1, temp);
				setNull(chessBoard1);
			}
		}
		Log.w("regret<<<", showArray(temp));
		return temp;
	}

	private static boolean isNull(byte[][] src){
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++){
				if(src[i][j] != 0){
					return false;
				}
			}
		return true;
	}

	private static void setNull(byte[][] src) {
		src = Util.initChessBoard();
	}

	private static String showArray(byte[][] src) {
		String str = "";
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++) {
				str = str + src[i][j] + ",";
			}
		return str;
	}
}
