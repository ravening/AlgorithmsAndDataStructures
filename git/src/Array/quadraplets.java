import java.util.*;
public class quadraplets {

	public static void quads(int[] arr) {
		if (arr == null || arr.length ==0) {
			return;
		}
		
		HashMap<Integer, pair> map = new HashMap<Integer, pair>();

		for (int i =0; i < arr.length; i++) {
			for (int j = i+1; j < arr.length; j++) {
				int sum = arr[i] + arr[j];
				
				if (!map.containsKey(sum)) {
					map.put(sum, new pair(i,j));
				} else {
					if (sum == arr[i] + arr[j]) {
					pair tmp = map.get(sum);
					System.out.println("(" + arr[i] + "," + arr[j] + ")" + " " + "(" + arr[tmp.first] + "," + arr[tmp.second] + ")");
				}
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {3,4,7,1,2,9,8};
		quads(arr);
	}

}

class pair {
	public int first;
	public int second;
	
	pair(int f, int s) {
		this.first = f;
		this.second = s;
	}
}
