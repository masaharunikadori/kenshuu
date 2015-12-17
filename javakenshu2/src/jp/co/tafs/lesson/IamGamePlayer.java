package jp.co.tafs.lesson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IamGamePlayer {
	public static void main(String[] arg) {

		//入力ストリームの生成
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = "";
		boolean flag = true;

		System.out.println("どちらのゲーム機で遊びますか？半角英数字１～２で入力してください。");
		System.out.println("1.Gamecube   2.PS4");
		try {
			str = br.readLine();
		} catch (IOException e1) {
			// TODO 自動生成された catch ブロック
			e1.printStackTrace();
		}

		if (str.equals("1")) {
			//ゲーム機のインスタンスの生成
			Hardware hd = new Hardware();

			//ゲーム機の情報の取得
			hd.getInfo();
			while (flag) {
				System.out.println("操作を半角英数字1～4で入力してください。\n１．電源を入れる。２．電源を落とす。３．ソフトを入れる。４．ソフトを取り出す。５．ゲームをプレイする.");

				try {
					str = br.readLine();

					switch (str) {
					//１．電源を入れる。
					case "1":
						hd.PowerOn();
						break;
					//２．電源を落とす。
					case "2":
						hd.PowerOff();
						flag = false;
						break;
					//３．ソフトを入れる。
					case "3":
						System.out.println("何を入れますか？");
						str = br.readLine();
						hd.setSoft(str);
						break;
					//４．ソフトを取り出す。
					case "4":
						hd.outSoft();
						break;
					//５．ゲームをプレイする.
					case "5":
						hd.Pley();

						//感想の出力
						System.out.println("感想;Very fun!");
						break;
					//１～５以外の値が入力された時
					default:
						System.out.println("1~4の数値を入力してください。");
					}
				} catch (Exception e) {
					System.out.println(e); //エラーの出力
				}
				System.out.print("\n");
			}
		}

		else if (str.equals("2")) {
			//ゲーム機のインスタンスの生成
			PS4 hd = new PS4();

			//ゲーム機の情報の取得
			hd.getInfo();
			while (flag) {
				System.out
						.println("操作を半角英数字1～9で入力してください。\n１．電源を入れる。２．電源を落とす。３．ソフトを入れる。４．ソフトを取り出す。５．指定のソフトを取り出す \n6.インストールされているソフトの表示 7.ゲームソフトを選ぶ 8.アクティブなゲームの表示 9.ゲームをプレイする");

				try {
					str = br.readLine();

					switch (str) {
					//１．電源を入れる。
					case "1":
						hd.PowerOn();
						break;
					//２．電源を落とす。
					case "2":
						hd.PowerOff();
						flag = false;
						break;
					//３．ソフトを入れる。
					case "3":
						System.out.println("何を入れますか？");
						str = br.readLine();
						hd.setSoft(str);
						break;
					//４．ソフトを取り出す。
					case "4":
						hd.outSoft();
						break;
					//５．指定のソフトを取り出す。
					case "5":
						System.out.println("何を削除しますか？ソフト名を入力してください。");
						str = br.readLine();
						hd.outSoft(str);
						break;
					//6．インストールされているソフトの表示。
					case "6":
						hd.getSoftList();
						break;
					//7．ゲームソフトを選ぶ
					case "7":
						hd.getSoftList();
						System.out.println("何をプレイしますか？半角数字で入力してください。");
						str = br.readLine();
						hd.SelectSoft(Integer.parseInt(str));
						break;
					//8．アクティブなゲームの表示
					case "8":
						hd.getActiveSoft();
						break;
					//9．ゲームをプレイする.
					case "9":
						hd.Pley();
						//感想の出力
						System.out.println("感想;Very fun!");
						break;
					//１～５以外の値が入力された時
					default:
						System.out.println("1~4の数値を入力してください。");
					}
				} catch (Exception e) {
					System.out.println(e); //エラーの出力
				}

				System.out.print("\n");
			}
		}
		else {
			System.out.print("エラー　半角英数字１～２で入力してください。");
		}

	}
}
