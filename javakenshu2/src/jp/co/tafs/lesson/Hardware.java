package jp.co.tafs.lesson;

public class Hardware {

	private String HardName = "Gamecube"; //ハード名
	private String HardMaker = "任天堂"; //メーカー名
	private boolean Net = true; //ネット接続の有無
	private String ReleaseDate = "2001-09-14"; //発売日
	private int Price = 25000; //価格
	private boolean Power = false; //電源
	private String ActiveSoft = null; //入っているソフト

	//電源を入れる
	public void PowerOn() throws Exception {
		if (Power) {
			throw new Exception("電源はすでに入っています。");
		} else {
			Power = true;
			System.out.println("電源を入れました。");
		}
	}

	//電源を落とす
	public void PowerOff() throws Exception {
		if (!Power) {
			throw new Exception("電源はまだ入っていません");
		} else {
			Power = false;
			System.out.println("電源を落としました。");
			System.out.println("see you!");
		}
	}

	//ソフトをセットする
	public void setSoft(String SoftName) throws Exception {
		if (!Power) {
			throw new Exception("電源が入っていません");
		} else {
			ActiveSoft = SoftName;
			System.out.println(SoftName + "をセットしました。");
		}

	}

	//ソフトを取り出す
	public void outSoft() throws Exception {
		if (!Power) {
			throw new Exception("電源が入っていません");
		} else if (ActiveSoft != null) {
			System.out.println("ソフト" + ActiveSoft + "を取り出しました。");
			ActiveSoft = null;
		} else {
			throw new Exception("ソフトが入っていません");
		}
	}

	//ゲームをプレイする
	public void Pley() throws Exception {

		if (!Power) {
			throw new Exception("電源が入っていません。");
		}

		// ゲームソフトの状態をチェックします。
		if (getActiveSoft() == null) {
			throw new Exception("ソフトが入っていません。");
		}
		System.out.println("Pley " + ActiveSoft + "!");
	}

	//電源の状態を取得する
	public boolean getPowerState() {
		return Power;
	}

	//入っているソフトを取得する
	public String getActiveSoft() {
		return ActiveSoft;
	}

	//ハードの情報を取得する。
	public void getInfo() {
		System.out.println("--------------------------------ハード情報--------------------------------");
		System.out.println("ハード名は" + HardName + "です。");
		System.out.println("メーカーは" + HardMaker + "です。");
		if (Net) {
			System.out.println("このハードはネット接続できます。");
		} else {
			System.out.println("このハードはネット接続できません。");
		}
		System.out.println("このハードは" + ReleaseDate + "に発売されました。");
		System.out.println("--------------------------------ハード情報--------------------------------");
	}

	//ハードに情報をセットする
	public void setHardName(String set) {
		HardName = set;
	}

	public void setHardMaker(String set) {
		HardMaker = set;
	}

	public void setNet(boolean set) {
		Net = set;
	}

	public void setReleaseDate(String set) {
		ReleaseDate = set;
	}

	public void setPrice(int set) {
		Price = set;
	}
}
