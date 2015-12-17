package src.main.java;

public class Question2 {
   
	/*
	 * 処理の開始
	 */
	public static void main(String[] args) {
		int[] arr = { 5, 4, 2, 3, 8, 7, 1, 0, 6, 9 };

		System.out.print("ソート前：");
		arrayPrintln(arr);

		quickSort(arr, 0, arr.length - 1);

		System.out.print("ソート後：");
		arrayPrintln(arr);
	}

	/*
	  * 軸要素の選択
	  * 順に見て、最初に見つかった異なる2つの要素のうち、
	  * 大きいほうの番号を返します。
	  * 全部同じ要素の場合は -1 を返します。
	  */
	static int pivot(int[] a, int i, int j) {
		int k = i + 1;

		//ここに処理を記載してください
		while (k <= j && a[i] == a[k])
			k++;
		if (k > j)
			return -1;
		if (a[i] >= a[k])
			return i;

		return k;
	}

	/*
	 * パーティション分割
	 * a[i]～a[j]の間で、x を軸として分割します。
	 * x より小さい要素は前に、大きい要素はうしろに来ます。
	 * 大きい要素の開始番号を返します。
	 */
	static int partition(int[] a, int i, int j, int x) {
		int l = i, r = j;
		int tmp = 0;
		boolean aflag = false, bflag = false;

		//ここに処理を記載してください
		while (l <= r) {
			if (a[l] < x) { //左端より軸要素より小さい値なら検索を次に進める
				l++;
			} else {
				aflag = true;
			}
			if (a[r] >= x) { //右端より軸要素より大きい値なら検索を次に進める
				r--;
			} else {
				bflag = true;
			}
			if (aflag && bflag) { //入れ替え処理
				tmp = a[l];
				a[l] = a[r];
				a[r] = tmp;
				aflag = false;
				bflag = false;
				l++;
				r--;
			}
		}
		return l;
	}

	/*
	 * クイックソート（再帰用）
	 * 配列aの、a[i]からa[j]を並べ替えます。
	 */
	public static void quickSort(int[] a, int i, int j) {
		if (i == j)
			return;
		int p = pivot(a, i, j);
		if (p != -1) {
			int k = partition(a, i, j, a[p]);
			quickSort(a, i, k - 1);
			quickSort(a, k, j);
		}
	}

	//配列の値を出力するメソッド
	public static void arrayPrintln(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("");
	}
}