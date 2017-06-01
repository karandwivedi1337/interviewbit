import java.util.*;
public class AbsDiff{

	public int getmin(int a, int b, int c){
		return Math.min(Math.min(a,b), c);
	}

	public int getmax(int a, int b, int c){
		return Math.max(Math.max(a,b), c);
	}

	public int solve(ArrayList<Integer> A, ArrayList<Integer> B, ArrayList<Integer> C) {

		int pos1 = A.size()-1;
		int pos2 = B.size()-1;
		int pos3 = C.size()-1;
		int n1=0, n2=0, n3=0;
		int mindiff = Integer.MAX_VALUE;	
		while(pos1>=0 && pos2>=0 && pos3>=0){
			n1 = A.get(pos1);
			n2 = B.get(pos2);
			n3 = C.get(pos3);

			int max = getmax(n1, n2, n3);			
			int diff =  Math.abs(getmax(n1,n2,n3) - getmin(n1,n2,n3));
			
			if(diff < mindiff){
				mindiff = diff;
			}

			if(max == n1){
				pos1--;
			}
			else if(max == n2){
				pos2--;
			}
			else{
				pos3--;
			}
		} 			
		System.out.println("pos1="+pos1+" n1="+n1);	
		System.out.println("pos1="+pos2+" n1="+n2);
		System.out.println("pos3="+pos3+" n1="+n3);
		return mindiff;
	}

	public static void main(String args[])throws Exception{
		AbsDiff ad = new AbsDiff();
		ArrayList<Integer> a = new ArrayList<>(Arrays.asList(52, 94, 109, 149, 186, 214, 218, 235, 236, 285, 324, 352, 390, 393, 409, 445, 485, 498, 545, 582, 625, 630, 643, 657, 690, 731, 757, 783, 806, 807, 856, 895, 895, 916, 944, 987, 997, 1033, 1054, 1084, 1110, 1140, 1150, 1176, 1208, 1231, 1237, 1239, 1261, 1307, 1336, 1374, 1394, 1429, 1457, 1503, 1529, 1542, 1547, 1571, 1591, 1624, 1629, 1671, 1687, 1723, 1743));
		ArrayList<Integer> b = new ArrayList<>(Arrays.asList(-255, -245, -218, -206, -181, -157, -113, -84, -41, -40, -37, 12, 22, 68, 98, 132, 153, 188, 203, 209, 255, 284, 294, 307, 336, 336, 368, 406, 443, 459, 488, 532, 563, 578, 619, 630, 648, 653, 657, 698, 729, 757, 759, 805, 836, 862, 886, 912, 931, 962, 990, 1033, 1067, 1114, 1149, 1186, 1225, 1274, 1287, 1287, 1321, 1361, 1392, 1430, 1435, 1459, 1491, 1503, 1530, 1552, 1598, 1626, 1638, 1658, 1697, 1710, 1748, 1793, 1798, 1798, 1822, 1854, 1871, 1906, 1918, 1961, 1971, 2016, 2052, 2080, 2112, 2137, 2158, 2177, 2202));
		ArrayList<Integer> c = new ArrayList<>(Arrays.asList(24, 49, 62, 78, 91, 135, 136, 136, 185, 213, 221, 231, 265, 276, 292, 311, 311, 341, 341, 375, 403, 424, 462, 490, 514, 553, 575, 618, 629, 658, 667, 701, 747, 761, 778, 814, 837, 844, 867, 913, 943, 951, 984, 1026, 1034, 1060, 1066, 1070, 1089, 1121, 1126, 1141, 1188, 1225, 1236, 1270, 1278, 1313, 1335, 1362, 1401, 1406, 1429, 1457, 1487, 1527, 1551, 1600, 1619, 1667, 1712, 1751, 1782, 1831, 1870, 1892, 1905, 1926, 1948, 1975, 2006, 2036, 2060, 2079));
		System.out.println(ad.solve(a,b,c));
	}}
