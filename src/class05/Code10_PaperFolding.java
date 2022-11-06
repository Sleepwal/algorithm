package class05;

public class Code10_PaperFolding {

	public static void printAllFolds(int N) {
		printProcess(1, N, true);
	}

	//i是节点的层数, N为一共的层数, down为true ? 凹 : 凸
	public static void printProcess(int i, int N, boolean down) {
		if (i > N) {
			return;
		}
		printProcess(i + 1, N, true);
		System.out.println(down ? "凹 " : "凸 ");
		printProcess(i + 1, N, false);
	}

	public static void main(String[] args) {
		int N = 3;
		printAllFolds(N);
	}
}
