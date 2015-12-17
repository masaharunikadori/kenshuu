package jp.co.tafs.lesson;

import java.util.ArrayList;

public class PS4 extends Hardware {

	ArrayList<String> SoftList = new ArrayList<String>();

	//ハードの情報をセットする
	public PS4() {
		setHardName("PS4");
		setHardMaker("ソニー");
		setNet(true);
		setReleaseDate("2013-9-9");
		setPrice(35000);
	}

	//ソフトをセットする(オーバーライド)
	public void setSoft(String SoftName) throws Exception {
		if (!getPowerState()) {
			throw new Exception("電源が入っていません");
		} else if (SoftList.indexOf(SoftName) == -1) {
			if (SoftList.size() <= 4) {
				System.out.println("新しいゲームです。追加インストールを行います。");
				SoftList.add(SoftName);
				super.setSoft(SoftName);
				System.out.println(SoftName + "をインストールしました。");
			} else {
				System.out.println("ソフトをインストールする容量がありません。");
			}
		}
	}

	//ソフトを取り出す(オーバーライド)
	public void outSoft() throws Exception {
		if (!getPowerState()) {
			throw new Exception("電源が入っていません");
		} else if (SoftList.size() >= 1) {
			System.out.println("ソフト" + SoftList.get(0) + "を削除しました。");
			SoftList.remove(0);
		} else {
			throw new Exception("ソフトがインストールされていません。");
		}
	}

	//指定のソフトを取り出す(オーバーロード)
	public void outSoft(String SoftName) throws Exception {
		if (!getPowerState()) {
			throw new Exception("電源が入っていません");
		} else if (SoftList.indexOf(SoftName) != -1) {
			System.out.println("ソフト" + SoftList.get(SoftList.indexOf(SoftName)) + "を削除しました。");
			SoftList.remove(SoftList.indexOf(SoftName));
		} else {
			throw new Exception("そのようなソフトはインストールされていません。");
		}
	}

	//ゲームソフトを選ぶ
	public void SelectSoft(int str) throws Exception {
		if (!getPowerState()) {
			throw new Exception("電源が入っていません");
		} else if (str <= SoftList.size() && SoftList.size() > 0) {
			super.setSoft(SoftList.get(str - 1));
		}
	}

	//インストールされているソフトの一覧表示
	public void getSoftList() throws Exception {
		if (!getPowerState()) {
			throw new Exception("電源が入っていません");
		} else {
			System.out.println("--------------------------------インストール済みのソフト--------------------------------");
			for (int i = 0; i < SoftList.size(); i++) {

				System.out.println(i + 1 + ":" + SoftList.get(i));
			}
			System.out.println("--------------------------------インストール済みのソフト--------------------------------");
		}
	}
}
